package io.jotech.jpa.boundary;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import io.jotech.jpa.domain.Customer;


@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class CustomerRepositoryImpl implements CustomerRepository {
    @PersistenceContext
    private EntityManager em;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public Customer insert(Customer customer) {
         em.persist(customer);
         return customer;
    }

    @Override
    public Customer read(BigInteger id) {
       return em.find(Customer.class,id);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public Customer update(Customer customer) {
        em.merge(customer);
        return customer;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean delete(Customer customer) {
         em.remove(read(customer.getId()));
         return true;
    }

    @Override
    public List<Customer> list() {
        return em.createQuery("select c from Customer c",Customer.class).getResultList();
    }
}
