package background;

import java.util.LinkedList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;


import tech.getarrays.produtomanager.model.Produto;
import tech.getarrays.produtomanager.service.ProdutoService;


public class PanelAdress {
	
	LinkedList<Produto> fila;
	
	protected String uri;
	
	public String line;
		
	
	public PanelAdress() {
		construi();	
    }
	

	public void construi() {
		Scanner keyboard= new Scanner(System.in);
		
		System.out.println("Give a path with products_teste.xlsx");		
		line = keyboard.nextLine(); 	
		System.out.println("You gave " + line +"\\products_teste.xlsx");
		
		uri = line+"\\products_teste.xlsx";
		
		SheetLoad download = new SheetLoad(uri);
		
		
		//no usado
		//this.fila = download.carrega(uri);
		
		//Produto addSQL = produtoService.addProduto(fila.get(0)); 
			
	}
	
	
}
