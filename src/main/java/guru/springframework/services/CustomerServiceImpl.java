package guru.springframework.services;

import guru.springframework.commands.CustomerForm;
import guru.springframework.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerForm> listAll() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerForm getCustomerById(Integer id) {
        return customerRepository.getCustomerFormByCustomerId(id);
    }

    @Override
    public CustomerForm saveOrUpdateCustomerForm(CustomerForm customerForm) {
        return customerRepository.save(customerForm);
    }

    @Override
    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }
}
