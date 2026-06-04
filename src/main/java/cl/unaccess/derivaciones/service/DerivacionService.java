package cl.unaccess.derivaciones.service;

import cl.unaccess.derivaciones.model.Derivacion;
import cl.unaccess.derivaciones.dto.DerivacionDTO;
import cl.unaccess.derivaciones.repository.DerivacionRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class DerivacionService {

    private final DerivacionRepository repo;

    public DerivacionService(DerivacionRepository repo) {
        this.repo = repo;
    }

    public Derivacion crearDerivacion(DerivacionDTO dto) {
        Derivacion d = new Derivacion();
        d.setPacienteRut(dto.getPacienteRut());
        d.setEspecialidadDestino(dto.getEspecialidadDestino());
        d.setMotivo(dto.getMotivo());
        
        // Automatizaciones requeridas para la rúbrica
        d.setFechaCreacion(LocalDate.now());
        d.setEstado("PENDIENTE");

        return repo.save(d);
    }

    public List<Derivacion> listarPorPaciente(String rut) {
        return repo.findByPacienteRut(rut);
    }
}