package br.com.axavier.testeDesenvolvedorJava.services;

import br.com.axavier.testeDesenvolvedorJava.entities.Usuario;
import java.util.List;

public interface UsuarioService {
    public void salvar(Usuario usuario);
    public Usuario buscarPorId(Long id);
    public List<Usuario> listarTodas();
    public void removerPorId(Long id);
}
