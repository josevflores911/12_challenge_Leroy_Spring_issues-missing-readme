package tech.getarrays.produtomanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.getarrays.produtomanager.model.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepo extends JpaRepository<Produto, Long> {
    void deleteEmployeeById(Long id);

    Produto findEmployeeById(Long id);
}
