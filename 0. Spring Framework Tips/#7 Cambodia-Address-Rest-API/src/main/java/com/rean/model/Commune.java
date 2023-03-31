package com.rean.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_commune")
public class Commune implements Serializable {

    private static final long serialVersionUID = -8589432270590332392L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    @Column(name = "name_kh")
    private String khName;

    @Column(name = "name_en")
    private String enName;
}
