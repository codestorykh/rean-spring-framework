package com.rean.customer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "id_type")
    private String idType;
    @Column(name = "id_value")
    private String idValue;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String gender;
    @Column(name = "phone_number")
    private String phoneNumber;
}
