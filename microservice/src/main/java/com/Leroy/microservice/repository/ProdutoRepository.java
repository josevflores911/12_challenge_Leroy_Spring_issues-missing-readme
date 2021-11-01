package com.Leroy.microservice.repository;

import com.Leroy.microservice.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * interface que relaciona nosso repositorio com os metodos jpa
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    /**
     * metodo que recebe o id requerido na tavela para ser eliminado
     *
     * @param id
     */
    void deleteProdutoById(Long id);

    /**
     * metodo que recebe o nome requerido e retorna seus elementos na tavela
     *
     * @param nome
     */
    List<Produto> findProdutoByNome(String nome);
}
