package dynamicproxypattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import dynamicproxypattern.employee.Employee;

public class EmployeeInvocationHandler implements InvocationHandler {
   Employee employee;

   public EmployeeInvocationHandler(Employee employee) {
      this.employee = employee;
   }

   public Object invoke(Object proxy, Method method, Object args[]) throws IllegalAccessException {
      try {
         if (method.getName().startsWith("get")) {
            return method.invoke(employee, args);
         } else if (method.getName().startsWith("set")) {
            throw new IllegalAccessException();
         } else {
            throw new IllegalAccessException();
         }
      } catch (InvocationTargetException ex) {
         ex.printStackTrace();
      }
      return null;
   }
}