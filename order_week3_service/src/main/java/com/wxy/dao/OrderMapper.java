package com.wxy.dao;

import com.wxy.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderMapper extends JpaRepository<Orders,String>, JpaSpecificationExecutor<Orders> {
}
