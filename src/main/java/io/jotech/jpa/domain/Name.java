package io.jotech.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Name {

    @Column(name="first_name",nullable = false)
    @Size(max = 100,min = 3)
    private String firstName;

    @Column(name="last_name",nullable = false)
    @Size(max = 100,min = 3)
    private String lastName;

    private String surname;

}
