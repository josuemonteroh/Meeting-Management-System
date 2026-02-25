package cr.gestionreuniones.controller;

import cr.gestionreuniones.domain.Reunion;
import cr.gestionreuniones.service.ReunionService;
import cr.gestionreuniones.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/reuniones")
public class ReunionController {

    @Autowired
    private ReunionService reunionService;

    @Autowired
    private SalaService salaService;

    @GetMapping
    public String listarReuniones(Model model) {
        model.addAttribute("reuniones", reunionService.listarReuniones());
        model.addAttribute("salas", salaService.listarSalas());
        return "reunion/listado";
    }

    @GetMapping("/nueva")
    public String mostrarFormulario(Model model) {
        model.addAttribute("reunion", new Reunion());
        model.addAttribute("salas", salaService.listarSalas());
        return "reunion/agregar";
    }

    @PostMapping("/guardar")
    public String guardarReunion(@ModelAttribute Reunion reunion,
                                 RedirectAttributes redirectAttributes) {
        reunionService.guardar(reunion);
        redirectAttributes.addFlashAttribute("msg", "✅ Reunión guardada correctamente.");
        return "redirect:/reuniones";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarReunion(@PathVariable Long id,
                                  RedirectAttributes redirectAttributes) {
        reunionService.eliminar(id);
        redirectAttributes.addFlashAttribute("msg", "🗑 Reunión eliminada correctamente.");
        return "redirect:/reuniones";
    }
} 
