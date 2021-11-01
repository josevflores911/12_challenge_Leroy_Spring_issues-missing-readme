package com.Leroy.microservice.background;

import java.util.Scanner;

/**
 * classe que toma a ruta em consola com o arquivo product_teste.xlsx
 * que contem todos os elementos de produtos para ser carregados
 */
public class PathReader {

    /**
     * propiedades do tipo string
     * line recebe o endereco com o arquivo
     * uri adiciona o nome do arquivo a esse endereco
     */
    protected String uri;

    public String line;

    /**
     * constructor que chama o metodo construi responsavel do path
     */
    public PathReader() {
        construi();
    }

    /**
     * metodo sem retorno que instacia a classe SheetLoad responsavel por
     * ler os arquivos com a extensao  .xlsx
     */
    public void construi() {

        Scanner keyboard= new Scanner(System.in);

        System.out.println("Give a path with products_teste.xlsx");
        line = keyboard.nextLine();
        System.out.println("You gave " + line +"\\products_teste.xlsx");

        uri = line+"\\products_teste.xlsx";

        SheetLoad download = new SheetLoad(uri);

    }
}


