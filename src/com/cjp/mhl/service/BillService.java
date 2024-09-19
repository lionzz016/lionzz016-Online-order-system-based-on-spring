package com.cjp.mhl.service;

import com.cjp.mhl.dao.BillDAO;
import com.cjp.mhl.domain.Bill;

import java.util.List;
import java.util.UUID;

/**
 * @author CJP
 * @version 1.0
 */
public class BillService {
    private BillDAO billDAO = new BillDAO();
    private MenuService menuService = new MenuService();
    private DeskService deskService = new DeskService();

    public boolean makeBill(int deskId, int menuId, int nums) {
        String uuid = UUID.randomUUID().toString();
        if ((deskService.checkDesk(deskId).getDeskStat().equals("eating") || deskService.checkDesk(deskId).getDeskStat().equals("ordered")) && menuService.getMenu(menuId) != null) {
            int dml = billDAO.DML("insert into bill values(null,?,?,?,?,?,now(),'NF')",
                    uuid, menuId, nums, menuService.getMenu(menuId).getMenuPrice() * nums,
                    deskId);
            deskService.updateStat(deskId, "eating");
            return dml > 0;
        } else return false;
    }

    public List<Bill> listBill() {
        return billDAO.DQL_Multi("select * from bill", Bill.class);
    }

    public boolean hasPayBill(int deskId) {
        Bill bill = billDAO.DQL_Single("select * from bill where deskId = ? and billStat = 'NF' LIMIT 0, 1", Bill.class, deskId);
        return bill != null;
    }

    public boolean payBills(int deskId, String payment) {
        int dml = billDAO.DML("Update bill set billStat = ? where deskId = ?", payment, deskId);
        if (dml < 0) return false;
        return deskService.cleanDesk(deskId, "available");
    }
}
