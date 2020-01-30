package br.com.axavier.testeDesenvolvedorJava.seed;

import br.com.axavier.testeDesenvolvedorJava.entities.Produto;
import br.com.axavier.testeDesenvolvedorJava.repositories.ProdutoRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/*Será executado uma vez quando a aplicação for inicializada*/
@Component
public class SeedDev implements ApplicationListener<ContextRefreshedEvent> {

    private ProdutoRepository produtoRepository;

    public SeedDev(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void onApplicationEvent(ContextRefreshedEvent e) {
        inserirDados();
    }

    public void inserirDados() {
        Produto produto1 = new Produto();
        produto1.setNome("COMUM");
        Produto produto2 = new Produto();
        produto2.setNome("ESCOLAR");
        Produto produto3 = new Produto();
        produto3.setNome("SENIOR");

        produtoRepository.save(produto1);
        produtoRepository.save(produto2);
        produtoRepository.save(produto3);
    }

}
