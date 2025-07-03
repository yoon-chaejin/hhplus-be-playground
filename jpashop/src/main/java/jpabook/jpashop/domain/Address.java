package jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String zipCode;
    private String city;
    private String street;
}
