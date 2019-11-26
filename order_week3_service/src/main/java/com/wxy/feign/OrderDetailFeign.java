package com.wxy.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "orderDetail-service")
public interface OrderDetailFeign {

    @GetMapping("orderDetail/delOrderDetail")
    public boolean delOrderDetail(String gid);
}
