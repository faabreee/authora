package com.authora.infrastructure.persistence.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "person")
@Getter
@Setter
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 36, unique = true, nullable = false)
    private String uuid;

    @ManyToOne
    @JoinColumn(name = "document_type_id", referencedColumnName = "id")
    private DocumentTypeEntity documentType;

    @Column(length = 30, unique = true, nullable = false)
    private String documentNumber;

    @Column(length = 100, nullable = false)
    private String firstName;

    @Column(length = 100)
    private String secondName;

    @Column(length = 100, nullable = false)
    private String firstLastName;

    @Column(length = 100, nullable = false)
    private String secondLastName;

    @Column(name = "birth_date")
    private Date birthDate;

    @ManyToOne
    @JoinColumn(name = "gender_id", referencedColumnName = "id")
    private GenderEntity gender;

    private Integer status;

}
