package cr.gestionreuniones.service;

import cr.gestionreuniones.domain.Reunion;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReunionService {

    private List<Reunion> reuniones = new ArrayList<>();
    private Long nextId = 1L;

    public ReunionService() {
        // Datos quemados
        guardar(new Reunion(null, "DSU 1 PM", LocalDate.now(), "13:00", 3L)); // Sala Tárcoles (id 3)
        guardar(new Reunion(null, "Reunión de coordinación", LocalDate.now().plusDays(1), "09:00", 1L)); // Río Celeste (id 1)
    }

    public List<Reunion> listarReuniones() {
        return reuniones;
    }

    public void guardar(Reunion reunion) {
        reunion.setId(nextId++);
        reuniones.add(reunion);
    }

    public void eliminar(Long id) {
        reuniones.removeIf(r -> r.getId().equals(id));
    }
}