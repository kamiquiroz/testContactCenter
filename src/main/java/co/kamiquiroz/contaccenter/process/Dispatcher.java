package co.kamiquiroz.contaccenter.process;
import co.kamiquiroz.contaccenter.entities.CallQueue;
import co.kamiquiroz.contaccenter.entities.Employee;
import java.util.List;
import java.util.Random;

import static java.util.concurrent.ThreadLocalRandom.current;

public class Dispatcher implements Runnable{

    // simulate the time required for the phone call (between one and ten seconds)
    private long duration;
    private int maxCallsAllowed = 10;
    private int currentCalls = 0;
    private boolean running;
    Random random;


    public Dispatcher(){


    }

    public void dispatcherCalls(List<Employee> employees){

        for ( int i = 0; i < employees.size(); i++ )
        {
            new Employee( i + 1,"karen" ).start();
        }
    }
    public void run(){
        while ( running )
        {
            duration = current().nextLong(5,10);
            if ( duration > 1 )
            {
                System.out.println( "Creando una llamada con una duracion de " + duration + " minutos" );
                CallQueue.queueCall(((int) duration));
                sleep();
            }
        }

    }

    public Dispatcher start()
    {
        running = true;
        new Thread( this ).start();
        return null;
    }

    public void stop()
    {
        running = false;
    }


    public void main(String args[]){

    }

    public void sleep(){
        try
        {
            int sleep = random.nextInt( 2 * 60 );
            //log( "going to sleep " + sleep + " seconds" );
            Thread.sleep( sleep * 1000 );
        }
        catch ( InterruptedException e )
        {
            e.printStackTrace();
        }
    }



    public void receiveCall() {
        System.out.println("A director is taking the call");
    }
}
