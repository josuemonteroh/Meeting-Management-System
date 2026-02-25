package cr.gestionreuniones.controller;

import cr.gestionreuniones.domain.Sala;
import cr.gestionreuniones.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/salas")
public class SalaController {

    @Autowired
    private SalaService salaService;

    @GetMapping
    public String listarSalas(Model model) {
        model.addAttribute("salas", salaService.listarSalas());
        return "sala/listado";
    }

    @GetMapping("/nueva")
    public String mostrarFormulario(Model model) {
        model.addAttribute("sala", new Sala());
        return "sala/agregar";
    }

    @PostMapping("/guardar")
    public String guardarSala(@ModelAttribute Sala sala, RedirectAttributes redirectAttributes) {
        salaService.guardar(sala);
        redirectAttributes.addFlashAttribute("msg", "✅ Sala guardada correctamente.");
        return "redirect:/salas";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarSala(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        salaService.eliminar(id);
        redirectAttributes.addFlashAttribute("msg", "🗑 Sala eliminada correctamente.");
        return "redirect:/salas";
    }
} 