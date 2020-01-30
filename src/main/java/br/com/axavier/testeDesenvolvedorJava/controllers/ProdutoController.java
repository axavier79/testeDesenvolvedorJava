package br.com.axavier.testeDesenvolvedorJava.controllers;

import br.com.axavier.testeDesenvolvedorJava.services.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
    
    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/listarProdutos")
    public String listar(Model model){
        model.addAttribute("produtos", produtoService.listarTodas());
        
        return "/produto/listarProdutos";
    }
    
}
