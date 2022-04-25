package bridgepattern.impl;

import util.MySWTShell;

public abstract class DocumentReaderImplementor extends MySWTShell {
   public abstract void readFile(String fileName);
}