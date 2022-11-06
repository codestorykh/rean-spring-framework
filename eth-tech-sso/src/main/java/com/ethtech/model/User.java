package com.ethtech.model;

import com.ethtech.utils.AuthProvider;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "m_user")
public class User extends BaseEntity implements Serializable {


    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true)
    private String name;

    private String imgUrl;

    @Column(nullable = false)
    private Boolean emailVerified = false;

    @JsonIgnore
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthProvider provider;

    private String providerId;

}