package observerpattern;

import observerpattern.observer.ObserverBarChart;
import observerpattern.observer.ObserverPieChart;
import observerpattern.subject.ConcreteSubject;

public class ObserverPatternDemo {
   public static void main(String[] args) {
      ConcreteSubject subject = new ConcreteSubject();
      new ObserverPieChart(subject);
      new ObserverBarChart(subject);
   }
}
