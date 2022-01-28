package io.jotech.jpa.domain;

import java.math.BigInteger;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="products")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "product_id", nullable = false)
    private BigInteger id;

    @Column(name = "name",unique = true,nullable = false)
    @NotNull
    @NotEmpty
    private String name;

}
