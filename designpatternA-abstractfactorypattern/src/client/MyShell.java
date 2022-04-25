package client;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

class MyShell {
   Display display;
   Shell shell;
   Composite widgetComp;

   void createShell() {
      display = Display.getDefault();
      shell = new Shell(display, SWT.SHELL_TRIM);
      shell.setText("Abstract Factory Pattern");
      shell.setSize(450, 100);
      shell.setLayout(new FillLayout(SWT.HORIZONTAL));

      widgetComp = new Composite(shell, SWT.NONE);
      widgetComp.setLayout(null);
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