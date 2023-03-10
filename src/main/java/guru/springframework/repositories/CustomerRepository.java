package guru.springframework.repositories;

import guru.springframework.commands.CustomerForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerForm,Integer > {
    CustomerForm getCustomerFormByCustomerId(Integer customerId);
}
