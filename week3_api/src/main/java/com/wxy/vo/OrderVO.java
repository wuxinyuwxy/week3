package com.wxy.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class OrderVO {
    private String oid;
    private String oname;
    private String tel;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate1;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate2;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate1;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate2;
    //分页
    private Integer pageNum;
    private Integer pageSize;
}
