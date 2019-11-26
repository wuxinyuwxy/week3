package com.wxy.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "week3_orderdetail")
public class OrderDetail {
    @Id
    private String gid;
    private String gname;
    private String rule;
    private Integer sum;
    private String startAdd;
    private String endAdd;
    private Integer yday;
    private Integer sday;
    private String content;
    @ManyToOne
    @JoinColumn(name = "oid" ,referencedColumnName = "oid")
    private Orders orders;
}
