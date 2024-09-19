package com.cjp.mhl.domain;

import java.util.Date;

/**
 * @author CJP
 * @version 1.0
 */
public class Bill {
    private Integer billId;
    private String billRandomId;
    private Integer menuId;
    private Integer nums;
    private Double total;
    private Integer deskId;
    private Date billDate;
    private String billStat;

    public Bill() {
    }

    public Bill(Integer billId, String billRandomId, Integer menuId, Integer nums, Double total, Integer deskId, Date billDate, String billStat) {
        this.billId = billId;
        this.billRandomId = billRandomId;
        this.menuId = menuId;
        this.nums = nums;
        this.total = total;
        this.deskId = deskId;
        this.billDate = billDate;
        this.billStat = billStat;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public String getBillRandomId() {
        return billRandomId;
    }

    public void setBillRandomId(String billRandomId) {
        this.billRandomId = billRandomId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getDeskId() {
        return deskId;
    }

    public void setDeskId(Integer deskId) {
        this.deskId = deskId;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public String getBillStat() {
        return billStat;
    }

    public void setBillStat(String billStat) {
        this.billStat = billStat;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billId=" + billId +
                ", billRandomId='" + billRandomId + '\'' +
                ", menuId=" + menuId +
                ", nums=" + nums +
                ", total=" + total +
                ", deskId=" + deskId +
                ", billDate=" + billDate +
                ", billStat='" + billStat + '\'' +
                '}';
    }
}
