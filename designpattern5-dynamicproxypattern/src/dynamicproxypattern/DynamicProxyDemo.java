package dynamicproxypattern;

import java.lang.reflect.Proxy;

import dynamicproxypattern.employee.Employee;
import dynamicproxypattern.employee.EmployeeImpl;
import dynamicproxypattern.proxy.EmployeeInvocationHandler;

public class DynamicProxyDemo {

   public static void main(String[] args) {
      Employee employee1 = new EmployeeImpl("Employee 1");
      Employee employee2 = getObject("Employee 2");

      try {
         System.out.println("Regular Object: Changing the name from \"Employee 1\" to \"Employ X\"");
         employee1.setName("Employee X");
         System.out.println("\tChanged Employee Name: " + employee1.getName());
      } catch (Exception ex) {
         System.out.println("Can't Set Value");
      }

      try {
         System.out.println("Proxy Object: Changing the name from \"Employee 2\" to \"Employ Y\"");
         employee2.setName("Employee Y");
         System.out.println("Name: " + employee2.getName());
      } catch (Exception ex) {
         System.out.println("\tException: Can't Set Value");
      }
   }

   static Employee getObject(String name) {
      Employee employee = new EmployeeImpl(name);

      return (Employee) Proxy.newProxyInstance( //
            employee.getClass().getClassLoader(), //
            employee.getClass().getInterfaces(), //
            new EmployeeInvocationHandler(employee));
   }
}
