package br.com.allthings.allthings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.allthings.allthings.entity.Fornecedor;
import br.com.allthings.allthings.service.FornecedorService;

@Controller
@RequestMapping("/fornecedores")
public class FornecedorController {
    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping("/salvar")
    public String salvarFornecedor(@ModelAttribute Fornecedor fornecedor) {
        fornecedorService.save(fornecedor);
        return "redirect:/fornecedores/listar";
    }

    @GetMapping("/listar")
    public String listarFornecedores(Model model) {
        List<Fornecedor> fornecedores = fornecedorService.findAll();
        model.addAttribute("fornecedores", fornecedores);
        return "fornecedor/listaFornecedor";
    }

    @GetMapping("/criar")
    public String criarFornecedorForm(Model model) {
        model.addAttribute("fornecedor", new Fornecedor());
        return "fornecedor/formularioFornecedor";
    }

    @GetMapping("/excluir/{id}")
    public String excluirFornecedor(@PathVariable Integer id) {
        fornecedorService.deleteById(id);
        return "redirect:/fornecedores/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarFornecedorForm(@PathVariable Integer id, Model model) {
        Fornecedor fornecedor = fornecedorService.findByID(id);
        model.addAttribute("fornecedor", fornecedor);
        return "fornecedor/formularioFornecedor";
    }
}
