package com.cjp.mhl.domain;

/**
 * @author CJP
 * @version 1.0
 */
public class Menu {
    private Integer menuId;
    private String menuName;
    private Double menuPrice;
    private String menuType;

    public Menu() {
    }

    public Menu(Integer menuId, String menuName, Double menuPrice, String menuType) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuType = menuType;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Double getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(Double menuPrice) {
        this.menuPrice = menuPrice;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    @Override
    public String toString() {
        return menuId + "\t\t\t" + menuName + "\t\t\t" + menuPrice + "\t\t\t" + menuType;
    }
}
