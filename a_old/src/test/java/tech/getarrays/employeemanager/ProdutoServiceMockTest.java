package tech.getarrays.employeemanager;

//import javafx.application.Application;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import tech.getarrays.produtomanager.model.Produto;
import tech.getarrays.produtomanager.repo.ProdutoRepo;
import tech.getarrays.produtomanager.service.ProdutoService;


import java.util.Optional;

@SpringBootTest
//@SpringBootTest(classes = Application.class)
//@ContextConfiguration(classes=Application.class)
public class ProdutoServiceMockTest {

    @Mock
    private ProdutoRepo productRepository;

    private ProdutoService produtoService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        produtoService =  new ProdutoService(productRepository);
        Produto computer = new Produto(1L,"a","a","a","a");
                

        Mockito.when(productRepository.findById(1L))
                .thenReturn(Optional.of(computer));
        Mockito.when(productRepository.save(computer)).thenReturn(computer);

    }

    @Test
    public void whenValidGetID_ThenReturnProduct(){
        Produto found = produtoService.findProdutoById(1L);
        Assertions.assertThat(found.getNome()).isEqualTo("computer");

    }

    @Test
    public void whenValidUpdateStock_ThenReturnNewStock(){
        Produto newStock = produtoService.updateProduto(new Produto(1L,"b","b","b","b"));
        Assertions.assertThat(newStock.getTaxa()).isEqualTo("b");
    }
}