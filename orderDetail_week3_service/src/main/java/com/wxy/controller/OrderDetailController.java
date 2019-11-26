package com.wxy.controller;

import com.wxy.entity.OrderDetail;
import com.wxy.service.OrderDetailService;
import com.wxy.vo.OrderDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("orderDetail")
@CrossOrigin
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("list")
    public Page<OrderDetail> getList(OrderDetailVO orderDetailVO){
        return orderDetailService.getList(orderDetailVO);
    }

    //删除数据
    @GetMapping("delOrderDetail")
    public boolean delOrderDetail(String gid){
        return orderDetailService.deleteGid(gid);
    }

    //批量删除
    @PostMapping("delOrder")
    public boolean delOrder(@RequestBody ArrayList<OrderDetail> details){
        return orderDetailService.deleteGids(details);
    }

    //修改+添加
    @PostMapping("save")
    public boolean save(@RequestBody OrderDetail orderDetail){
        return orderDetailService.save(orderDetail);
    }

    //获取修改的数据
    @GetMapping("getOrderDetail")
    public OrderDetail getOrderDetail(String gid){
        return orderDetailService.getByGid(gid);
    }

    @GetMapping("delee")
    public boolean dell(String oid){
        return orderDetailService.deleteByOrders_Oid(oid);
    }
}
