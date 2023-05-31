package vn.funix.FX20359.java.asm2.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ASM02 {
    public static final String AUTHOR = "FX19878";
    public static final String VERSION = "V2.0.0";

    private static final Bank bank = new Bank();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;


        do {
            System.out.println("+----------+----------------------+--------+");
            System.out.println("| NGAN HANG SO | " + AUTHOR + "@" + VERSION + "            |");
            System.out.println("+----------+----------------------+--------+");
            System.out.println(" 1. Them khach hang");
            System.out.println(" 2. Them tai khoan cho khach hang");
            System.out.println(" 3. Hien thi danh sach khach hang");
            System.out.println(" 4. Tim theo CCCD");
            System.out.println(" 5. Tim theo ten khach hang");
            System.out.println(" 0. Thoat");
            System.out.println("+----------+----------------------+--------+");
            System.out.println("Chuc nang: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());


                switch (choice) {
                    case 1:
                        addCustomer();
                        break;
                    case 2:
                        addAccount();
                        break;
                    case 3:
                        showCustomer();
                        break;
                    case 4:
                        findByCCCD();
                        break;
                    case 5:
                        findByName();
                        break;
                    case 0:
                        System.out.println("Cám ơn và hẹn gặp lại");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Error: lựa chọn không hợ lệ.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("sai cú pháp vui lòng nhập lại");

            }
        } while (true);
    }

    public static void addCustomer() {

        System.out.println("Nhập tên khách hàng:");
        String name = scanner.nextLine();
        String customerId = "";
        boolean validId = true;
        System.out.println("nhập số CCCD");

        while (validId) {

            customerId = scanner.nextLine();
            if (customerId.equals("no") || customerId.equals("No")) {
                System.exit(0);
            }
            // kiểm tra số CCCD có đúng định dạnng
            if (!User.formatCheck(customerId)) {
                System.out.println("số CCCD không hợp lệ");
                System.out.println("vui lòng nhập lại hoặc nhập 'no' để thoát");
                continue;
            }
            if (bank.isCustomerExisted(customerId)) {
                System.out.println("khách hàng đã tồn tại");
                System.out.println("vui lòng nhập lại CCCD khác hoặc nhập 'no' để thoát ");
                continue;
            }
            validId = false;
        }
        Customer customer = new Customer(name, customerId);
        bank.addCustomer(customer);
        System.out.println("Khác hàng được thêm thành công");
    }

    public static void addAccount() {
        String customerId1;
        do {
            System.out.println("Vui lòng nhập số căn cước công dân:");
            customerId1 = scanner.nextLine();
            if (!bank.isCustomerExisted(customerId1)) {
                System.out.println("Error: Khách hàng không tồn tại.");
                continue;
            }
            break;
        } while (true);
        Customer customers = null;
        for (Customer c : bank.getCustomers()) {
            if (c.getCustomerId().equals(customerId1)) {
                customers = c;
                break;
            }
        }
        String accountNumber;
        boolean accountNumberExists;
        do {
            System.out.println("vui lòng nhập số tài khoản 6 số(6 số khác nhau):");
            accountNumber = scanner.nextLine();
            if(accountNumber.equals("no")||accountNumber.equals("No")){
                System.exit(0);
            }
            //kiểm tra số nhập vào có phải là dãy toàn số
            if (!accountNumber.matches("^[0-9]{6}$")) {
                System.out.println("error: số tài khoản phải là dãy 6 số");
                continue;
            }
            //kiểm tra có bị trùng stk trong danh sách tài khoản
            accountNumberExists = false;
            for (Account a : customers.getAccounts()) {
                if (a.getAccountNumber().equals(accountNumber)) {
                    accountNumberExists = true;
                    break;
                }
            }
            if (accountNumberExists) {
                System.out.println("Error: số tài khoản đã tồn tại \n vui lòng nhập số tài khoản khác hoặc nhập 'no' để thoát");

                continue;
            }
            //kiểm tra 6 số của stk
            boolean hasDuplicateDigits = false;
            for (int i = 0; i < accountNumber.length(); i++) {
                char digit = accountNumber.charAt(i);
                if (accountNumber.indexOf(digit) != i) {
                    hasDuplicateDigits = true;
                    break;
                }
            }
            if (hasDuplicateDigits) {
                System.out.println("Error: Số tài khoản phải bao gồm 6 chữ số khác nhau.");
                continue;
            }
            break;
        } while (true);
        double balance;

        do {
            System.out.println("Vui lòng nhập số dư tài khoản (phải lớn hơn 50000):");
            try {
                balance = Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("xin vui lòng nhập lại");
                continue;
            }
            if (balance < 50000) {
                System.out.println("Error: Số dư tài khoản phải lớn hơn 50000.");

                continue;
            }
            break;
        } while (true);
        Account account = new Account(accountNumber, balance);
        customers.addAccount(account);
        System.out.println("thêm tài khoản thành công.");

    }

    public static void showCustomer() {
        System.out.println("Danh sách của khách hàng :");
        for (Customer c : bank.getCustomers()) {
            c.displayInformation();
            System.out.println();
        }
    }

    public static void findByName() {
        System.out.println("Vui lòng nhập tên hoặc 1 từ khóa:");

        String keyword = scanner.nextLine().toLowerCase();
        List<Customer> matchingCustomers = new ArrayList<>();
        for (Customer c : bank.getCustomers()) {
            if (c.getName().toLowerCase().contains(keyword)) {
                matchingCustomers.add(c);
            }
        }
        if (matchingCustomers.isEmpty()) {
            System.out.println("Không tìm thấy khách hàng ");

        } else {
            System.out.println("khách hàng cần tìm tương ứng:");
            for (Customer c : matchingCustomers) {
                c.displayInformation();
                System.out.println();
            }
        }
    }

    public static void findByCCCD() {
        System.out.println("Vui lòng nhập CCCD của khách hàng :");
        String searchId = scanner.nextLine();
        boolean found = false;


        for (Customer c : bank.getCustomers()) {
            if (c.getCustomerId().equals(searchId)) {
                c.displayInformation();
                System.out.println();
                found = true;
            }
        }
        if (!found) {
            System.out.println(" không tìm thấy khách hàng  ");



        }

    }




}
