package guru.springframework.controllers;

import guru.springframework.commands.CustomerForm;
import guru.springframework.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService customerService;
    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping({"/list", "/", ""})
    private String listCustomer(Model model){
        model.addAttribute("customers",customerService.listAll());
        return "customer/list";
    }

    @RequestMapping("/show/{id}")
    public String showCustomer(@PathVariable Integer id, Model model){
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customer/show";
    }

    @RequestMapping("/edit/{id}")
    public String editCustomer(@PathVariable Integer id, Model model){
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customer/customerForm";
    }

    @RequestMapping("/new")
    private String newCustomer(Model model){
        model.addAttribute("customerForm", new CustomerForm());
        return "customer/customerForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    private String saveOrUpdateCustomer(@Valid CustomerForm customerForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "customer/customerForm";
        }
        CustomerForm newCustomerForm = customerService.saveOrUpdateCustomerForm(customerForm);
        return "redirect:customer/show/"+newCustomerForm.getCustomerId();
    }

    @RequestMapping(method = RequestMethod.DELETE)
    private String delete(@PathVariable Integer id){
        customerService.delete(id);
        return "redirect:customer/list";
    }
}
