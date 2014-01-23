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
        
        // Rows
        String series1 = "Part1";
        String series2 = "Part2";
        String series3 = "Part3";
        String series4 = "Part4";

        // Columns
        String category1 = "9/12/13";
        String category2 = "16/12/13";
        String category3 = "23/12/13";
        String category4 = "30/12/13";
        String category5 = "3/1/14";
        String category6 = "6/1/14";
        String category7 = "13/1/14";
        String category8 = "20/1/14";

        // dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(474, series1, category1);
        dataset.addValue(828, series1, category2);
        dataset.addValue(798, series1, category3);
        dataset.addValue(450, series1, category4);
        dataset.addValue(103, series1, category5);
        dataset.addValue(204, series1, category6);
        dataset.addValue(689, series1, category7);
        dataset.addValue(246, series1, category8);
        
        dataset.addValue(578, series2, category1);
        dataset.addValue(880, series2, category2);
        dataset.addValue(553, series2, category3);
        dataset.addValue(353, series2, category4);
        dataset.addValue(356, series2, category5);
        dataset.addValue(335, series2, category6);
        dataset.addValue(430, series2, category7);
        dataset.addValue(272, series2, category8);
        
        dataset.addValue(556, series3, category1);
        dataset.addValue(398, series3, category2);
        dataset.addValue(391, series3, category3);
        dataset.addValue(198, series3, category4);
        dataset.addValue(788, series3, category5);
        dataset.addValue(345, series3, category6);
        dataset.addValue(232, series3, category7);
        dataset.addValue(491, series3, category8);
        
        dataset.addValue(809, series4, category1);
        dataset.addValue(315, series4, category2);
        dataset.addValue(211, series4, category3);
        dataset.addValue(383, series4, category4);
        dataset.addValue(333, series4, category5);
        dataset.addValue(108, series4, category6);
        dataset.addValue(172, series4, category7);
        dataset.addValue(673, series4, category8);

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
        JFreeChart jfreechart = ChartFactory.createStackedBarChart("Post Type Mix Over Time"
                , "", "# of Posts by Type"
                , createDataset1()
                , PlotOrientation.VERTICAL, false, true, false);
        
        jfreechart.setBackgroundPaint(Color.white);
        CategoryPlot categoryplot = (CategoryPlot) jfreechart.getPlot();
        categoryplot.setBackgroundPaint(new Color(238, 238, 255));
        CategoryDataset categorydataset = createDataset2();
        categoryplot.setDataset(1, categorydataset);
        categoryplot.mapDatasetToRangeAxis(1, 1);
        CategoryAxis categoryaxis = categoryplot.getDomainAxis();
        categoryaxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);
        StackedBarRenderer stackedbarrenderer = (StackedBarRenderer) categoryplot.getRenderer();
        stackedbarrenderer.setDrawBarOutline(false);
        stackedbarrenderer.setItemLabelsVisible(true);
        stackedbarrenderer.setSeriesItemLabelGenerator(0, new StandardCategoryItemLabelGenerator());
        stackedbarrenderer.setSeriesItemLabelGenerator(1, new StandardCategoryItemLabelGenerator());
        stackedbarrenderer.setSeriesItemLabelGenerator(2, new StandardCategoryItemLabelGenerator());
        stackedbarrenderer.setSeriesItemLabelGenerator(3, new StandardCategoryItemLabelGenerator());
        
        NumberAxis numberaxis = new NumberAxis("Likes+Shares+Comments");
        categoryplot.setRangeAxis(1, numberaxis);
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
            //instantiate document and writer
            document = new Document();
            writer = PdfWriter.getInstance(document, outputStream);

            //open document
            document.open();

            //add image
            int width = 500;
            int height = 500;
            JFreeChart chart = createChart();
            BufferedImage bufferedImage = chart.createBufferedImage(width, height);
            Image image = Image.getInstance(writer, bufferedImage, 1.0f);
            document.add(image);

            //release resources
            document.close();
            document = null;

            writer.close();
            writer = null;
        } catch (DocumentException de) {
            throw de;
        } finally {
            //release resources
            if (null != document) {
                try {
                    document.close();
                } catch (Exception ex) {
                }
            }

            if (null != writer) {
                try {
                    writer.close();
                } catch (Exception ex) {
                }
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException, DocumentException, IOException {
        (new MyGraph()).create(new FileOutputStream(new File("C://MyGraph.pdf")));
    }
}
