// Maaz Shaikh - 421007607
package org.example.car_rental_project.services;

import org.example.car_rental_project.models.Customer;
import org.example.car_rental_project.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Customer findByUsername(String username) {
        return customerRepository.findByUsername(username);
    }

    public List<Customer> searchByUsername(String keyword) {
        return customerRepository.searchByUsername(keyword);
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Transactional
    public void updateEmail(Long id, String email) {
        customerRepository.updateEmailById(id, email);
    }

    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
}