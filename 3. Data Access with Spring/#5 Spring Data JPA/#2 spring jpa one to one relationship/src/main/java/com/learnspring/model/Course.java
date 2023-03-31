package com.learnspring.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_course")
public class Course implements Serializable {

    private static final long serialVersionUID = 4925377280696677471L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String courseName;

    @Column(name = "price")
    private double price;

    @Column(name = "create_at")
    private Date createAt;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

}
