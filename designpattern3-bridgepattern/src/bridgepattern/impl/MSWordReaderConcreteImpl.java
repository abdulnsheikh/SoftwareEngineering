package bridgepattern.impl;

import java.io.FileInputStream;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;

// Concrete Implementor
public class MSWordReaderConcreteImpl extends DocumentReaderImplementor {
   public void readFile(String fileName) {
      init();
      Text t = new Text(shell, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
      t.setText("Reading MSWord file: " + readMSWordContents(fileName));
      t.setFont(new Font(display, new FontData("Arial", 24, SWT.BOLD)));
      t.setLayoutData(new GridData(GridData.FILL_BOTH));
      openShell();
   }

   public String readMSWordContents(String fileName) {
      FileInputStream fis = null;
      String result = null;
      try {
         fis = new FileInputStream(fileName);
         XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
         XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
         result = extractor.getText();
         extractor.close();
      } catch (Exception ex) {
         ex.printStackTrace();
      }
      return result;
   }
}