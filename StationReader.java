import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
/**
 * StationReader reads in and parses the station File to create station objects
 * @author shruti
 *
 */
public class StationReader {
	File fileName;
	/**
	 * Creates a constructor for StationReader
	 * @param fileName: the file to be read in
	 */
	
	public StationReader(String fileName){
		this.fileName = new File(fileName);
    
	}
/**
 * creates an ArrayList of Station objects after reading in the Station File	
 * @return ArrayList of station objects
 * @throws ParseException
 */
	public ArrayList<Station> readStationFile() throws ParseException{
    	ArrayList<Station> stations = new ArrayList<>();
    	try  {
    		Scanner scan = new Scanner(this.fileName);
    		//use , and \n (new line) as delimiters
    		//delimiter is the character used to 
    		//separate data in a filescan.useDelimiter(",|\n|\r");
    		//read in first line with column headers
    		  
    		scan.useDelimiter(",|\n|\r");
    		scan.nextLine();
    		while (scan.hasNext()) {   
    			String line = scan.nextLine();          
    			String[] pieces = line.split(",");     
    			int stationId = Integer.parseInt(pieces[0]);          
    			String sNameCheck = pieces[1];

    			String stationName;
    			String liveDate;
    			String statusActive;
    			
    			//checks if station name has ", if yes parse it using substring to get actual name
    			//else get station name , live date and statusActive without modifying the string
    			if((sNameCheck.charAt(0)) == '\"'){
    				 String stationNameCheck = pieces[1] +","+ pieces[2];
    				 stationName = stationNameCheck.substring(1, stationNameCheck.length()-1);
    			     liveDate = pieces[3];
    			     statusActive = pieces[4];
    			}
    			else {
    				stationName = sNameCheck;
    				liveDate = pieces[2];
    				statusActive = pieces[3];
    			}
    			
    			//Read the date using SDF , Date class and finally
    			//create a Calendar object to represent the date
    		    
    		    SimpleDateFormat sdfStation = new SimpleDateFormat("MM/dd/yyyy");
                Date dStat = sdfStation.parse(liveDate);  
                Calendar calLive = Calendar.getInstance();
                calLive.setTime(dStat);
               
                
    		    //gets status of station
    		    boolean status;
    		    if(statusActive.equals("Active")) {
    		    	status = true;
    		    }else {
    		    	status = false;
    		    }
    		    //creates a station object
    		    Station s = new Station(stationId, stationName, liveDate, calLive ,status);
                stations.add(s);
                
    		
    		 }   
        	scan.close(); 
            } 
           catch(IOException e)
        {  
        	e.printStackTrace();
        }
        return stations;
        }
    }


