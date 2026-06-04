package cl.unaccess.derivaciones.dto;

public class DerivacionDTO {
    private String pacienteRut;
    private String especialidadDestino;
    private String motivo;

    public DerivacionDTO() {}

    public String getPacienteRut() { return pacienteRut; }
    public void setPacienteRut(String pacienteRut) { this.pacienteRut = pacienteRut; }

    public String getEspecialidadDestino() { return especialidadDestino; }
    public void setEspecialidadDestino(String especialidadDestino) { this.especialidadDestino = especialidadDestino; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
}