package homework;
import java.text.DateFormat.Field;

public aspect TraceAspectSheikh {
	  pointcut classToTrace(): within(*App);
	   pointcut methodToTrace():  classToTrace() &&  execution(String getName());

	   before(): methodToTrace() {
		   System.out.print("[BGN]");
	      String info = thisJoinPointStaticPart.getSignature() + ", " // 
	            + thisJoinPointStaticPart.getSourceLocation().getLine();
	      System.out.println("\t-->" + info);
	   }

	   after(): methodToTrace() {
		   System.out.print("[END]");
	      System.out.println("\t<--" + thisJoinPointStaticPart.getSourceLocation().getFileName());
	   }
}
