package util;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class MySWTShell {
   protected Display display = null;
   protected Shell shell = null;

   public void init() {
      display = new Display();
      shell = new Shell(display);
      shell.setLayout(new GridLayout(1, false));
   }

   public void openShell() {
      shell.open();
      while (!shell.isDisposed()) {
         if (!display.readAndDispatch()) {
            display.sleep();
         }
      }
      display.dispose();
   }
}
