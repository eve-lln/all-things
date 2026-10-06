package br.com.allthings.allthings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.allthings.allthings.entity.Cliente;
import br.com.allthings.allthings.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Cliente cliente,
                     @RequestParam(value = "foto", required = false) MultipartFile foto) {

    try {
        if (foto != null && !foto.isEmpty()) {
            cliente.setFotoCliente(foto.getBytes());
            cliente.setTipoFoto(foto.getContentType());
        } else if (cliente.getIdCliente() != null) {
            Cliente clienteExistente = clienteService.findByID(cliente.getIdCliente());
            if (clienteExistente != null) {
                cliente.setFotoCliente(clienteExistente.getFotoCliente());
                cliente.setTipoFoto(clienteExistente.getTipoFoto());
            }
        }

        clienteService.save(cliente);
        System.out.println("Cliente salvo com id: " + cliente.getIdCliente());

    } catch (Exception e) {
        System.err.println("ERRO AO SALVAR CLIENTE:");
        e.printStackTrace();  // olha o console do Spring!
    }

    return "redirect:/clientes/listar";
}

    @GetMapping("/listar")
    public String listar(Model model){
        List<Cliente> clientes = clienteService.findAll();
        model.addAttribute("clientes", clientes);
        return "cliente/listaCliente";
    }

    @GetMapping("/criar")
    public String criarForm(Model model){
        model.addAttribute("cliente", new Cliente());
        return "cliente/formularioCliente";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id){
        clienteService.deleteById(id);
        return "redirect:/clientes/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Integer id, Model model){
        Cliente cliente = clienteService.findByID(id);
        model.addAttribute("cliente", cliente);
        return "cliente/formularioCliente";
    }

    @GetMapping("/foto/{id}")
    public ResponseEntity <byte[]> foto (@PathVariable Integer id){
        Cliente cliente = clienteService.findByID(id);
        if (cliente == null || cliente.getFotoCliente() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok()
        .contentType(MediaType.parseMediaType(cliente.getTipoFoto()))
        .body(cliente.getFotoCliente());
    }
    
}
