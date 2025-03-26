package com.example.LearningJava.entity.user;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "user001")
@Data
@DynamicInsert
@DynamicUpdate
public class UserEntify {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( columnDefinition = "varchar(255)")
    private String userName;
    @Column( unique = true)
    private String email;
}
