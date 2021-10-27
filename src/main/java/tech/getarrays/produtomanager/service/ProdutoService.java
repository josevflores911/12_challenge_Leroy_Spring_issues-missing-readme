package tech.getarrays.produtomanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tech.getarrays.produtomanager.model.Produto;
import tech.getarrays.produtomanager.repo.ProdutoRepo;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class ProdutoService {
    private final ProdutoRepo produtoRepo;

    @Autowired
    public ProdutoService(ProdutoRepo produtoRepo) {
        this.produtoRepo = produtoRepo;
    }

   

    public List<Produto> findAllEmployees() {
        return produtoRepo.findAll();
    }

    public Produto updateEmployee(Produto produto) {
        return produtoRepo.save(produto);
    }

    public Produto findEmployeeById(Long id) {
        return produtoRepo.findEmployeeById(id);
    }

    public void deleteEmployee(Long id){
        produtoRepo.deleteEmployeeById(id);
    }
}
