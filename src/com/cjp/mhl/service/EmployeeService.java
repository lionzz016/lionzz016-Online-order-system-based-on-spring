package com.cjp.mhl.service;

import com.cjp.mhl.dao.EmployeeDAO;
import com.cjp.mhl.domain.Employee;

/**
 * @author CJP
 * @version 1.0
 */
public class EmployeeService {
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    public Employee classicVerification(String id, String pwd) {
        return employeeDAO.DQL_Single("select * from employee where id = ? and pwd = md5(?)",
                Employee.class, id, pwd);

    }
}
