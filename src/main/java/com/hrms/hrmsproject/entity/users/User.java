package com.hrms.hrmsproject.entity.users;

import com.hrms.hrmsproject.entity.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
@NoArgsConstructor
public class User extends BaseEntity {

    @Column(name = "email",
            nullable = false,
            length = 100)
    private String email;

    @Column(nullable = false,length = 100)
    private String password;

    @Column(name = "create_time",nullable = false)
    private LocalDateTime createdTime;



    public User(String email,
                String password,
                LocalDateTime createdTime) {
        this.email = email;
        this.password = password;
        this.createdTime = createdTime;
    }



}
