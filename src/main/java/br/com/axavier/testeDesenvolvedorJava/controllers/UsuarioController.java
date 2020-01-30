package br.com.axavier.testeDesenvolvedorJava.controllers;

import br.com.axavier.testeDesenvolvedorJava.entities.Usuario;
import br.com.axavier.testeDesenvolvedorJava.services.ProdutoService;
import br.com.axavier.testeDesenvolvedorJava.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UsuarioController {
    
    private UsuarioService usuarioService;
    private ProdutoService produtoService;

    public UsuarioController(UsuarioService usuarioService, ProdutoService produtoService) {
        this.usuarioService = usuarioService;
        this.produtoService = produtoService;
    }

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("usuarios", usuarioService.listarTodas());
        
        return "/usuario/listar";
    }
    
    @GetMapping("{id}/editar")
    public String editar(@PathVariable("id") Long id, Model model){
        model.addAttribute("usuario", usuarioService.buscarPorId(id));
        model.addAttribute("produtos", produtoService.listarTodas());
        
        return "/usuario/formulario";
    }
    
    @GetMapping("{id}/excluir")
    public String excluir(@PathVariable("id") Long id){
        usuarioService.removerPorId(id);
        
        return "redirect:/listar";
    }
    
    @GetMapping("/novo")
    public String novo(Model model){
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("produtos", produtoService.listarTodas());
        
        return "/usuario/formulario";
    }
    
    @PostMapping("/salvar")
    public String salvar(Usuario usuario){
        usuarioService.salvar(usuario);
        
        return "redirect:/listar";
    }
    
    @GetMapping("/home")
    public String iniciar(){
        return "/home";
    }
    
}
