package com.wxy.service;

import com.wxy.entity.Orders;
import com.wxy.vo.OrderVO;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public interface OrderService {
    //获取数据+模糊查询
    Page<Orders> getList(OrderVO orderVO);

    //删除订单
    boolean deleteById(String oid);

    //plsc
    boolean delteByIds(ArrayList<Orders> orders);

    //添加数据
    boolean save(Orders orders);

    //获取修改数据明细
    Orders getByOid(String oid);
}
