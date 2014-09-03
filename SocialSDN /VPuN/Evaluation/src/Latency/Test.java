package Latency;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Test {

	
public static void main(String args[]){
	
	
	BufferedReader br = null;
	ArrayList<PingResult> list = new ArrayList<PingResult>();
	try {

		String sCurrentLine;

		br = new BufferedReader(new FileReader(
				"src/resources/R2"));
		br.readLine(); //SKIP line number 1 as it is just a header
		
		while ((sCurrentLine = br.readLine()) != null) {
			 
			 try{
			 String tempArray[]= sCurrentLine.split("time=");
			 String values[] = tempArray[1].split(" ");
			 PingResult res = new PingResult();
			 res.setResponseTime(Double.parseDouble(values[0]));
			 list.add(res);
			 } catch(ArrayIndexOutOfBoundsException e){
				 break;
			 }
			 
		}

	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		try {
			if (br != null)
				br.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
     EstimatedRTT rtt = new EstimatedRTT();
     String finalResult = "[";
	for(PingResult r: list){
		
		finalResult= finalResult+rtt.estimate(r.getResponseTime())+",";
	}
	finalResult = finalResult +"0]";
	System.out.println(finalResult);
}
}
