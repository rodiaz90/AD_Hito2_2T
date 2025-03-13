package com.empleo.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CCAA {
    @Id
    private String codigo;
    private String nombre;
}
