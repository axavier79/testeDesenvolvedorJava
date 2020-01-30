package br.com.axavier.testeDesenvolvedorJava.repositories;

import br.com.axavier.testeDesenvolvedorJava.entities.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long>{

}
