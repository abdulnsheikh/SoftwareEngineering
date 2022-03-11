import homework.ComponentApp;
import homework.DataApp;
import homework.ServiceApp;

public class Program { 
	
	public static void main(String[] args) {
		
		ServiceApp ServiceApp = new ServiceApp("SRC");
		DataApp DataApp = new DataApp("DATA");
		ComponentApp ComponentApp = new ComponentApp("COM");
		
		String comName = ComponentApp.getName(); 
		System.out.println("\tCOM NAME: " + comName);
		
		String dataName = DataApp.getName();
		System.out.println("\tDATA NAME: " + dataName);
		
		String srcName = ServiceApp.getName();
		System.out.println("\tSRC NAME: " + srcName);
		

	}

}
