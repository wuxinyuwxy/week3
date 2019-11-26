package com.wxy.service;

import com.wxy.dao.OrderDetailMapper;
import com.wxy.entity.OrderDetail;
import com.wxy.vo.OrderDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailMapper orderDetailMapper;
    @Override
    public Page<OrderDetail> getList(OrderDetailVO orderDetailVO) {
        Pageable pageable = PageRequest.of(orderDetailVO.getPageNum()-1,orderDetailVO.getPageSize());
        Specification<OrderDetail> spec = new Specification<OrderDetail>() {
            @Override
            public Predicate toPredicate(Root<OrderDetail> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
                if(orderDetailVO.getOid()!=null && !orderDetailVO.getOid().equals("")){
                    Predicate p1 = cb.equal(root.get("orders").get("oid"), orderDetailVO.getOid());
                    list.add(p1);
                }
                Predicate[] arr = list.toArray(new Predicate[list.size()]);
                return cb.and(arr);
            }
        };
        return orderDetailMapper.findAll(spec,pageable);
    }

    //添加+修改数据
    @Override
    public boolean save(OrderDetail orderDetail) {
        try {
            if(orderDetail.getGid()!=null){
                //修改数据
                Optional<OrderDetail> byId = orderDetailMapper.findById(orderDetail.getGid());
                if(byId.isPresent()){
                    //修改
                    orderDetailMapper.save(orderDetail);
                    return true;
                }
            }
            //添加数据
            orderDetailMapper.save(orderDetail);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteGids(ArrayList<OrderDetail> gids) {
        //删除数据  批量删除
        try {
            orderDetailMapper.deleteAll(gids);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteGid(String gid) {
        try {
            orderDetailMapper.deleteById(gid);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public OrderDetail getByGid(String gid) {
        return orderDetailMapper.findById(gid).get();
    }

    @Override
    public boolean deleteByOrders_Oid(String oid) {
        orderDetailMapper.deleteByOrders_Oid(oid);
        return true;
    }
}
