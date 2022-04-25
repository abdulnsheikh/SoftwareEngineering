package dynamicproxypattern.employee;

public class EmployeeImpl implements Employee {
   private String name;

   public EmployeeImpl(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}