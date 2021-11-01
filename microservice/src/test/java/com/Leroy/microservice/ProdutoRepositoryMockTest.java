package com.Leroy.microservice;

import com.Leroy.microservice.model.Produto;
import com.Leroy.microservice.repository.ProdutoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ProdutoRepositoryMockTest {

    @Autowired
    private ProdutoRepository productRepository;

    @Test
    public void whenFindByCategory_thenReturnListProduct(){
        Produto product01 = Produto.builder()
                .nome("computer")
                .descricao("aaa")
                .taxa("algo")
                .preco("valor")
                .build();
        productRepository.save(product01);

        int founds= productRepository.findAll().size();

        Assertions.assertThat(founds).isEqualTo(4);


    }
}
