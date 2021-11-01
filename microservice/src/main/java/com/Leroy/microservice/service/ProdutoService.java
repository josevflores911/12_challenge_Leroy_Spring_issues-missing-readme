package com.Leroy.microservice.service;

import com.Leroy.microservice.model.Produto;

import java.util.List;
/**
 * interface que estabelece os metodos que seram implementados no service
 */
public interface ProdutoService  {
    public List<Produto> listAllProduto();
    public Produto getProdutoById(Long id);

    //public Produto createProduto(Produto produto);
    public Produto updateProduto(Produto produto);
    public void deleteProduto(Long id);


    List<Produto> getProdutoByNome(String nome);
}
