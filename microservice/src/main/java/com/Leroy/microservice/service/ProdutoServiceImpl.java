package com.Leroy.microservice.service;

import com.Leroy.microservice.model.Produto;
import com.Leroy.microservice.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
/**
 * classe que implementa os metodos do repositorio de produtos
 */
@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl  implements ProdutoService{

    /**
     * se instancia aplicando a anotacao Autowired de spring
     * mediante o uso de constructora interface ProdutoRepo
     * para ser utilizada pela classe de serviços
     */
    private final ProdutoRepository produtoRepository;

    /**
     * retorna todos os elementos em lista de produtos
     *
     * @return List<Produto>
     */
    @Override
    public List<Produto> listAllProduto() {
        return produtoRepository.findAll();
    }

    /**
     * recebe o id para ser buscado na tavela e retorna um unico produto
     * perteneciente a esse id
     *
     * @param id
     * @return Produto
     */
    @Override
    public Produto getProdutoById(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }


    /**
     * recebe um produto para ser atualizado
     *
     * @param produto
     *
     * @return List<Produto>
     */
    @Override
    public Produto updateProduto(Produto produto) {
        Produto produtoDB = getProdutoById(produto.getId());
        if (null == produtoDB){
            return null;
        }
        produtoDB.setNome(produto.getNome());
        produtoDB.setDescricao(produto.getDescricao());
        produtoDB.setPreco(produto.getPreco());
        return produtoRepository.save(produtoDB);
    }

    /**
     * recebe um id para ser buscado na tavela e elimina da tavela
     * @param id
     */
    @Override
    public void deleteProduto(Long id) {
        produtoRepository.deleteProdutoById(id);
    }

    //poderia procurar elementos parciais no nome
    /**
     *
     recebe o id para ser buscado na tavela e retorna um unico produto
     * perteneciente ao nome exaito como aparece na tavela
     *
     * @param nome
     * @return Produto
     */
    @Override
    public List<Produto> getProdutoByNome(String nome) {
        return produtoRepository.findProdutoByNome(nome);
    }

  /*@Override
    public Produto createProduto(Produto produto) {
        return produtoRepository.save(produto);
    }*/
}
