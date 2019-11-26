package com.wxy.service;

import com.wxy.entity.OrderDetail;
import com.wxy.vo.OrderDetailVO;
import org.springframework.data.domain.Page;

import java.util.ArrayList;

public interface OrderDetailService {
    //获取数据++分页
    Page<OrderDetail> getList(OrderDetailVO orderDetailVO);

    //添加数据+修改
    boolean save(OrderDetail orderDetail);

    //删除数据
    boolean deleteGids(ArrayList<OrderDetail> gids);

    //单删
    boolean deleteGid(String gid);

    //修改数据
    OrderDetail getByGid(String gid);

    //删除数据
    boolean deleteByOrders_Oid(String oid);
}
