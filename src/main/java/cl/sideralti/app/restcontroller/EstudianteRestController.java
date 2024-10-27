package cl.sideralti.app.restcontroller;

import cl.sideralti.app.entity.Estudiante;
import cl.sideralti.app.service.EstudianteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/estudiante")
public class EstudianteRestController {

    private final EstudianteService estudianteService;

    public EstudianteRestController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }


    @PostMapping
    public ResponseEntity<Estudiante> crearEstudiante(@RequestBody Estudiante estudiante) {
        Estudiante nuevoEstudiante = estudianteService.crearEstudiante(estudiante);
        return new ResponseEntity<>(nuevoEstudiante, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Estudiante>> obtenerTodosEstudiantes() {
        List<Estudiante> estudiantes = estudianteService.obtenerTodosEstudiantes();
        return new ResponseEntity<>(estudiantes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtenerEstudiantePorId(@PathVariable Long id) {
        return estudianteService.obtenerEstudiantePorId(id)
                .map(estudiante -> new ResponseEntity<>(estudiante, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> actualizarEstudiante(
            @PathVariable Long id,
            @RequestBody Estudiante estudianteActualizado) {
        Estudiante estudiante = estudianteService.actualizarEstudiante(id, estudianteActualizado);
        return new ResponseEntity<>(estudiante, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable Long id) {
        estudianteService.eliminarEstudiante(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Endpoint para guardar múltiples estudiantes
    @PostMapping("/saveAll")
    public ResponseEntity<List<Estudiante>> saveAll(@RequestBody List<Estudiante> estudiantes) {
        List<Estudiante> savedEstudiantes = estudianteService.guardarEstudiantes(estudiantes);
        return new ResponseEntity<>(savedEstudiantes, HttpStatus.CREATED);
    }
}
