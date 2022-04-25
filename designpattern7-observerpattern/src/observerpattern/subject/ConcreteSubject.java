package observerpattern.subject;

import java.util.List;

public class ConcreteSubject extends Subject {
   private List<Integer> state;

   public List<Integer> getState() {
       return state;
   }

   public void setState(List<Integer> state) {
       this.state = state;
       notifyAllObservers();
   }
}
