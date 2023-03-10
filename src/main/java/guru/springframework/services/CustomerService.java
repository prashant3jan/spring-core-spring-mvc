package guru.springframework.services;

import guru.springframework.commands.CustomerForm;

import java.util.List;

public interface CustomerService {
    List<CustomerForm> listAll();
    CustomerForm getCustomerById(Integer id);
    CustomerForm saveOrUpdateCustomerForm(CustomerForm customerForm);
    void delete(Integer id);
}
