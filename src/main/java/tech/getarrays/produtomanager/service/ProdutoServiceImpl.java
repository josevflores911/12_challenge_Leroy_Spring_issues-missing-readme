package tech.getarrays.produtomanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tech.getarrays.produtomanager.model.Produto;
import tech.getarrays.produtomanager.repo.ProdutoRepo;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class ProdutoService {
	//private final ProdutoRepo produtoRepo;
	private ProdutoRepo produtoRepo;

    @Autowired
    public ProdutoService(ProdutoRepo produtoRepo) {
        this.produtoRepo = produtoRepo;
    }

    public List<Produto> findAllProdutos() {
        return produtoRepo.findAll();
    }

    public Produto updateProduto(Produto produto) {
        return produtoRepo.save(produto);
    }

    public Produto findProdutoById(Long id) {
        return produtoRepo.findProdutoById(id);
    }

    public Produto getProduto(Long id) {
        return produtoRepo.findById(id).orElse(null);
    }

    public List<Produto> getProdutoByNome(String nome){
        return produtoRepo.findProdutoByNome(nome);
    }

    public void deleteProduto(Long id){
        produtoRepo.deleteProdutoById(id);
    }
    

    /*public Produto addProduto(Produto produto) {
    	return produtoRepo.save(produto);
    }*/

}
