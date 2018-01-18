package co.kamiquiroz.contaccenter.process;

import co.kamiquiroz.contaccenter.entities.Employee;
import org.junit.Test;

import java.util.List;

public class DispatcherTest {

    Dispatcher dispatcher= new Dispatcher();

    @Test
    public void dispatcherCallsTest() {

        // assert statements
        assert (dispatcher.dispatcherCalls();true);
    }
}
