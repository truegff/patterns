package ge.lanmaster.pattern.Mediator;

import java.awt.Dialog;
import javax.swing.JDialog;
import org.jdesktop.application.SingleFrameApplication;


/**
 * Hello world!
 */
public class App extends SingleFrameApplication
{
    public static void main( String[] args )
    {
        System.out.println( "Mediator Pattern" );
        launch(App.class, args);
    }

    protected void startup() {
        //show(getMainFrame());
        JDialog jd = new JDialog();
        jd.setSize(100, 100);
        show(jd);
    }
}
