package mygraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import com.lowagie.text.DocumentException;

public class MyGraph {

    public static void main(String[] args) throws FileNotFoundException
            , DocumentException, IOException {
        
        ColumnChart chart1 = new ColumnChart();
        chart1.create(new FileOutputStream(new File("C://MyGraph.pdf")));        
        System.out.println("C://MyGraph.pdf Finish ...");
    }
}
