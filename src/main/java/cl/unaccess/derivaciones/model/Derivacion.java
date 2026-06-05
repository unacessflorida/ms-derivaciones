package cl.unaccess.derivaciones.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "derivaciones")
public class Derivacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_anonimo", unique = true, nullable = false)
    private String codigoAnonimo;

    private String pacienteRut;
    private String especialidadDestino; 
    private String motivo;
    private LocalDate fechaCreacion;
    private String estado;            

    public Derivacion() {}

   

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    
    public String getCodigoAnonimo() { return codigoAnonimo; }
    public void setCodigoAnonimo(String codigoAnonimo) { this.codigoAnonimo = codigoAnonimo; }

    public String getPacienteRut() { return pacienteRut; }
    public void setPacienteRut(String pacienteRut) { this.pacienteRut = pacienteRut; }

    public String getEspecialidadDestino() { return especialidadDestino; }
    public void setEspecialidadDestino(String especialidadDestino) { this.especialidadDestino = especialidadDestino; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }

    public LocalDate getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDate fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}