package observerpattern.observer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import observerpattern.subject.ConcreteSubject;

public class ObserverBarChart extends Observer {
   JFrame frameBarChart;
   JButton buttonBar;
   DefaultCategoryDataset dataContainerBar = new DefaultCategoryDataset();

   public ObserverBarChart(ConcreteSubject subject) {
      this.subject = subject;
      this.subject.attach(this);

      initDataSet();
      frameBarChart = new JFrame("Bar Chart");
      frameBarChart.getContentPane().setLayout(new BorderLayout());
      JFreeChart chart = createChart();
      ChartPanel chartPanel = new ChartPanel(chart, false);
      chartPanel.setPreferredSize(new Dimension(500, 270));
      frameBarChart.getContentPane().add(chartPanel, BorderLayout.CENTER);
      buttonBar = new JButton("Button");

      ActionListener actionListener = new ActionListener() {
         Integer data[] = new Integer[4];

         public void actionPerformed(ActionEvent actionEvent) {
            random();
            subject.setState(Arrays.asList(this.data));
         }

         void random() {
            Random rand = new Random();
            for (int i = 0; i < data.length; i++) {
               data[i] = rand.nextInt(50) + 10;
            }
         }
      };
      buttonBar.addActionListener(actionListener);

      frameBarChart.getContentPane().add(buttonBar, BorderLayout.SOUTH);
      frameBarChart.pack();
      frameBarChart.setVisible(true);
   }

   @Override
   public void update() {
      dataContainerBar.clear();
      List<Integer> state = subject.getState();
      for (int i = 0; i < state.size(); i++) {
         dataContainerBar.addValue(state.get(i), "data " + (i + 1), "");
      }
   }

   JFreeChart createChart() {
      JFreeChart chart = ChartFactory.createBarChart("Bar Chart", "", "Value", dataContainerBar, PlotOrientation.VERTICAL, true, true, false);
      chart.setBackgroundPaint(Color.white);
      CategoryPlot plot = (CategoryPlot) chart.getPlot();
      plot.setBackgroundPaint(Color.lightGray);
      plot.setDomainGridlinePaint(Color.white);
      plot.setDomainGridlinesVisible(true);
      plot.setRangeGridlinePaint(Color.white);
      final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
      rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      BarRenderer renderer = (BarRenderer) plot.getRenderer();
      renderer.setDrawBarOutline(false);
      CategoryAxis domainAxis = plot.getDomainAxis();
      domainAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0));
      return chart;
   }

   private void initDataSet() {
      dataContainerBar.addValue(25, "data 1", "");
      dataContainerBar.addValue(25, "data 2", "");
      dataContainerBar.addValue(25, "data 3", "");
      dataContainerBar.addValue(25, "data 4", "");
   }

}
