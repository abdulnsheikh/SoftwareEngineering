package compositepattern;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

class MyShell {
   Display display;
   Shell shell;
   Button buttonThick, buttonThin;
   Canvas drawingCanvas;

   void createShell() {
      display = Display.getDefault();
      shell = new Shell(display, SWT.SHELL_TRIM);
      shell.setText("Example");
      shell.setSize(450, 300);
      shell.setLayout(new FillLayout(SWT.HORIZONTAL));

      Composite widgetComp = new Composite(shell, SWT.NONE);
      widgetComp.setLayout(null);

      buttonThick = new Button(widgetComp, SWT.NONE);
      buttonThick.setBounds(10, 10, 414, 25);
      buttonThick.setText("Redraw (Thick)");

      buttonThin = new Button(widgetComp, SWT.NONE);
      buttonThin.setBounds(10, 37, 414, 25);
      buttonThin.setText("Redraw (Thin)");

      drawingCanvas = new Canvas(widgetComp, SWT.NONE);
      drawingCanvas.setBounds(10, 68, 414, 183);
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