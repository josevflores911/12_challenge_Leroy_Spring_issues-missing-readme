package background;

import java.util.Scanner;

public class PanelAdress {
	
	public PanelAdress(){
		construi();		
	}
	
	
	public void construi() {
		Scanner keyboard= new Scanner(System.in);
		System.out.println("Give a path with products_teste.xlsx");
		String line = keyboard.nextLine(); //stringbuffered
		
		System.out.println("You gave " + line +"\\products_teste.xlsx");
		
		SheetLoad download = new SheetLoad();
		download.carrega(line+"\\products_teste.xlsx");
			
	}
	
	
}
