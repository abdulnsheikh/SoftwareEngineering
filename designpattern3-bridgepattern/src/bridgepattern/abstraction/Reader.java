package bridgepattern.abstraction;

import bridgepattern.impl.DocumentReaderImplementor;

public abstract class Reader {
   DocumentReaderImplementor documentReaderImpl;
   
   public Reader(DocumentReaderImplementor reader) {
      this.documentReaderImpl = reader;
   }
   
   public abstract void read(String fileName);
}