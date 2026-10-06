package br.com.allthings.allthings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.allthings.allthings.entity.Usuario;
import br.com.allthings.allthings.service.UsuarioService;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired UsuarioService usuarioService;

    @GetMapping("/criar")
    public String criarForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario/formularioUsuario";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Usuario usuario){
        usuarioService.save(usuario);
        return "redirect:/login";
    }
    
}
