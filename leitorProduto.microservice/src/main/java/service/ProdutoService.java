package service;

import model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProdutoRepo;

import javax.transaction.Transactional;
import java.util.List;

/**
 * classe que implementa os metodos do repositorio de produtos
 */
@Service
@Transactional
public class ProdutoService {

    /**
     * se instancia aplicando a anotacao Autowired de spring
     * mediante o uso de constructora interface ProdutoRepo
     * para ser utilizada pela classe de serviços
     */
    private final ProdutoRepo produtoRepo;


    @Autowired
    public ProdutoService(ProdutoRepo produtoRepo) {
        this.produtoRepo = produtoRepo;
    }

    /**
     * retorna todos os elementos em lista de produtos
     *
     * @return List<Produto>
     */
    public List<Produto> findAllProdutos() {
        return produtoRepo.findAll();
    }

    /**
     * recebe um produto para ser atualizado
     *
     * @param produto
     *
     * @return List<Produto>
     */
    public Produto updateProduto(Produto produto) {
        return produtoRepo.save(produto);
    }

    /**
     * recebe o id para ser buscado na tavela e retorna um unico produto
     * perteneciente a esse id
     *
     * @param id
     * @return Produto
     */
    public Produto findProdutoById(Long id) {
        return produtoRepo.findProdutoById(id);
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
    public List<Produto> getProdutoByNome(String nome){
        return produtoRepo.findProdutoByNome(nome);
    }

    /**
     * recebe um id para ser buscado na tavela e elimina da tavela
     * @param id
     */
    public void deleteProduto(Long id){
        produtoRepo.deleteProdutoById(id);
    }


    /*public Produto addProduto(Produto produto) {
    	return produtoRepo.save(produto);
    }*/

}