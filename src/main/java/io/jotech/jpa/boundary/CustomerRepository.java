package io.jotech.jpa.boundary;

import java.math.BigInteger;
import java.util.List;

import io.jotech.jpa.domain.Customer;

public interface CustomerRepository {
    Customer insert(Customer customer);
    Customer read(BigInteger id);
    Customer update(Customer customer);
    boolean delete(Customer customer);
    List<Customer> list();
}
