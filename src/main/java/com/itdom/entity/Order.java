package com.itdom.entity;

import java.sql.Timestamp;

/**
 * 订单类
 */
public class Order {
    private Long id;
    private Timestamp creationDate;
    private String createBy;
    private Timestamp updationDate;
    private String updateBy;
    private String orderNum;
    private Double orderAmount;

    public Order(Long id, Timestamp creationDate, String createBy, Timestamp updationDate, String updateBy, String orderNum, Double orderAmount) {
        this.id = id;
        this.creationDate = creationDate;
        this.createBy = createBy;
        this.updationDate = updationDate;
        this.updateBy = updateBy;
        this.orderNum = orderNum;
        this.orderAmount = orderAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Timestamp getUpdationDate() {
        return updationDate;
    }

    public void setUpdationDate(Timestamp updationDate) {
        this.updationDate = updationDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }
}
