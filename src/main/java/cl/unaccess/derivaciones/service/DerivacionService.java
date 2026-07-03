package cl.unaccess.derivaciones.service;

import cl.unaccess.derivaciones.model.Derivacion;
import cl.unaccess.derivaciones.dto.DerivacionDTO;
import cl.unaccess.derivaciones.repository.DerivacionRepository;
import cl.unaccess.derivaciones.client.PacienteClient;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class DerivacionService {

    private final DerivacionRepository repo;
    private final PacienteClient pacienteClient;

    public DerivacionService(DerivacionRepository repo, PacienteClient pacienteClient) {
        this.repo = repo;
        this.pacienteClient = pacienteClient;
    }

    public Derivacion crearDerivacion(DerivacionDTO dto) {
        if (!pacienteClient.existePaciente(dto.getPacienteRut())) {
            throw new RuntimeException("El paciente con RUT " + dto.getPacienteRut() + " no existe");
        }

        Derivacion d = new Derivacion();
        String uuidAnonimo = UUID.randomUUID().toString();
        d.setCodigoAnonimo(uuidAnonimo);
        d.setPacienteRut(dto.getPacienteRut());
        d.setEspecialidadDestino(dto.getEspecialidadDestino());
        d.setMotivo(dto.getMotivo());
        d.setFechaCreacion(LocalDate.now());
        d.setEstado("PENDIENTE");

        return repo.save(d);
    }

    public List<Derivacion> listarPorPaciente(String rut) {
        return repo.findByPacienteRut(rut);
    }
}