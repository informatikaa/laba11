import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

public class Task5 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Point Projection");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series = new XYSeries("Проекция");

        // Введите координаты точек через которые проходит прямая и произвольной точки
        double x1 = 0, y1 = 0, x2 = 5, y2 = 5, x = 3, y = 2;

        double[] projection = calculateProjection(x1, y1, x2, y2, x, y);
        series.add(x, y);
        series.add(projection[0], projection[1]);

        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createScatterPlot("Проекция точек", "X", "Y", dataset, PlotOrientation.VERTICAL, true, true, false);
        XYPlot plot = (XYPlot) chart.getPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, true);
        plot.setRenderer(renderer);

        ChartPanel chartPanel = new ChartPanel(chart);
        frame.add(chartPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static double[] calculateProjection(double x1, double y1, double x2, double y2, double x, double y) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        double u = ((x - x1) * dx + (y - y1) * dy) / (dx * dx + dy * dy);

        double projectionX = x1 + u * dx;
        double projectionY = y1 + u * dy;

        return new double[]{projectionX, projectionY};
    }
}
