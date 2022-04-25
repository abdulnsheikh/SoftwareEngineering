package observerpattern.observer;

import observerpattern.subject.ConcreteSubject;

public abstract class Observer {
   ConcreteSubject subject;

   public abstract void update();
}
