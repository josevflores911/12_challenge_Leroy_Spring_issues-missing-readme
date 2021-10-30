package repository;

import model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * interface que relaciona nosso repositorio com os metodos jpa
 */

@Repository
public interface ProdutoRepo extends JpaRepository<Produto, Long> {

    /**
     * metodo que recebe o id requerido na tavela para ser eliminado
     *
     * @param id
     */
    void deleteProdutoById(Long id);
    /**
     * metodo que recebe o id requerido na tavela para ser actualizado
     *
     * @param id
     */
    Produto findProdutoById(Long id);
    /**
     * metodo que recebe o nome requerido e retorna seus elementos na tavela
     *
     * @param nome
     */
    List<Produto> findProdutoByNome(String nome);
}

