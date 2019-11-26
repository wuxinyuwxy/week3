package com.wxy.dao;

import com.wxy.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderDetailMapper extends JpaRepository<OrderDetail,String> , JpaSpecificationExecutor<OrderDetail> {

    //删除数据
    void deleteByOrders_Oid(String oid);
}
