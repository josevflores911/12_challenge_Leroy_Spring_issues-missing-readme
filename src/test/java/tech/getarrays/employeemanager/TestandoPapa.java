package tech.getarrays.employeemanager;


import static org.junit.jupiter.api.Assertions.assertTrue;

//import javafx.application.Application;
import org.assertj.core.api.Assertions;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.jupiter.api.Test;
//import org.junit.rules.ExpectedException;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


import org.springframework.transaction.annotation.Transactional;
import tech.getarrays.produtomanager.model.Produto;
import tech.getarrays.produtomanager.repo.ProdutoRepo;

//@RunWith(SpringRunner.class)
//@DataJpaTest
//@SpringBootTest(classes=tech.getarrays.produtomanager.ProdutomanagerApplication.class)
//@SpringBootTest(classes = Application.class)
//@ContextConfiguration(classes=Application.class)
//@ContextConfiguration (locations = "classpath*:/spring/applicationContext*.xml")
//@ContextConfiguration(locations = {"file:src/main/resources/applicationContext.xml"})
//@WebAppConfiguration
//@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:spring-servlet.xml"}) //  Because there's no  applicationContext-quartz.xml  The configuration file is loaded in , So it leads to the occurrence of anomalies
//@Transactional
public class TestandoPapa {
	/*
	@Test
    public void testSampleTest() {
        assertTrue(true, "Should be true");
    }
	
	@Autowired
	private ProdutoRepo produtoRepo;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void createShouldPersistData() {
		Produto produto = new Produto(1L,"carlos","1","e feio","nada");
		this.produtoRepo.save(produto);
		
		Assertions.assertThat(produto.getId()).isNotNull();
	}*/

}
