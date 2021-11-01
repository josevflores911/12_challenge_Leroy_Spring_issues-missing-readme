package com.Leroy.microservice;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.Leroy.microservice.model.Produto;
import com.Leroy.microservice.repository.ProdutoRepository;
import com.Leroy.microservice.service.ProdutoService;
import com.Leroy.microservice.service.ProdutoServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ProdutoServiceMockTest {

    @Mock
    private ProdutoRepository productRepository;

    private ProdutoService productService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        productService =  new ProdutoServiceImpl( productRepository);
        Produto computer =  Produto.builder()
                .id(1L)
                .nome("computer")
                .taxa("taxadp")
                .descricao("cosa")
                .preco("caro")
                .build();

        Mockito.when(productRepository.findById(1L))
                .thenReturn(Optional.of(computer));
        Mockito.when(productRepository.save(computer)).thenReturn(computer);

    }

    @Test
    public void whenValidGetID_ThenReturnProduct(){
        Produto found = productService.getProdutoById(1L);

        Assertions.assertThat(found.getNome()).isEqualTo("computer");

    }

    @Test
    public void whenValidUpdateStock_ThenReturnNewStock(){
        Produto newStock = productService.updateProduto(new Produto(1L,"carlos","a","a","a"));
        Assertions.assertThat(newStock.getNome()).isEqualTo("carlos");
    }
}
