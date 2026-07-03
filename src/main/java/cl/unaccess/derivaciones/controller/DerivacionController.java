package cl.unaccess.derivaciones.controller;

import cl.unaccess.derivaciones.model.Derivacion;
import cl.unaccess.derivaciones.dto.DerivacionDTO;
import cl.unaccess.derivaciones.service.DerivacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/v1/derivaciones")
@Tag(name = "Derivaciones", description = "Gestion de derivaciones a especialistas")
public class DerivacionController {

    private final DerivacionService service;

    public DerivacionController(DerivacionService service) {
        this.service = service;
    }

    @Operation(summary = "Crear una nueva derivacion (valida paciente)")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Derivacion creada",
            content = @Content(examples = @ExampleObject(value = "{\"pacienteRut\":\"12345678-9\",\"especialidadDestino\":\"Cardiologia\",\"motivo\":\"Control\"}"))),
        @ApiResponse(responseCode = "500", description = "Paciente no existe")
    })
    @PostMapping
    public ResponseEntity<Derivacion> crear(@RequestBody DerivacionDTO dto) {
        Derivacion nuevaDerivacion = service.crearDerivacion(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaDerivacion);
    }

    @Operation(summary = "Buscar derivaciones de un paciente por su RUT")
    @ApiResponse(responseCode = "200", description = "Lista de derivaciones del paciente")
    @GetMapping("/paciente/{rut}")
    public ResponseEntity<List<Derivacion>> buscarPorPaciente(@PathVariable String rut) {
        return ResponseEntity.ok(service.listarPorPaciente(rut));
    }
}