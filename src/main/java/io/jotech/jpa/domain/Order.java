package io.jotech.jpa.domain;

import java.math.BigInteger;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="orders")
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "order_id", nullable = false)
    private BigInteger id;

//    An order belong to a customer
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id",referencedColumnName = "customer_id")
    private Customer customer;

    @ManyToMany
    @JoinTable(name="order_products",
            joinColumns = @JoinColumn(name="order_id",referencedColumnName = "order_id"),
            inverseJoinColumns = @JoinColumn(name="product_id",referencedColumnName = "product_id")
  )
    private  List<Product> products;



}
