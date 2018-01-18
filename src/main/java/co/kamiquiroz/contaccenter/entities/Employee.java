package co.kamiquiroz.contaccenter.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Employee implements Runnable {
    private long id;
    private String name;
    private EmployeeType employeeType;
    private EmployeeStatus status;
    private long callExpiration;
    private SimpleDateFormat formatter;
    private boolean running;

    public Employee( int id, String nameOperator)
    {
        this.id = id;
        this.name = nameOperator;
        this.employeeType = employeeType.OPERATOR;
        this.status = EmployeeStatus.FREE;
        formatter = new SimpleDateFormat( "HH:mm:ss" );

    }

    public void run() {
        while ( running )
        {
            if ( status == EmployeeStatus.FREE)
            {

                Call call = CallQueue.retrieveCall();
                if ( call != null )
                {
                    System.out.println( "Answering call " + call.getNumber() );
                    callExpiration = System.currentTimeMillis() + ( call.getDuration() * 60 * 1000 );
                    status = EmployeeStatus.IN_A_CALL;
                }
            }
            else
            {
                if ( System.currentTimeMillis() > callExpiration )
                {
                    System.out.println( "hanging up" );
                    status = EmployeeStatus.FREE;
                }
            }
            sleep();
        }

    }

    public boolean busyOperators(List<Employee> employees){
        boolean switchNoBusyOperators=false;
        int cont =0;
        for (Employee employee:employees) {
            if(employee.status.equals(EmployeeStatus.FREE)) {
                if (employee.employeeType.equals(EmployeeType.OPERATOR)) {
                    cont++;
                }
            }
        }

        if(cont>0){
            switchNoBusyOperators=true;
        }
        return switchNoBusyOperators;
    }

    public boolean busySupervisor(List<Employee> employees){
        boolean switchNoBusySupervisor=false;
        int cont =0;
        for (Employee employee:employees) {
            if(employee.status.equals(EmployeeStatus.FREE)) {
                if (employee.employeeType.equals(EmployeeType.SUPERVISOR)) {
                    cont++;
                }
            }
        }

        if(cont>0){
            switchNoBusySupervisor=true;
        }
        return switchNoBusySupervisor;
    }

    public void start()
    {
        running = true;
        new Thread( this ).start();
    }

    public void stop()
    {
        running = false;
    }

    private void log( String s )
    {
        System.out.println( "[" + formatter.format( new Date() ) + "][ServiceAgent][Agent " + id + "] " + s );
    }

    private void sleep()
    {
        try
        {
            Thread.sleep( 5000 );
        }
        catch ( InterruptedException e )
        {
            e.printStackTrace();
        }
    }
}
