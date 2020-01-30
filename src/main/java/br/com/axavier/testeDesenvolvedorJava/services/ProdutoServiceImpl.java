package br.com.axavier.testeDesenvolvedorJava.services;

import br.com.axavier.testeDesenvolvedorJava.entities.Produto;
import br.com.axavier.testeDesenvolvedorJava.repositories.ProdutoRepository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService{
    
    private ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }
    
    @Override
    public void salvar(Produto produto) {
        this.produtoRepository.save(produto);
    }

    @Override
    public Produto buscarPorId(Long id) {
        Optional<Produto> o = this.produtoRepository.findById(id);
        
        return o.get();
    }

    @Override
    public List<Produto> listarTodas() {
        List<Produto> produtos = new ArrayList<>();
        Iterator<Produto> iterator = this.produtoRepository.findAll().iterator();
        
        while(iterator.hasNext()){
            produtos.add(iterator.next());
        }
        
        return produtos;
    }

    @Override
    public void removerPorId(Long id) {
        this.produtoRepository.deleteById(id);
    }
    
}
