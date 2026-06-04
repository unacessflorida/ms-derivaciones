package cl.unaccess.derivaciones.repository;

import cl.unaccess.derivaciones.model.Derivacion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DerivacionRepository extends JpaRepository<Derivacion, Long> {
    List<Derivacion> findByPacienteRut(String pacienteRut);
}