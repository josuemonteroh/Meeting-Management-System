package cr.gestionreuniones.domain;

import java.time.LocalDate;

public class Reunion {

    private Long id;
    private String titulo;
    private LocalDate fecha;
    private String hora;
    private Long salaId;

    public Reunion() {
    }

    public Reunion(Long id, String titulo, LocalDate fecha, String hora, Long salaId) {
        this.id = id;
        this.titulo = titulo;
        this.fecha = fecha;
        this.hora = hora;
        this.salaId = salaId;
    }

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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Long getSalaId() {
        return salaId;
    }

    public void setSalaId(Long salaId) {
        this.salaId = salaId;
    }
}