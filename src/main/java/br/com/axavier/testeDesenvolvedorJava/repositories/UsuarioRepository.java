package br.com.axavier.testeDesenvolvedorJava.repositories;

import br.com.axavier.testeDesenvolvedorJava.entities.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

}
