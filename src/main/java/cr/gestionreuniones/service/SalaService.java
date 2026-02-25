package cr.gestionreuniones.service;

import cr.gestionreuniones.domain.Sala;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalaService {

    private List<Sala> salas = new ArrayList<>();
    private Long nextId = 1L;

    public SalaService() {
        //Datos quemados
        guardar(new Sala(null, "Sala Río Celeste", 12));
        guardar(new Sala(null, "Sala Río Turrucares", 8));
        guardar(new Sala(null, "Sala Tárcoles", 20));
    }

    public List<Sala> listarSalas() {
        return salas;
    }

    public void guardar(Sala sala) {
        sala.setId(nextId++);
        salas.add(sala);
    }

    public void eliminar(Long id) {
        salas.removeIf(s -> s.getId().equals(id));
    }
}