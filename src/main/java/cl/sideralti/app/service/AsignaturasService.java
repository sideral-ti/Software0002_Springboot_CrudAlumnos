package cl.sideralti.app.service;

import cl.sideralti.app.entity.Asignaturas;

import java.util.List;
import java.util.Optional;

public interface AsignaturasService {

    Asignaturas crearAsignatura(Asignaturas asignatura);
    List<Asignaturas> obtenerTodasAsignaturas();
    Optional<Asignaturas> obtenerAsignaturaPorId(Long id);
    Asignaturas actualizarAsignatura(Long id, Asignaturas asignaturaActualizada);
    void eliminarAsignatura(Long id);
    List<Asignaturas> guardarAsignaturas(List<Asignaturas> asignaturas);
}
