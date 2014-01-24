package mygraph;

import java.io.FileNotFoundException;
import java.io.IOException;
import com.lowagie.text.DocumentException;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class MyGraph {

    public static void main(String[] args) 
            throws FileNotFoundException, DocumentException, IOException {
        
        DefaultCategoryDataset dataset = GetData(); 
        CategoryDataset category = GetCategory();
        
        ColumnChart chart1 = new ColumnChart();        
        chart1.create(dataset, category, "C://MyGraph.pdf");        
        System.out.println("C://MyGraph.pdf Finish ...");
    }

    private static DefaultCategoryDataset GetData() {
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String row1 = "Part1";
        String row2 = "Part2";
        String row3 = "Part3";
        String row4 = "Part4";
        String col1 = "9/12/13";
        String col2 = "16/12/13";
        String col3 = "23/12/13";
        String col4 = "30/12/13";
        String col5 = "3/1/14";
        String col6 = "6/1/14";
        String col7 = "13/1/14";
        String col8 = "20/1/14";
        dataset.addValue(474, row1, col1);
        dataset.addValue(828, row1, col2);
        dataset.addValue(798, row1, col3);
        dataset.addValue(450, row1, col4);
        dataset.addValue(103, row1, col5);
        dataset.addValue(204, row1, col6);
        dataset.addValue(689, row1, col7);
        dataset.addValue(246, row1, col8);
        dataset.addValue(578, row2, col1);
        dataset.addValue(880, row2, col2);
        dataset.addValue(553, row2, col3);
        dataset.addValue(353, row2, col4);
        dataset.addValue(356, row2, col5);
        dataset.addValue(335, row2, col6);
        dataset.addValue(430, row2, col7);
        dataset.addValue(272, row2, col8);
        dataset.addValue(556, row3, col1);
        dataset.addValue(398, row3, col2);
        dataset.addValue(391, row3, col3);
        dataset.addValue(198, row3, col4);
        dataset.addValue(788, row3, col5);
        dataset.addValue(345, row3, col6);
        dataset.addValue(232, row3, col7);
        dataset.addValue(491, row3, col8);
        dataset.addValue(809, row4, col1);
        dataset.addValue(315, row4, col2);
        dataset.addValue(211, row4, col3);
        dataset.addValue(383, row4, col4);
        dataset.addValue(333, row4, col5);
        dataset.addValue(108, row4, col6);
        dataset.addValue(172, row4, col7);
        dataset.addValue(673, row4, col8);
        return dataset;
    }
    
    /* Single Dataset Graph*/
    private static CategoryDataset GetCategory() {
        String total = "Total Quantity";

        String period1 = "9/12/13";
        String period2 = "16/12/13";
        String period3 = "23/12/13";
        String period4 = "30/12/13";
        String period5 = "3/1/14";
        String period6 = "6/1/14";
        String period7 = "13/1/14";
        String period8 = "20/1/14";

        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(15, total, period1);
        defaultcategorydataset.addValue(24, total, period2);
        defaultcategorydataset.addValue(31, total, period3);
        defaultcategorydataset.addValue(25, total, period4);
        defaultcategorydataset.addValue(56, total, period5);
        defaultcategorydataset.addValue(37, total, period6);
        defaultcategorydataset.addValue(77, total, period7);
        defaultcategorydataset.addValue(18, total, period8);
        
        return defaultcategorydataset;
    }    
}
