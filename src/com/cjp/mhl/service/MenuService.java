package com.cjp.mhl.service;

import com.cjp.mhl.dao.MenuDAO;
import com.cjp.mhl.domain.Menu;

import java.util.List;

/**
 * @author CJP
 * @version 1.0
 */
public class MenuService {
    private MenuDAO menuDAO = new MenuDAO();

    public List<Menu> listMenu() {
        return menuDAO.DQL_Multi("select * from menu", Menu.class);
    }

    public Menu getMenu(int menuId) {
        return menuDAO.DQL_Single("select * from menu where menuId = ?", Menu.class, menuId);
    }
}
