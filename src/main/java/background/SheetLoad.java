package background;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import tech.getarrays.produtomanager.model.Produto;



public class SheetLoad {
	
	
	public LinkedList<Produto> stock = new LinkedList<Produto>();
	
	public String path;
	
	public SheetLoad(String uri) {
		this.path=uri;
		carrega(path);
		//this.stock = stock;
		//System.out.println(stock);
	}


	private Produto articuloTemp = null;
	private String temporal1 = null;
	private Double temporal2 = null;
	
	

	public UploadSQL carrega(String adress) {
		FileInputStream fisPlanilha = null;			
		try {
			
			//File file = new File("C:\\Users\\USER\\eclipse-workspace\\test_2_ler\\products_teste.xlsx");
			
			File file = new File(adress);
			
			fisPlanilha = new FileInputStream(file);
			
			//cria um workbook = planilha toda com todas as abas
			XSSFWorkbook workbook = new XSSFWorkbook(fisPlanilha);
			
			//recuperamos apenas a primeira aba ou primeira planilha
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			//retorna todas as linhas da planilha 0
			Iterator<Row> rowIterator = sheet.iterator();
			
			int i = 0;	
			
			
			while(rowIterator.hasNext()) {
				
				//recebe cada linha da planilha
				Row row = rowIterator.next();
				
				//pegamos todas as celulas desta linha
				Iterator<Cell> cellIterator = row.iterator();
				
				//varremos todas as celulas da linha atual
					
				if(i>=2) {
					articuloTemp = new Produto();
				}			
				int j = 0;
				while(cellIterator.hasNext()) {
					//criamos uma celula
					Cell cell = cellIterator.next();
					
					switch(cell.getCellType()) {
					
					case Cell.CELL_TYPE_STRING:
						//System.out.println("Tipo String " + cell.getStringCellValue());
						temporal1=cell.getStringCellValue();
						
						break;
						
					case Cell.CELL_TYPE_NUMERIC:
						//System.out.println("Tipo Numeric " + cell.getNumericCellValue());
						temporal2= cell.getNumericCellValue();
											
						break;						
					case Cell.CELL_TYPE_FORMULA:
						//System.out.println("Tipo Formula " + cell.getCellFormula());
						temporal1 = cell.getCellFormula();
						break;					
					}					
					if(i>=2) {
						switch(j) {
						case 0:
							System.out.println(temporal2);
							articuloTemp.setId((long) Math.round(temporal2));
							break;
						case 1:
							System.out.println(temporal1);
							articuloTemp.setNome(temporal1);
							break;
						case 2:
							System.out.println(temporal2);
							articuloTemp.setTaxa(String.valueOf(temporal2));
							break;
						case 3:
							System.out.println(temporal1);
							articuloTemp.setDescricao(temporal1);
							break;
						case 4:
							System.out.println(temporal1+"->here");
							articuloTemp.setPreco(temporal1);
							break;
						}
					}
					j++;
					
					if(j==5 && i>=2) {
						System.out.println(articuloTemp);
						stock.add(articuloTemp);
						//add elemento to linkedlist
					}					 
					System.out.println("A->"+j);
					}			
				i++;
				System.out.println("B->"+i);
				}
			System.out.println(stock.get(2).getNome());	
		
			
		//tratemento de erros
		
		}catch(FileNotFoundException ex){
			
			Logger.getLogger(SheetLoad.class.getName()).log(Level.SEVERE, null, ex);
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally {
			try {
				fisPlanilha.close();
				 
			}catch(IOException ex) {
				Logger.getLogger(SheetLoad.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		
		
		
		
		return  new UploadSQL(stock);
	}
	
	
	
	
}
