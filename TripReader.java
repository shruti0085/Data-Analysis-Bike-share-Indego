
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
/**
 * 
 * @author shruti
 * TripReader reads in and parses trip file to create trip objects
 *
 */
public class TripReader {
	File fileName;
/**
 * Creates a constructor of TripReader which reads in file	
 * @param fileName: file to be read in
 */
	public TripReader(String fileName){
		this.fileName = new File(fileName);
    
	}
/**
 * Method to create ArrayList of Trip objects by reading in the file
 * @return ArrayList of Trip objects
 * @throws ParseException
 */
	public ArrayList<Trip> readTripFile() throws ParseException{
    	ArrayList<Trip> tripsx = new ArrayList<>();
    	try  {
    		Scanner scan = new Scanner(this.fileName);//use , and \n (new line) as delimiters
    		//delimiter is the character used to 
    		//separate data in a filescan.useDelimiter(",|\n|\r");
    		//read in first line with column headers
    		  
    		scan.useDelimiter(",|\n|\r");
    		scan.nextLine();
    		while (scan.hasNext()) {   
    			String line = scan.nextLine();           
    			String[] pieces = line.split(",");     
    			int duration = Integer.parseInt(pieces[1]);    
    			
    			//Read in start time   
    			
    			//station name has double quotes around it,
    			// to remove it use substring
    			String startTime= pieces[2].substring(1, pieces[2].length()-1); 
    			//split start time into date and time  using "\\s+", which splits on whitespace
    			//and further into separate  time and date parts using delimiter":" and"-"
    			
    			String[] dateParts = startTime.split("\\s+");
    			String[] startTimeSplit  = dateParts[1].split(":");
    			String[] startDateSplit = dateParts[0].split("-");
 			
                int monthStart = Integer.parseInt(startDateSplit[1]);
                int yearStart = Integer.parseInt(startDateSplit[0]);
                int dayStart = Integer.parseInt(startDateSplit[2]);
                int hourStart = Integer.parseInt(startTimeSplit[0]); 
                int minStart = Integer.parseInt(startTimeSplit[1]); 
                int secStart = Integer.parseInt(startTimeSplit[2]);   
    		
                Calendar calStart = Calendar.getInstance();
                calStart.set(yearStart, monthStart, dayStart, hourStart, minStart, secStart);

         
                String endTime = pieces[3].substring(1, pieces[3].length()-1);
               
    			String[] endParts= endTime.split("\\s+");
    			String[] endDateSplit = endParts[0].split("-");
    			String[] endTimeSplit  = endParts[1].split(":");
                int hourEnd = Integer.parseInt(endTimeSplit[0]); 
                int minEnd = Integer.parseInt(endTimeSplit[1]); 
                int secEnd = Integer.parseInt(endTimeSplit[2]);
                
                int monthEnd = Integer.parseInt(endDateSplit[1]);
                int yearEnd = Integer.parseInt(endDateSplit[0]);
                int dayEnd = Integer.parseInt(endDateSplit[2]);

                Calendar calEnd = Calendar.getInstance();

                calEnd.set(yearEnd, monthEnd, dayEnd, hourEnd, minEnd, secEnd);

                
                int startStat = Integer.parseInt(pieces[4]);
                int endStat = Integer.parseInt(pieces[7]);
                String tripRoute = pieces[12].substring(1, pieces[12].length()-1);
                String passHolderType = pieces[13].substring(1, pieces[13].length()-1);
    
                // checks if start/end Latitude/Longitude have missing values,thus are an empty string
                // if yes, then replace them with 0.0
                double startLat = 0.0;
                double startLong = 0.0;
                double endLat = 0.0;
                double endLong = 0.0;
                if((pieces[5].charAt(0))== '\"') {
                	startLat = 0.0;			                	
                }
                else {
                	startLat = Double.parseDouble(pieces[5]);
                }
                if((pieces[6].charAt(0))== '\"') {
                	startLong = 0;			                	
                }
                else {
                	startLong = Double.parseDouble(pieces[6]);
                }
                
                
                if((pieces[8].charAt(0))== '\"') {
                	endLat = 0;			                	
                }
                else {
                	endLat = Double.parseDouble(pieces[8]);
                }
                
                if((pieces[9].charAt(0))== '\"') {
                	endLong = 0;			                	
                }
                else {
                	endLong = Double.parseDouble(pieces[9]);
                }
                
                // create trip objects
                Trip t = new Trip(startStat, passHolderType,
                		duration, calStart, calEnd ,startTime, endTime,
                		tripRoute, endStat, startLat, startLong, endLat, endLong);

                tripsx.add(t);
        }   
    	scan.close(); 
        } 
       catch(IOException e)
    {  
    	e.printStackTrace();
    }
    return tripsx;
    }
}

