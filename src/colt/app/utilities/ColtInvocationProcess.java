/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package colt.app.utilities;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.ImageIcon;
import javax.swing.SwingWorker;

/**
 * Class responsible for making requests and delegating to the controller
 * @author <h1>Andres Felipe Escobar Lopez - andresfescobar92@gmail.com</h1>
 */
public class ColtInvocationProcess extends SwingWorker<Void, Void> implements PropertyChangeListener {

    private ColtLoadProcess screen;
    private InvocationMethod invoke;
    private CallBackInvoke callBack;

    /**
     * Delegates executions
     */
    public interface InvocationMethod {

        void invoke();
    }

    /**
     * Called syncs after processing in the controller
     */
    public interface CallBackInvoke {

        void callBackInvoke();
    }

    public ColtInvocationProcess(InvocationMethod invoke, CallBackInvoke callBack) {
        this.invoke = invoke;
        this.callBack = callBack;
    }

    public ColtInvocationProcess(InvocationMethod invoke) {
        this.invoke = invoke;
    }

    @Override
    protected Void doInBackground() throws Exception {
        setProgress(1);
        this.invoke.invoke();
        return null;
    }

    /*
     * Executed in event dispatching thread
     */
    @Override
    protected void done() {
        if(screen!=null)screen.dispose();
        if (callBack != null) {
            callBack.callBackInvoke();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("progress".equals(evt.getPropertyName())) {
            int progress = (Integer) evt.getNewValue();
            if(screen!=null)screen.setProgreso(progress, true);
        }
    }

    /**
     * Invokes the method asynchronously by placing a progress bar in the main window
     */
    public void invoke() {
        /*ImageIcon myImage = new ImageIcon(getClass().getResource("/img/processing.png"));*/
        screen = new ColtLoadProcess(null);
        screen.setLocationRelativeTo(null);
        screen.setVisible(true);
        this.addPropertyChangeListener(this);
        this.execute();
    }
}
