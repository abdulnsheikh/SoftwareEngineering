package bridgepattern.abstraction;

import bridgepattern.impl.DocumentReaderImplementor;
import util.UtilMsg;

public class DocumentReader extends Reader {
   public DocumentReader(DocumentReaderImplementor reader) {
      super(reader);
   }

   public void read(String fileName) {
      if (this.documentReaderImpl == null) {
         UtilMsg.doShowMessageBox("Invalid File Format!!");
         return;
      }
      this.documentReaderImpl.readFile(fileName);
   }
}