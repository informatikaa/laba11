import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите начало интервала:");
        double start = scanner.nextDouble();

        System.out.println("Введите конец интервала:");
        double end = scanner.nextDouble();

        XYSeries series = new XYSeries("График функции");

        for (double x = start; x <= end; x += 0.1) {
            double y = Math.sin(x); // Пример функции, замените на свою
            series.add(x, y);
        }

        XYSeriesCollection dataset = new XYSeriesCollection(series);

        JFreeChart chart = ChartFactory.createXYLineChart(
                "График функции", "X", "Y",
                dataset, PlotOrientation.VERTICAL,
                true, true, false);

        JFrame frame = new JFrame("График");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ChartPanel(chart));
        frame.pack();
        frame.setVisible(true);
    }
}

