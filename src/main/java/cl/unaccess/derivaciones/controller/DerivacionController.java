package cl.unaccess.derivaciones.controller;

import cl.unaccess.derivaciones.model.Derivacion;
import cl.unaccess.derivaciones.dto.DerivacionDTO;
import cl.unaccess.derivaciones.service.DerivacionService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/v1/derivaciones")
public class DerivacionController {

    private final DerivacionService service;

    public DerivacionController(DerivacionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Derivacion> crear(@RequestBody DerivacionDTO dto) {
        Derivacion nuevaDerivacion = service.crearDerivacion(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaDerivacion);
    }

    @GetMapping("/paciente/{rut}")
    public ResponseEntity<List<Derivacion>> buscarPorPaciente(@PathVariable String rut) {
        return ResponseEntity.ok(service.listarPorPaciente(rut));
    }
}