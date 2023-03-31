package com.learnspring.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_student")
public class Student implements Serializable {

    private static final long serialVersionUID = -3013108473617514237L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long studentId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "dob")
    private String dob;

    @OneToOne(mappedBy = "student", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Course course;

}
