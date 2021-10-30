package tech.getarrays.employeemanager;

import static org.junit.jupiter.api.Assertions.assertTrue;


//import javafx.application.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import tech.getarrays.produtomanager.model.Produto;
import tech.getarrays.produtomanager.repo.ProdutoRepo;
import tech.getarrays.produtomanager.repo.TestProdutoRepo;

//@SpringBootTest(classes = Application.class)
//@ContextConfiguration(classes=Application.class)
@SpringBootTest
//@RunWith(SpringRunner.class)
@DataJpaTest
public class TestandoPapa {
	/*
	@Test
    public void testSampleTest() {
        assertTrue(true, "Should be true");
    }
*/
	@Autowired
	private ProdutoRepo produtoRepo;

	/*@Rule
	public ExpectedException thrown = ExpectedException.none();*/

	@Test
	public void createShouldPersistData() {
		Produto produto = new Produto(1L,"carlos","1","e feio","nada");
		this.produtoRepo.save(produto);

		Assertions.assertThat(produto.getId()).isNotNull();
	}

}
