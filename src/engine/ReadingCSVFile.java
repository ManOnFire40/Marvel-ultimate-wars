package engine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class ReadingCSVFile {

	public static String readFile(String path) throws IOException{
		String x="";
		String currentLine = "";
		FileReader fileReader= new FileReader(path);
		BufferedReader br = new BufferedReader(fileReader);
		while ((currentLine = br.readLine()) != null) {
		x+=currentLine ;
		// Parsing the currentLine String
		}
	
	return x;}

	
	
	
	public static void main(String[] args) throws IOException {
		//readFile("Abilities.csv");
		//readFile("Champions.csv");
		
		
	readFile("Abilities.csv");
	 
		
	    
	    
	    
	}


}