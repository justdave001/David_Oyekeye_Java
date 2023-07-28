package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerRepository customerRepository;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldGetCustomerByState() throws Exception {

        mockMvc.perform(get("/customer/state/California"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetCustomerById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/customer/customerId/1", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldCreateCustomer() throws Exception {
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

        String inputJson = mapper.writeValueAsString(customer);

        mockMvc.perform(post("/customer")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)

                )
                .andExpect(status().isCreated())
                .andDo(print());

    }

    @Test
    public void shouldUpdateCustomer() throws Exception {
        Customer customer = new Customer();

        String inputJson = mapper.writeValueAsString(customer);

        mockMvc.perform(put("/customer")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)

                )
                .andExpect(status().isNoContent())
                .andDo(print());

    }

    @Test
    public void shouldDeleteCustomerById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/customer/2", 2))
                .andExpect(status().isNoContent());
    }
}
