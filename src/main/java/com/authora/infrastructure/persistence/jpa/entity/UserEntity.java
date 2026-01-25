package com.authora.infrastructure.persistence.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLRestriction;

@Entity
@SQLRestriction("status = 1")
@Table(name = "user")
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 36, unique = true, nullable = false)
    private String uuid;

    @Column(unique = true, nullable = false)
    private String username;

    private String email;

    @Column(name = "email_verified")
    private String emailVerified;

    @Column(nullable = false)
    private String password;

    private Boolean enabled;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private PersonEntity person;

    private Integer status;

}
