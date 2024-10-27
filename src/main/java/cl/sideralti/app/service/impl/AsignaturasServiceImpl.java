package cl.sideralti.app.service.impl;

import cl.sideralti.app.entity.Asignaturas;
import cl.sideralti.app.repository.AsignaturasRepository;
import cl.sideralti.app.service.AsignaturasService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsignaturasServiceImpl implements AsignaturasService {

    private final AsignaturasRepository asignaturasRepository;

    public AsignaturasServiceImpl(AsignaturasRepository asignaturasRepository) {
        this.asignaturasRepository = asignaturasRepository;
    }

    // Crear asignatura
    public Asignaturas crearAsignatura(Asignaturas asignatura) {
        return asignaturasRepository.save(asignatura);
    }

    // Obtener todas las asignaturas
    public List<Asignaturas> obtenerTodasAsignaturas() {
        return asignaturasRepository.findAll();
    }

    // Obtener asignatura por ID
    public Optional<Asignaturas> obtenerAsignaturaPorId(Long id) {
        return asignaturasRepository.findById(id);
    }

    // Actualizar asignatura
    public Asignaturas actualizarAsignatura(Long id, Asignaturas asignaturaActualizada) {
        return asignaturasRepository.findById(id)
                .map(asignatura -> {
                    asignatura.setNombre(asignaturaActualizada.getNombre());
                    asignatura.setCreditos(asignaturaActualizada.getCreditos());
                    return asignaturasRepository.save(asignatura);
                }).orElseThrow(() -> new RuntimeException("Asignatura no encontrada"));
    }

    // Eliminar asignatura
    public void eliminarAsignatura(Long id) {
        asignaturasRepository.deleteById(id);
    }

    // Método para guardar todas las asignaturas
    public List<Asignaturas> guardarAsignaturas(List<Asignaturas> asignaturas) {
        return asignaturasRepository.saveAll(asignaturas);
    }

}
