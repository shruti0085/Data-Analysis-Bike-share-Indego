import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 * 
 * @author shruti
 * BikeReportPrinter prints the NewReportData into a file
 */
public class BikeReportPrinter {
	DataAnalysisStationTrip dStat;
/**
 * Creates a constructor of BikeReportPrinter that has a DataAnalysisStationTrip object as instance variable
 * @param dStat: DataAnalysisStationTrip object
 */
	public BikeReportPrinter(DataAnalysisStationTrip dStat){
		this.dStat = dStat;
	}
/**
 * Prints the report into the file	
 * @param fileName
 * @throws FileNotFoundException
 */
	public void createBikeReport(String fileName) throws FileNotFoundException{
		PrintWriter out = new PrintWriter(fileName);
		//Creates an ArrayList of NewReportData using getStationReport method of DataAnalysisStationTrip object
		ArrayList<NewReportData> bikeStat = dStat.getStationReport();
		try {
			for(NewReportData nbs: bikeStat) {
				// format the average duration double value to get up to 2 decimal places
				String strD = String.format("%.2f", nbs.getAvgDur());
				out.print(nbs.getStatId()+","+nbs.getStatName()+","+nbs.getTotalTrips()+ ","+strD +","+ nbs.getMaxDur()+","+ nbs.getOneWayTrips()+","+ nbs.getDiffStartEnd());
				out.println();
				}
			} 
		finally {
			out.close();
			}
		}
	
	
	}


