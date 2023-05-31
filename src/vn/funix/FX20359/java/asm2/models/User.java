package vn.funix.FX20359.java.asm2.models;

import java.util.Scanner;
import java.util.regex.Pattern;

public class User {
    private String name;
    private String customerId;



    public User(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }
    public static boolean formatCheck(String customerId) {

        Pattern p = Pattern.compile("^[0-9]{12}$");
        if(p.matcher(customerId).find()){
            return true;
        }
        return false;

    }


    public void setCustomerId(String customerId) {
        if (formatCheck(customerId)){
            this.customerId = customerId;
        }else {
            System.out.println("CCCD không hợp lệ");
        }
    }

    }

