package mygraph;

import java.awt.Color;
import java.awt.image.BufferedImage;
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

import java.io.File;
import java.io.FileOutputStream;


public class ColumnChart {


    public JFreeChart createChart(DefaultCategoryDataset dataset, CategoryDataset category) {

        JFreeChart jfreechart = ChartFactory.createStackedBarChart(
                "Statistical Quality Control"
                , "Time Period Elapsed"
                , "Product Types"
                , dataset
                , PlotOrientation.VERTICAL, false, true, false);

        jfreechart.setBackgroundPaint(Color.white);

        CategoryPlot categoryplot = (CategoryPlot) jfreechart.getPlot();
        categoryplot.setBackgroundPaint(new Color(238, 238, 255));
        
        CategoryDataset categorydataset = category;
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

    public void create(DefaultCategoryDataset dataset, CategoryDataset category, String file) 
            throws DocumentException, IOException {
        
        Document document = null;
        PdfWriter writer = null;

        try {
            document = new Document();
            OutputStream out = new FileOutputStream(new File(file));
            writer = PdfWriter.getInstance(document, out);
            document.open();

            int width = 550;
            int height = 700;
            
            JFreeChart chart = createChart(dataset, category);
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
}
