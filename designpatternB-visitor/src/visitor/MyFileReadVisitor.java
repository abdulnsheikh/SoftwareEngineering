package visitor;

import java.io.File;
import java.util.List;

import part.Body;
import part.Engine;
import part.Wheel;
import util.UtilFile;

public class MyFileReadVisitor extends CartPartVisitor {

   private String filePath = System.getProperty("user.dir");
   private List<String> contents;

   public MyFileReadVisitor() {
      contents = UtilFile.readFile(filePath + File.separator + "inputdata.txt");
   }

   @Override
   public void visit(Wheel part) {
      final int LINE_NUM_WHEEL = 0;
      String[] tokens = contents.get(LINE_NUM_WHEEL).split(",");
      part.setName(tokens[0].trim());
      part.setModelNumberWheel(tokens[1].trim());
      part.setModelYearWheel(tokens[2].trim());
   }

   @Override
   public void visit(Engine part) {
      final int LINE_NUM_ENGINE = 0;
      String[] tokens = contents.get(LINE_NUM_ENGINE).split(",");
      part.setName(tokens[0].trim());
      part.setModelNumberEngine(tokens[1].trim());
      part.setModelYearEngine(tokens[2].trim());
   }

   @Override
   public void visit(Body part) {
      final int LINE_NUM_BODY = 2;
      String[] tokens = contents.get(LINE_NUM_BODY).split(",");
      part.setName(tokens[0].trim());
      part.setModelNumberBody(tokens[1].trim());
      part.setModelYearBody(tokens[2].trim());
   }
}
