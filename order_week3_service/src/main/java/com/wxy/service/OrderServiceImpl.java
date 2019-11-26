package com.wxy.service;

import com.wxy.dao.OrderMapper;
import com.wxy.entity.Orders;
import com.wxy.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    //添加数据
    @Override
    public Page<Orders> getList(OrderVO orderVO) {
        Specification spec = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
                //模糊查询编号
                if(orderVO.getOid()!=null && !orderVO.getOid().equals("")){
                    Predicate p1 = cb.like(root.get("oid"), "%" + orderVO.getOid() + "%");
                    list.add(p1);
                }
                //模糊查询姓名
                if(orderVO.getOname()!=null && !orderVO.getOname().equals("")){
                    Predicate p2 = cb.like(root.get("oname"), "%" + orderVO.getOname() + "%");
                    list.add(p2);
                }
                //模糊查询电话
                if(orderVO.getTel()!=null && !orderVO.getTel().equals("")){
                    Predicate p3 = cb.like(root.get("tel"), "%" + orderVO.getTel() + "%");
                    list.add(p3);
                }
                //模糊查询日期
                if(orderVO.getStartDate1()!=null){
                    Predicate b4 = cb.greaterThanOrEqualTo(root.get("startDate"), orderVO.getStartDate1());
                    list.add(b4);
                }
                if(orderVO.getStartDate2()!=null){
                    Predicate b5 = cb.lessThanOrEqualTo(root.get("startDate"), orderVO.getStartDate2());
                    list.add(b5);
                }
                if(orderVO.getEndDate1()!=null){
                    Predicate b6 = cb.greaterThanOrEqualTo(root.get("endDate"), orderVO.getEndDate1());
                    list.add(b6);
                }
                if(orderVO.getEndDate2()!=null){
                    Predicate b7 = cb.lessThanOrEqualTo(root.get("endDate"), orderVO.getEndDate2());
                    list.add(b7);
                }
                Predicate[] arr = list.toArray(new Predicate[list.size()]);
                return cb.and(arr);
            }
        };
        return orderMapper.findAll(spec, PageRequest.of(orderVO.getPageNum()-1,orderVO.getPageSize()));
    }

    @Override
    public boolean deleteById(String oid) {
        try {
            orderMapper.deleteById(oid);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delteByIds(ArrayList<Orders> orders) {
        try {
            orderMapper.deleteAll(orders);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean save(Orders orders) {
        try {
            if(orders.getOid()!=null){
                Optional<Orders> byId = orderMapper.findById(orders.getOid());
                if(byId.isPresent()){
                    //修改数据
                    orderMapper.save(orders);
                    return true;
                }
            }
            //添加数据
            orderMapper.save(orders);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //获取修改数据
    @Override
    public Orders getByOid(String oid) {
        return orderMapper.findById(oid).get();
    }
}
