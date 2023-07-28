package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTests {

    @Autowired
    CustomerRepository customerRepo;

    @Before
    public void setUp() throws Exception {
        customerRepo.deleteAll();
    }

    @Test
    public void shouldCreateCustomer() {
        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("David");
        customer.setLastName("Smith");
        customer.setPhone("334-676-3492");
        customer.setCompany("BigCA");
        customer.setEmail("dsmith@gmail.com");
        customer.setAddress1("Los Gatos");
        customer.setAddress2("Santa Cruz");
        customer.setCity("Santa Clara");
        customer.setState("California");
        customer.setPostalCode(95030);
        customer.setCountry("USA");

        //Act...
        customer = customerRepo.save(customer);

        //Assert...
        Optional<Customer> customer1 = customerRepo.findById(customer.getCustomerId());

        assertEquals(customer1.get(), customer);
    }

    @Test
    public void shouldUpdateCustomer() {
        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("David");
        customer.setLastName("Smith");
        customer.setPhone("334-676-3492");
        customer.setCompany("BigCA");
        customer.setEmail("dsmith@gmail.com");
        customer.setAddress1("Los Gatos");
        customer.setAddress2("Santa Cruz");
        customer.setCity("Santa Clara");
        customer.setState("California");
        customer.setPostalCode(95030);
        customer.setCountry("USA");

        customerRepo.save(customer);

        //Act...
        customer.setFirstName("UPDATED");

        customerRepo.save(customer);

        //Assert...
        Optional<Customer> customer1 = customerRepo.findById(customer.getCustomerId());

        assertEquals(customer1.get(), customer);
    }

    @Test
    public void shouldDeleteCustomer() {
        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("David");
        customer.setLastName("Smith");
        customer.setPhone("334-676-3492");
        customer.setCompany("BigCA");
        customer.setEmail("dsmith@gmail.com");
        customer.setAddress1("Los Gatos");
        customer.setAddress2("Santa Cruz");
        customer.setCity("Santa Clara");
        customer.setState("California");
        customer.setPostalCode(95030);
        customer.setCountry("USA");

        customerRepo.save(customer);

        //Act...
        customerRepo.deleteById(customer.getCustomerId());

        //Assert...
        Optional<Customer> customer1 = customerRepo.findById(customer.getCustomerId());
        assertFalse(customer1.isPresent());
    }

    @Test
    public void shouldFindCustomerById() {
        Customer customer = new Customer();
        customer.setFirstName("David");
        customer.setLastName("Smith");
        customer.setPhone("334-676-3492");
        customer.setCompany("BigCA");
        customer.setEmail("dsmith@gmail.com");
        customer.setAddress1("Los Gatos");
        customer.setAddress2("Santa Cruz");
        customer.setCity("Santa Clara");
        customer.setState("California");
        customer.setPostalCode(95030);
        customer.setCountry("USA");

        customerRepo.save(customer);
        //Act...
        customerRepo.findById(customer.getCustomerId());

        //Assert...
        Optional<Customer> customer1 = customerRepo.findById(customer.getCustomerId());

        assertEquals(customer1.get(), customer);

    }

    @Test
    public void shouldFindCustomerByState() {
        Customer customer = new Customer();
        customer.setFirstName("David");
        customer.setLastName("Smith");
        customer.setPhone("334-676-3492");
        customer.setCompany("BigCA");
        customer.setEmail("dsmith@gmail.com");
        customer.setAddress1("Los Gatos");
        customer.setAddress2("Santa Cruz");
        customer.setCity("Santa Clara");
        customer.setState("California");
        customer.setPostalCode(95030);
        customer.setCountry("USA");

        customerRepo.save(customer);


        Customer customer2 = new Customer();
        customer2.setFirstName("David");
        customer2.setLastName("Smith");
        customer2.setPhone("334-676-3492");
        customer2.setCompany("BigCA");
        customer2.setEmail("dsmith@gmail.com");
        customer2.setAddress1("Los Gatos");
        customer2.setAddress2("Santa Cruz");
        customer2.setCity("Santa Clara");
        customer2.setState("California");
        customer2.setPostalCode(95030);
        customer2.setCountry("USA");

        customerRepo.save(customer2);

        //Assert...
        List<Customer> customerList = customerRepo.findByState(customer.getState());

        assertEquals(customerList.size(), 2);

    }
}
