package observerpattern.observer;

import java.awt.BorderLayout;
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
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

import observerpattern.subject.ConcreteSubject;

public class ObserverPieChart extends Observer {
   JFrame framePieChart;
   JButton buttonPie;
   DefaultPieDataset dataContainerPie = new DefaultPieDataset();

   public ObserverPieChart(ConcreteSubject subject) {
      this.subject = subject;
      this.subject.attach(this);

      initDataset();
      framePieChart = new JFrame("Pie Chart");
      framePieChart.getContentPane().setLayout(new BorderLayout());
      JFreeChart chart = createPieChart();
      ChartPanel chartPanel = new ChartPanel(chart);
      chartPanel.setPreferredSize(new Dimension(500, 270));
      framePieChart.getContentPane().add(chartPanel, BorderLayout.CENTER);
      buttonPie = new JButton("Button");

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
      buttonPie.addActionListener(actionListener);

      framePieChart.getContentPane().add(buttonPie, BorderLayout.SOUTH);
      framePieChart.pack();
      framePieChart.setVisible(true);
   }

   @Override
   public void update() {
      dataContainerPie.clear();
      List<Integer> state = subject.getState();
      for (int i = 0; i < state.size(); i++) {
         dataContainerPie.setValue("data " + (i + 1), state.get(i));
      }
   }

   JFreeChart createPieChart() {
      JFreeChart chart = ChartFactory.createPieChart3D("Pie Chart", dataContainerPie, true, true, false);
      PiePlot3D plot = (PiePlot3D) chart.getPlot();
      plot.setStartAngle(290);
      plot.setDirection(Rotation.CLOCKWISE);
      plot.setForegroundAlpha(0.5f);
      return chart;
   }

   void initDataset() {
      dataContainerPie.setValue("data 1", 25);
      dataContainerPie.setValue("data 2", 25);
      dataContainerPie.setValue("data 3", 25);
      dataContainerPie.setValue("data 4", 25);
   }

}
