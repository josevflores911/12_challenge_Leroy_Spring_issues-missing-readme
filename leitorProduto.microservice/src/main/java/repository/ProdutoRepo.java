package repository;

import model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProdutoRepo extends JpaRepository<Produto, Long> {
    void deleteProdutoById(Long id);

    Produto findProdutoById(Long id);

    List<Produto> findProdutoByNome(String nome);
}

