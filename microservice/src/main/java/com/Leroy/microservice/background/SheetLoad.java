package com.Leroy.microservice.background;

import com.Leroy.microservice.model.Produto;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  classe com as livrarias de apache org que contem todos os componentes necesarios para
 *  fazer a interpretacao dos arquivos com extensao .xlsx e .xls  a classes interpretan e varrem
 *  or arquivo por filas, columnas e celulas assim como cada uma das folhas que tem o arquivo
 *  e preciso indicar o endereco onde se encontra o arquivo e com este as subclases descompoen o arquivo
 */
public class SheetLoad {

    /**
     * propiedades necesarias para descarregar os dados do arquivo com extensao .xlsx
     * e almacenar na base de dados,
     *
     * linkedlist almacena todas as instancias de produtos encontradas
     *
     * path variavel que serve de parametro para o metodo de carrega
     *
     * articuloTemp, temporal1, temporal 2, variaveis auxiliares que toman os valores
     * do tipo string, double, Produto para almacenar nas distintas posicoes do array
     */
    public LinkedList<Produto> stock = new LinkedList<>();

    public String path;

    private Produto articuloTemp = null;
    private String temporal1 = null;
    private Double temporal2 = null;

    /**
     * constructo que toma o endereco (path) e aplica como parametro do metodo
     * @param uri
     */
    public SheetLoad(String uri) {
        this.path=uri;
        carrega(path);

    }

    /**
     * este metodo de apache.org contem todas as carateristicas necesarias para a leitura de todas as
     * celulas presentes no arquivo
     *
     * inicialmente procura o arquivo no endereco local
     * cria um workbook = planilha toda com todas as abas
     * recuperamos apenas a primeira aba ou primeira planilha
     * retorna todas as linhas da planilha 0
     *
     * realiza duas iteracoes
     * a primeira:
     * recebe cada linha da planilha
     * pega todas as celulas desta linha
     * varremos todas as celulas da linha atual
     *
     * na segunda iteracao interna da primeira(loop inside loop)
     *
     * criamos uma celula que le o valor que pode ser do tipo string, double, formula(string)...
     *
     * o valor achado para cada celula e asignado as propriedades da instancia produto do linkedlist
     * mediante um switch que contem os getters e setter para a instancia
     *
     * feita a leitura total retorna uma clase DAO com o arreglo com todos as instancias de produto
     *
     * @param  adress
     *
     * @return DAO(stock)
     */
    public DAO carrega(String adress) {
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
                                articuloTemp.setId(Math.round(temporal2));
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

        return  new DAO(stock);
    }

}
