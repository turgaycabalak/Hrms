package com.hrms.hrmsproject.entity.verification;

import com.hrms.hrmsproject.entity.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "verifications")
@NoArgsConstructor
public class Verification extends BaseEntity {

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private boolean isVerified;

    @Column(nullable = false)
    private LocalDateTime expirationDate;

    private LocalDateTime verifiedDate;



    public Verification(String code,
                        boolean isVerified,
                        LocalDateTime expirationDate) {
        this.code = code;
        this.isVerified = isVerified;
        this.expirationDate = expirationDate;
    }


}
