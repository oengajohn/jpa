package io.jotech.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class Address {

    @Column(name="email",nullable = false)
    @Email
    private String email;

    @Column(name="phone")
    private String phoneNumber;



}
