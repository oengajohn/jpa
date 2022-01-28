package io.jotech.jpa.domain;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue
    @Column(name = "customer_id", nullable = false)
    private BigInteger id;

    @Embedded
    private Name name;

    @Enumerated(value = EnumType.STRING)
    @Column(name="customer_status")
    private CustomerStatus customerStatus;

    @Embedded
    private Address address;

    @ElementCollection
    @CollectionTable(
            name="customer_nick_names", joinColumns=@JoinColumn(name="customer_id"))
    private Set<String> nickNames;


}
