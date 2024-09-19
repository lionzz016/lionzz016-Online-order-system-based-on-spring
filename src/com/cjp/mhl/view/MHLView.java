package com.cjp.mhl.view;

import com.cjp.mhl.domain.Bill;
import com.cjp.mhl.domain.Desk;
import com.cjp.mhl.domain.Menu;
import com.cjp.mhl.service.BillService;
import com.cjp.mhl.service.DeskService;
import com.cjp.mhl.service.EmployeeService;
import com.cjp.mhl.service.MenuService;
import com.cjp.mhl.utils.Utility;

import java.time.LocalDateTime;

/**
 * @author CJP
 * @version 1.0
 */
public class MHLView {
    private boolean loop = true;
    private boolean loop2 = true;
    private EmployeeService es1 = new EmployeeService();
    private DeskService ds1 = new DeskService();
    private MenuService ms1 = new MenuService();
    private BillService bs1 = new BillService();

    public static void main(String[] args) {
        new MHLView().mainView();
    }

    public void mainView() {
        while (loop) {
            System.out.println("=========Welcome to MHL=========");
            System.out.println("\t\t\t1.Login in\t\t\t");
            System.out.println("\t\t\t2.Quit\t\t\t");
            System.out.print("Please select a number above:");
            switch (Utility.readInt()) {
                case 1 -> {
                    System.out.println("Please input your MHL id and password:");
                    System.out.print("MHL Id:");
                    String id = Utility.readString();
                    System.out.print("MHL Password:");
                    String pw = Utility.readString();
                    if (es1.classicVerification(id, pw) != null) {
                        System.out.println("User: " + es1.classicVerification(id, pw).getName() + " " + LocalDateTime.now());
                        System.out.println("===========Login success=============");
                        while (loop2) {
                            System.out.println("================MHL==================");
                            System.out.println("\t\t\t1.Show desk state\t\t\t");
                            System.out.println("\t\t\t2.Pre-order desk\t\t\t");
                            System.out.println("\t\t\t3.Show all foods\t\t\t");
                            System.out.println("\t\t\t4.Order foods\t\t\t");
                            System.out.println("\t\t\t5.Check bills\t\t\t");
                            System.out.println("\t\t\t6.Pay\t\t\t");
                            System.out.println("\t\t\t9.Quit MHL\t\t\t");
                            System.out.print("Please select a number to continue:");
                            switch (Utility.readInt()) {
                                case 1 -> showDeskStat();
                                case 2 -> orderDesk();
                                case 3 -> showMenu();
                                case 4 -> orderFood();
                                case 5 -> showBills();
                                case 6 -> payBill();
                                case 9 -> {
                                    System.out.print("Are you sure to quit MHL?:(Y?N)");
                                    loop = !Utility.readString().equals("Y");
                                }
                                default -> System.out.println("Invalid selection!");
                            }
                        }
                    }
                }

                case 2 -> {
                    System.out.print("Are you sure to quit MHL?:(Y?N)");
                    loop = !Utility.readString().equals("Y");
                }
                default -> System.out.println("Invalid selection!");
            }
        }
    }

    public void showDeskStat() {
        System.out.println("=========================");
        System.out.println("ID\t\t\tState");
        for (Desk desk : ds1.showStatList()) {
            System.out.println(desk.getDeskId() + "\t\t\t" + desk.getDeskStat());
        }
        System.out.println("=======Show entirely=====");
    }

    public void orderDesk() {
        System.out.println("=========================");
        System.out.print("Please choose a desk(ID):");
        int dso = Utility.readInt();
        if (ds1.checkDesk(dso).getDeskStat().equals("available")) {
            System.out.print("Please input your name:");
            String name = Utility.readString();
            System.out.print("Please input your telephone:");
            String tel = Utility.readString();
            if (ds1.orderDesk(dso, name, tel))
                System.out.println("Order success!");
        } else if (ds1.checkDesk(dso) == null)
            System.out.println("Desk doesn't exist!");
        else System.out.println("The desk has been ordered!");
    }

    public void showMenu() {
        System.out.println("=================================");
        System.out.println("MenuID\t\t\tName\t\t\t\tPrice\t\t\tType");
        for (Menu menu : ms1.listMenu()) {
            System.out.println(menu);
        }
        System.out.println("=========Show entirely===========");
    }

    public void orderFood() {
        System.out.println("================================");
        System.out.print("Which desk:");
        int d1 = Utility.readInt();
        System.out.print("What kind of food(ID):");
        int m1 = Utility.readInt();
        System.out.print("How many numbers:");
        if (bs1.makeBill(d1, m1, Utility.readInt()))
            System.out.println("Order success,food is coming...");
        else System.out.println("Invalid deskId or foodId!");
    }

    public void showBills() {
        System.out.println("================================");
        System.out.println("Your all bills below:");
        for (Bill bill : bs1.listBill()) {
            System.out.println(bill);
        }
    }

    public void payBill() {
        System.out.println("==================================");
        System.out.print("Which desk?:");
        int d2 = Utility.readInt();
        if (ds1.checkDesk(d2) != null && bs1.hasPayBill(d2)) {
            System.out.print("Which payment?:");
            System.out.println("WxPay/AliPay/UnionPay");
            bs1.payBills(d2, Utility.readString());
            System.out.println("==========Have a nice day!============");
            System.out.println("==================MHL====================");
        } else {
            System.out.println("Invalid deskId or bill doesn't exist!");
        }
    }
}
