package com.cjp.mhl.service;

import com.cjp.mhl.dao.DeskDAO;
import com.cjp.mhl.domain.Desk;

import java.util.List;

/**
 * @author CJP
 * @version 1.0
 */
public class DeskService {
    private DeskDAO deskDAO = new DeskDAO();

    public List<Desk> showStatList() {
        return deskDAO.DQL_Multi("select deskId,deskStat from desk", Desk.class);
    }

    public Desk checkDesk(int deskId) {
        return deskDAO.DQL_Single("select * from desk where deskId = ?", Desk.class, deskId);
    }

    public boolean orderDesk(int deskId, String orderName, String orderTel) {
        int dml = deskDAO.DML("update desk set deskStat = 'ordered', orderName = ?,orderTel = ? where deskId = ?",
                orderName, orderTel, deskId);
        return dml > 0;
    }

    public boolean updateStat(int deskId, String stat) {
        int dml = deskDAO.DML("update desk set deskStat = ? where deskId = ?", stat, deskId);
        return dml > 0;
    }

    public boolean cleanDesk(int deskId, String deskStat) {
        int dml = deskDAO.DML("update desk set deskStat = ?,orderName = '',orderTel = '' where deskId = ?", deskStat, deskId);
        return dml > 0;
    }
}
