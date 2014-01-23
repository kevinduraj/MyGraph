/* lib: jfreechart-1.0.17.jar, jcommon-1.0.21.jar, itext-2.1.7 */
package mygraph;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.block.BlockContainer;
import org.jfree.chart.block.BorderArrangement;
import org.jfree.chart.block.EmptyBlock;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.chart.title.CompositeTitle;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfWriter;

public class MyGraph {

    private static CategoryDataset createDataset1() {

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

        // dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

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

    private static CategoryDataset createDataset2() {
        String s = "Total Quantity";

        String s1 = "9/12/13";
        String s2 = "16/12/13";
        String s3 = "23/12/13";
        String s4 = "30/12/13";
        String s5 = "3/1/14";
        String s6 = "6/1/14";
        String s7 = "13/1/14";
        String s8 = "20/1/14";

        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(15D, s, s1);
        defaultcategorydataset.addValue(24D, s, s2);
        defaultcategorydataset.addValue(31D, s, s3);
        defaultcategorydataset.addValue(25D, s, s4);
        defaultcategorydataset.addValue(56D, s, s5);
        defaultcategorydataset.addValue(37D, s, s6);
        defaultcategorydataset.addValue(77D, s, s7);
        defaultcategorydataset.addValue(18D, s, s8);
        return defaultcategorydataset;
    }

    private static JFreeChart createChart() {

        JFreeChart jfreechart = ChartFactory.createStackedBarChart(
                "Statistical Quality Control", "Time Period", "Product Types", createDataset1(), PlotOrientation.VERTICAL, false, true, false);

        jfreechart.setBackgroundPaint(Color.white);

        CategoryPlot categoryplot = (CategoryPlot) jfreechart.getPlot();
        categoryplot.setBackgroundPaint(new Color(238, 238, 255));
        CategoryDataset categorydataset = createDataset2();
        categoryplot.setDataset(1, categorydataset);
        categoryplot.mapDatasetToRangeAxis(1, 1);

        CategoryAxis categoryaxis = categoryplot.getDomainAxis();
        categoryaxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);

        /* 
         http://www.jfree.org/jfreechart/api/javadoc/org/jfree/chart/renderer/category/StackedBarRenderer.html        
         */
        StackedBarRenderer label = (StackedBarRenderer) categoryplot.getRenderer();
        label.setDrawBarOutline(false);
        label.setBaseItemLabelsVisible(true);
        label.setSeriesItemLabelGenerator(0, new StandardCategoryItemLabelGenerator());
        label.setSeriesItemLabelGenerator(1, new StandardCategoryItemLabelGenerator());
        label.setSeriesItemLabelGenerator(2, new StandardCategoryItemLabelGenerator());
        label.setSeriesItemLabelGenerator(3, new StandardCategoryItemLabelGenerator());

        NumberAxis axis = new NumberAxis(" ");
        categoryplot.setRangeAxis(1, axis);
        
        LineAndShapeRenderer lineandshaperenderer = new LineAndShapeRenderer();
        lineandshaperenderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
        categoryplot.setRenderer(1, lineandshaperenderer);
        categoryplot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);

        LegendTitle legendtitle = new LegendTitle(categoryplot.getRenderer(0));
        legendtitle.setMargin(new RectangleInsets(2D, 2D, 2D, 2D));
        legendtitle.setFrame(new BlockBorder());

        LegendTitle legendtitle1 = new LegendTitle(categoryplot.getRenderer(1));
        legendtitle1.setMargin(new RectangleInsets(2D, 2D, 2D, 2D));
        legendtitle1.setFrame(new BlockBorder());

        BlockContainer blockcontainer = new BlockContainer(new BorderArrangement());
        blockcontainer.add(legendtitle, RectangleEdge.LEFT);
        blockcontainer.add(legendtitle1, RectangleEdge.RIGHT);
        blockcontainer.add(new EmptyBlock(2000D, 0.0D));

        CompositeTitle compositetitle = new CompositeTitle(blockcontainer);
        compositetitle.setPosition(RectangleEdge.BOTTOM);
        jfreechart.addSubtitle(compositetitle);

        return jfreechart;
    }

    public void create(OutputStream outputStream) throws DocumentException, IOException {
        Document document = null;
        PdfWriter writer = null;

        try {
            document = new Document();
            writer = PdfWriter.getInstance(document, outputStream);
            document.open();

            int width = 550;
            int height = 700;
            
            JFreeChart chart = createChart();
            BufferedImage bufferedImage = chart.createBufferedImage(width, height);
            Image image = Image.getInstance(writer, bufferedImage, 1.0f);
            document.add(image);

            document.close();
            document = null;

            writer.close();
            writer = null;
            
        } catch (DocumentException de) {
            throw de;
        } finally {
            if (null != document) {
                try {
                    document.close();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }

            if (null != writer) {
                try {
                    writer.close();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException, DocumentException, IOException {
        (new MyGraph()).create(new FileOutputStream(new File("C://MyGraph.pdf")));
        System.out.println("MyChart Finish ...");
    }
}
