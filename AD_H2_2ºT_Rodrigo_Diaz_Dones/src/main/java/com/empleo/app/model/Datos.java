package com.empleo.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data // Genera automáticamente métodos como getters, setters, equals, hashCode, y toString usando Lombok.
@Entity // Indica que esta clase es una entidad de JPA y estará mapeada a una tabla en la base de datos.
public class Datos {
    @Id // Define el campo `id_dato` como la clave primaria de la entidad.
    private int id_dato;
    private String sexo;
    private String edad;
    private String periodo;
    private int total;

    @ManyToOne // Indica una relación "Muchos a Uno" entre esta entidad y la entidad `CCAA`.
    @JoinColumn(name = "id_ccaa") // Especifica que el campo `id_ccaa` en la tabla `datos` será la clave foránea que referencia la tabla `ccaa`.
    private CCAA ccaa; // Representa la comunidad autónoma asociada a este registro.
}
