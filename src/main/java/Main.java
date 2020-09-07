import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.event.MouseAdapter;
import java.io.PrintStream;

public class Main
{
    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());

    public Main(){
        tieSystemOutAndErrToLog();
    }
    public static void main(String[] args)
    {
        new Main();
        System.out.println("Greetings from a redirected sysout");
        //LOGGER.info("Info Message Logged !!!");

    }

    public static void tieSystemOutAndErrToLog() {
        System.setOut(createLoggingProxy(System.out));
        System.setErr(createLoggingProxy(System.err));
    }

    public static PrintStream createLoggingProxy(final PrintStream realPrintStream) {
        return new PrintStream(realPrintStream) {
            public void print(final String string) {
                realPrintStream.print(string);
                LOGGER.info(string);
            }
        };
    }
}