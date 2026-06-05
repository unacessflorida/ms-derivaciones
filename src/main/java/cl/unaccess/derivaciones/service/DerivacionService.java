package cl.unaccess.derivaciones.service;

import cl.unaccess.derivaciones.model.Derivacion;
import cl.unaccess.derivaciones.dto.DerivacionDTO;
import cl.unaccess.derivaciones.repository.DerivacionRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID; 

@Service
public class DerivacionService {

    private final DerivacionRepository repo;

    public DerivacionService(DerivacionRepository repo) {
        this.repo = repo;
    }

    public Derivacion crearDerivacion(DerivacionDTO dto) {
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