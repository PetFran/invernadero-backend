package com.invernadero.backend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "lecturas")
public class Lectura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sensor;

    private BigDecimal temperatura;

    private BigDecimal humedad;

    @Column(name = "fecha_hora")
    private OffsetDateTime fechaHora;

    public Lectura() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSensor() { return sensor; }
    public void setSensor(String sensor) { this.sensor = sensor; }

    public BigDecimal getTemperatura() { return temperatura; }
    public void setTemperatura(BigDecimal temperatura) { this.temperatura = temperatura; }

    public BigDecimal getHumedad() { return humedad; }
    public void setHumedad(BigDecimal humedad) { this.humedad = humedad; }

    public OffsetDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(OffsetDateTime fechaHora) { this.fechaHora = fechaHora; }
}
