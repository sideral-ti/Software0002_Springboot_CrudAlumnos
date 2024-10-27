package cl.sideralti.app.service.impl;

import cl.sideralti.app.entity.Estudiante;
import cl.sideralti.app.repository.EstudianteRepository;
import cl.sideralti.app.service.EstudianteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository estudianteRepository;

    public EstudianteServiceImpl(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    // Crear estudiante
    public Estudiante crearEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    // Obtener todos los estudiantes
    public List<Estudiante> obtenerTodosEstudiantes() {
        return estudianteRepository.findAll();
    }

    // Obtener estudiante por ID
    public Optional<Estudiante> obtenerEstudiantePorId(Long id) {
        return estudianteRepository.findById(id);
    }

    // Actualizar estudiante
    public Estudiante actualizarEstudiante(Long id, Estudiante estudianteActualizado) {
        return estudianteRepository.findById(id)
                .map(estudiante -> {
                    estudiante.setNombre(estudianteActualizado.getNombre());
                    estudiante.setApellido(estudianteActualizado.getApellido());
                    estudiante.setEdad(estudianteActualizado.getEdad());

                    // Actualizar las asignaturas
                    if (estudianteActualizado.getAsignaturas() != null) {
                        estudiante.getAsignaturas().clear();
                        estudianteActualizado.getAsignaturas().forEach(asignatura -> {
                            estudiante.getAsignaturas().add(asignatura);
                            asignatura.getEstudiantes().add(estudiante); // Actualizar la relación en Asignatura
                        });
                    }

                    return estudianteRepository.save(estudiante);
                }).orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
    }

    // Eliminar estudiante
    public void eliminarEstudiante(Long id) {
        estudianteRepository.deleteById(id);
    }

    // Método para guardar todos los estudiantes
    public List<Estudiante> guardarEstudiantes(List<Estudiante> estudiantes) {
        return estudianteRepository.saveAll(estudiantes);
    }
}
