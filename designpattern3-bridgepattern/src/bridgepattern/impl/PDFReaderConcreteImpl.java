package bridgepattern.impl;

import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;

// Concrete Implementor
public class PDFReaderConcreteImpl extends DocumentReaderImplementor {
   public void readFile(String fileName) {
      init();
      Text t = new Text(shell, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
      t.setText("Reading PDF file: " + readPDFContents(fileName));
      t.setFont(new Font(display, new FontData("Arial", 24, SWT.BOLD)));
      t.setLayoutData(new GridData(GridData.FILL_BOTH));
      openShell();
   }


   public String readPDFContents(String fileName) {
      File file = new File(fileName);
      String result = null;

      try (PDDocument document = PDDocument.load(file)) {
         document.getClass();
         if (!document.isEncrypted()) {
            PDFTextStripperByArea stripper = new PDFTextStripperByArea();
            stripper.setSortByPosition(true);
            PDFTextStripper tStripper = new PDFTextStripper();
            result = tStripper.getText(document);
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      return result;
   }
}