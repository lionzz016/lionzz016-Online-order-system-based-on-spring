package com.cjp.mhl.domain;

import com.cjp.mhl.dao.BasicDAO;

/**
 * @author CJP
 * @version 1.0
 */
public class Desk{
    private Integer deskId;
    private String deskStat;
    private String orderName;
    private String orderTel;

    public Desk() {
    }

    public Desk(Integer deskId, String deskStat, String orderName, String orderTel) {
        this.deskId = deskId;
        this.deskStat = deskStat;
        this.orderName = orderName;
        this.orderTel = orderTel;
    }

    public Integer getDeskId() {
        return deskId;
    }

    public void setDeskId(Integer deskId) {
        this.deskId = deskId;
    }

    public String getDeskStat() {
        return deskStat;
    }

    public void setDeskStat(String deskStat) {
        this.deskStat = deskStat;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderTel() {
        return orderTel;
    }

    public void setOrderTel(String orderTel) {
        this.orderTel = orderTel;
    }
}
