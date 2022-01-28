package io.jotech.jpa.boundary;

import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;
import io.jotech.jpa.domain.Customer;


@Transactional(SUPPORTS)
public class CustomerRepositoryImpl implements CustomerRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional(REQUIRED)
    @Override
    public Customer insert(Customer customer) {
         em.persist(customer);
         return customer;
    }
    @Transactional
    @Override
    public Customer read(BigInteger id) {
       return em.find(Customer.class,id);
    }

    @Transactional(REQUIRED)
    @Override
    public Customer update(Customer customer) {
        em.merge(customer);
        return customer;
    }

    @Transactional(REQUIRED)
    @Override
    public boolean delete(Customer customer) {
         em.remove(read(customer.getId()));
         return true;
    }
    @Transactional
    @Override
    public List<Customer> list() {
        return em.createQuery("select c from Customer c",Customer.class).getResultList();
    }
}
