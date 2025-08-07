package com.platzi.day.persistence.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity // Assuming this is a JPA entity
@Table(name = "platzi_play_peliculas") // Specify the table name in the database
public class MovieEntity {
    @Id // Assuming 'id' is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate the ID
    private Long id;

    @Column(nullable = false, length = 150, unique = true) // Title cannot be null, has a max length of 150, and must be unique
    private String titulo;

    @Column(nullable = false, precision = 3) // Duration cannot be null, with a precision of 3 (e.g., "120 min")
    private String duracion;

    @Column(nullable = false, length = 40) // Genre cannot be null, has a max length of 40
    private String genero;

    @Column(name = "fecha_estreno", nullable = false) // Release date cannot be null
    private LocalDate fechaEstreno;

    @Column(precision = 3, scale = 2) // Classification with a precision of 3 and scale of 2 (e.g., "7.5")
    private BigDecimal clasificacion;

    @Column(nullable = false, length = 1) // State cannot be null, has a max length of 1 (e.g., 'A' for active, 'I' for inactive)
    private String estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public BigDecimal getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(BigDecimal clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
