package br.com.axavier.testeDesenvolvedorJava.services;

import br.com.axavier.testeDesenvolvedorJava.entities.Produto;
import java.util.List;

public interface ProdutoService {

    public void salvar(Produto produto);
    public Produto buscarPorId(Long id);
    public List<Produto> listarTodas();
    public void removerPorId(Long id);
}
