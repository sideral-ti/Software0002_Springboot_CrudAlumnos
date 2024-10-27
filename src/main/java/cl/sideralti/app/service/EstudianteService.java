package cl.sideralti.app.service;

import cl.sideralti.app.entity.Estudiante;

import java.util.List;
import java.util.Optional;

public interface EstudianteService {

    Estudiante crearEstudiante(Estudiante estudiante);
    List<Estudiante> obtenerTodosEstudiantes();
    Optional<Estudiante> obtenerEstudiantePorId(Long id);
    Estudiante actualizarEstudiante(Long id, Estudiante estudianteActualizado);
    void eliminarEstudiante(Long id);
    List<Estudiante> guardarEstudiantes(List<Estudiante> estudiantes);
}
