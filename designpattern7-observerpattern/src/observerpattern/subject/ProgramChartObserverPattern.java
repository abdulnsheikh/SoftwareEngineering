package observerpattern.subject;

import observerpattern.observer.ObserverBarChart;
import observerpattern.observer.ObserverPieChart;

public class ProgramChartObserverPattern {
   public static void main(String[] args) {
      ConcreteSubject subject = new ConcreteSubject();
      new ObserverPieChart(subject);
      new ObserverBarChart(subject);
   }
}
