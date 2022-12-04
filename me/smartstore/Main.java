package smartstore;

import smartstore.customers.Customer;
import smartstore.groups.Group;
import smartstore.groups.GroupType;
import smartstore.groups.Parameter;
import smartstore.menu.CustomerMenu;
import smartstore.menu.Menu;
import smartstore.menu.ParameterMenu;
import smartstore.menu.SummaryMenu;

import java.util.InputMismatchException;

public class Main {
    public Main() {
    }

    public static void test() {
        ParameterMenu.allGroups.add(new Group(GroupType.GENERAL, new Parameter(10, 100000)));
        ParameterMenu.allGroups.add(new Group(GroupType.VIP, new Parameter(20, 200000)));
        ParameterMenu.allGroups.add(new Group(GroupType.VVIP, new Parameter(30, 300000)));

        for(int i = 0; i < 20; ++i) {
            CustomerMenu.allCustomers.add(new Customer("" + (char)(97 + i), (char)(97 + i) + "12345", i * 10, i * 100000));
        }

        CustomerMenu.allCustomers.refresh(ParameterMenu.allGroups);
    }

    public static void main(String[] args) {
        ParameterMenu.allGroups.initialize();
        System.out.println("===========================================");
        System.out.println(" 스마트 스토어");
        System.out.println("===========================================");
        System.out.println("");

        while(true) {
            try {
                int choice = Menu.dispMainMenu();
                if (choice == 1) {
                    ParameterMenu.manageParameter();
                } else if (choice == 2) {
                    CustomerMenu.manageCustomerData();
                } else if (choice == 3) {
                    SummaryMenu.manageSummaryMenu();
                } else {
                    if (choice == 4) {
                        System.out.println("\n프로그램 끝.");
                        break;
                    }

                    System.out.println("\n주어진 입력값은 존재하지 않습니다 다시 입력해주세요.");
                }
            } catch (InputMismatchException var2) {
                System.out.println("\n주어진 입력값은 존재하지 않습니다 다시 입력해주세요");
                Menu.scanner.next();
            }
        }

        Menu.scanner.close();
    }
}
