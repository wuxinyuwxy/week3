package com.wxy.controller;

import com.wxy.entity.Orders;
import com.wxy.feign.OrderDetailFeign;
import com.wxy.service.OrderService;
import com.wxy.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("order")
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailFeign orderDetailFeign;

    @GetMapping("listOrder")
    public Page<Orders> getList(OrderVO orderVO){
        return orderService.getList(orderVO);
    }

    //添加数据+修改数据
    @PostMapping("save")
    public boolean save(@RequestBody Orders orders){
        return orderService.save(orders);
    }

    //获取修改数据的明细
    @GetMapping("getOrder")
    public Orders getOrder(String oid){
        return orderService.getByOid(oid);
    }

    //删除数据
    @GetMapping("deleteOrderDetail")
    public boolean deleteOrderDetail(String gid){
        return orderDetailFeign.delOrderDetail(gid);
    }

    //删除数据u
    @GetMapping("del")
    public boolean del(String oid){
        return orderService.deleteById(oid);
    }

    //批量删除
    @PostMapping("dels")
    public boolean dels(@RequestBody ArrayList<Orders> orders){
        return orderService.delteByIds(orders);
    }
}
