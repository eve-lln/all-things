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

import br.com.allthings.allthings.entity.Categoria;
import br.com.allthings.allthings.entity.Fornecedor;
import br.com.allthings.allthings.entity.Produto;
import br.com.allthings.allthings.service.CategoriaService;
import br.com.allthings.allthings.service.FornecedorService;
import br.com.allthings.allthings.service.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService ProdutoService;

    @Autowired
    private FornecedorService fornecedorService;

    @Autowired
    private CategoriaService categoriaService;

    //métodos
    //salvar
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Produto produto){
        ProdutoService.save(produto);
        return "redirect:/produtos/listar";
    }

    // listar todos os produtos
    @GetMapping("/listar")
    public String listar(Model model){
        List<Produto> produtos = ProdutoService.findAll();
        model.addAttribute("produtos", produtos);
        return "produto/listaProdutos";
    }

    // abrir formulário
    @GetMapping("/criar")
    public String criarForm(Model model){
        model.addAttribute("produto", new Produto());
        List<Fornecedor> fornecedores = fornecedorService.findAll();
        model.addAttribute("fornecedores", fornecedores);
        List<Categoria> categorias = categoriaService.findAll();
        model.addAttribute("categorias", categorias);
        return "produto/formularioProduto";
    }

    //excuir produto
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id){
        ProdutoService.deleteById(id);
        return "redirect:/produtos/listar";
    }

    //abrir formulário de edição de produtos
    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Integer id, Model model){
        Produto produto = ProdutoService.findByID(id);
        model.addAttribute("produto", produto);
        List<Fornecedor> fornecedores = fornecedorService.findAll();
        model.addAttribute("fornecedores", fornecedores);
        return "produto/formularioProduto";
    }
}
