package background;

import java.util.Scanner;

public class PathReader {

       protected String uri;

    public String line;

    public PathReader() {
        construi();
    }


    public void construi() {

        Scanner keyboard= new Scanner(System.in);

        System.out.println("Give a path with products_teste.xlsx");
        line = keyboard.nextLine();
        System.out.println("You gave " + line +"\\products_teste.xlsx");

        uri = line+"\\products_teste.xlsx";

        SheetLoad download = new SheetLoad(uri);

    }
}

