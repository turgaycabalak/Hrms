package com.hrms.hrmsproject.entity.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hrms.hrmsproject.entity.confirmation.Confirmation;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "employees")
@NoArgsConstructor
public class Employee extends User{

    @Column(name = "first_name",nullable = false,length = 50)
    private String firstName;

    @Column(name = "last_name",nullable = false,length = 50)
    private String lastName;

    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private List<Confirmation> confirmations;


    public Employee(String email,
                    String password,
                    LocalDateTime createdTime,
                    String firstName,
                    String lastName) {
        super(email, password, createdTime);
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
