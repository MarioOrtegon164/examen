package com.example.examen.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Data
@Table(name = "employers")
public class Employers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Empleado")
    private Integer idEmpleado;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido_paterno", nullable = false)
    private String apellidoPaterno;

    @Column(name = "apellido_materno", nullable = false)
    private String apellidoMaterno;

    @Column(name = "cargo", nullable = false)
    private String cargo;

    @Column(name = "salario", nullable = false)
    private double salario;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "estatus", nullable = false)
    private String estatus = "ACTIVO";

    @CreatedBy
    @Column(name = "created_by")
    private Integer createdBy = 0;

    @LastModifiedBy
    @Column(name = "updated_by")
    private Integer updatedBy = 0;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

}
