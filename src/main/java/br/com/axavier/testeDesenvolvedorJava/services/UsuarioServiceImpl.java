package br.com.axavier.testeDesenvolvedorJava.services;

import br.com.axavier.testeDesenvolvedorJava.entities.Usuario;
import br.com.axavier.testeDesenvolvedorJava.repositories.UsuarioRepository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    
    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    
    @Override
    public void salvar(Usuario usuario) {
        this.usuarioRepository.save(usuario);
    }

    @Override
    public Usuario buscarPorId(Long id) {
        Optional<Usuario> o = this.usuarioRepository.findById(id);
        
        return o.get();
    }

    @Override
    public List<Usuario> listarTodas() {
        List<Usuario> usuarios = new ArrayList<>();
        Iterator<Usuario> iterator = this.usuarioRepository.findAll().iterator();
        
        while(iterator.hasNext()){
            usuarios.add(iterator.next());
        }
        
        return usuarios;
    }

    @Override
    public void removerPorId(Long id) {
        this.usuarioRepository.deleteById(id);
    }
    
}
