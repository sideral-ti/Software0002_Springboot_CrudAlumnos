package cl.sideralti.app.restcontroller;

import cl.sideralti.app.entity.Asignaturas;
import cl.sideralti.app.service.AsignaturasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/asignaturas")
public class AsignaturasRestController {

    private final AsignaturasService asignaturasService;

    public AsignaturasRestController(AsignaturasService asignaturasService) {
        this.asignaturasService = asignaturasService;
    }


    // Crear asignatura
    @PostMapping
    public ResponseEntity<Asignaturas> crearAsignatura(@RequestBody Asignaturas asignatura) {
        return ResponseEntity.ok(asignaturasService.crearAsignatura(asignatura));
    }

    // Obtener todas las asignaturas
    @GetMapping
    public ResponseEntity<List<Asignaturas>> obtenerTodasAsignaturas() {
        return ResponseEntity.ok(asignaturasService.obtenerTodasAsignaturas());
    }

    // Obtener asignatura por ID
    @GetMapping("/{id}")
    public ResponseEntity<Asignaturas> obtenerAsignaturaPorId(@PathVariable Long id) {
        return asignaturasService.obtenerAsignaturaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar asignatura
    @PutMapping("/{id}")
    public ResponseEntity<Asignaturas> actualizarAsignatura(@PathVariable Long id, @RequestBody Asignaturas asignaturaActualizada) {
        return ResponseEntity.ok(asignaturasService.actualizarAsignatura(id, asignaturaActualizada));
    }

    // Eliminar asignatura
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAsignatura(@PathVariable Long id) {
        asignaturasService.eliminarAsignatura(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint para guardar múltiples asignaturas
    @PostMapping("/saveAll")
    public ResponseEntity<List<Asignaturas>> saveAll(@RequestBody List<Asignaturas> asignaturas) {
        List<Asignaturas> savedAsignaturas = asignaturasService.guardarAsignaturas(asignaturas);
        return new ResponseEntity<>(savedAsignaturas, HttpStatus.CREATED);
    }
}
