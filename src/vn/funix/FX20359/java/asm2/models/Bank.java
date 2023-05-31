package vn.funix.FX20359.java.asm2.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Bank {
    private String id;
    private List<Customer> customers;

    public Bank() {
        this.id =String.valueOf(UUID.randomUUID());
        this.customers = new ArrayList<>();
    }
    public void addCustomer(Customer customer) {
        // Check if customer already exists
        if (isCustomerExisted(customer.getCustomerId())) {
            System.out.println("Error: khách hàng đã tồn tại");
            return;
        }
        customers.add(customer);
    }
    public boolean isCustomerExisted(String customerId) {
        for (Customer c : customers) {
            if (c.getCustomerId().equals(customerId)) {
                return true;
            }
        }
        return false;
    }
    public List<Customer> getCustomers() {
        return customers;
    }


}
