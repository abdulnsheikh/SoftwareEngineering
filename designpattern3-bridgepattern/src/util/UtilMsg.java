package util;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class UtilMsg {

   static Display display = null;
   static Shell shell = null;

   public static void init() {
      display = new Display();
      shell = new Shell(display);
      shell.setLayout(new GridLayout(1, false));
   }

   public static void openShell() {
      shell.open();
      while (!shell.isDisposed()) {
         if (!display.readAndDispatch()) {
            display.sleep();
         }
      }
      display.dispose();
   }

   public static void doShowMessageBox(String msg) {
      init();
      Text t = new Text(shell, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
      t.setFont(new Font(display, new FontData("Arial", 24, SWT.BOLD)));
      t.setLayoutData(new GridData(GridData.FILL_BOTH));

      MessageBox dia = new MessageBox(shell, SWT.ICON_WARNING | SWT.OK);
      dia.setText("Warning");
      dia.setMessage(msg);
      dia.open();

      openShell();
   }

   // public static void main(String[] args) {
   // doShowMessageBox("Hello!!!");
   // }
}
