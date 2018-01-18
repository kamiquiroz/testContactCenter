package co.kamiquiroz.contaccenter.process;

import co.kamiquiroz.contaccenter.entities.Employee;

import java.util.List;

public class ContacCenterSimulator {

    public static void main(String args[]){
        List<Employee> employees= new List<Employee>();
        employees.add(new Employee (1,"Vanessa") );
        employees.add(new Employee (2,"Irina")   );
        employees.add(new Employee (3,"Rogelio") );
        employees.add(new Employee (4,"Martha")  );
        employees.add(new Employee (5,"Esneda")  );
        employees.add(new Employee (6,"Annie")   );
        employees.add(new Employee (7,"Nahiara") );
        employees.add(new Employee (8,"Elias")   );
        employees.add(new Employee (9,"Lili")    );
        employees.add(new Employee (10,"Gisselle"));

        new Dispatcher(employees).start();

    }
}
