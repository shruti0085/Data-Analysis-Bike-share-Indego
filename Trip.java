import java.util.Calendar;
/**
 * Trip represents a trip taken from the Indego dataset 
 * @author Dell1
 *
 */
public class Trip {
	private int tripId;
	private int duration;
	private String startTime;
	private String endTime;
	private int startStat;
	private double startLat;
	private double startLong;
	private int endStat;
	private double endLat;
    private double endLong;
    private int bikeId;
    private int planDur;
    private String tripRoute;
    private String passHolderType;
    private Calendar calStart;
    private Calendar calEnd;
/**
 * Creates a constructor of Trip class
 * @param startStat: start station name for the trip
 * @param passHolderType: passHolder Type
 * @param duration: duration of the trip
 * @param calStart: starting date and time represented as Calendar object
 * @param calEnd: end date and time of trip represented as Calendar object
 * @param startTime: start time of trip
 * @param endTime: end time of trip
 * @param tripRoute: trip route
 * @param endStat: end station of trip
 * @param startLat: starting latitude for trip
 * @param startLong: starting longitude of trip
 * @param endLat: ending latitude of trip
 * @param endLong: ending longitude of trip
 */

Trip(int startStat,String passHolderType, int duration, Calendar calStart, 
		Calendar calEnd, String startTime, String endTime, String tripRoute, int endStat, double startLat, double startLong, double endLat, double endLong){
	this.startStat = startStat;
	this.passHolderType = passHolderType;
	this.duration = duration;
	this.startTime = startTime;
	this.endTime = endTime;
	this.calStart = calStart;
	this.calEnd = calEnd;
	this.tripRoute = tripRoute;
	this.endStat = endStat;
	this.startLat = startLat;
	this.startLong = startLong;
	this.endLat = endLat;
	this.endLong = endLong;
	
}
/**
 * Method to get starting latitude of trip
 * @return startLat: starting latitude
 */
public double getStartLat() {
	return startLat;
}
/**
 * Method to set starting latitude of trip
 * @param startLat: starting latitude
 */
public void setStartLat(double startLat) {
	this.startLat = startLat;
}
/**
 * Method to get starting longitude
 * @return startLong: starting longitude
 */
public double getStartLong() {
	return startLong;
}
/**
 * Method to set start longitude of trip
 * @param startLong: starting longitude
 */
public void setStartLong(double startLong) {
	this.startLong = startLong;
}
/**
 * Method to get ending latitude of trip
 * @return endLat: ending latitude
 */
public double getEndLat() {
	return endLat;
}
/**
 * Method to set ending latitude of trip
 * @param endLat: ending latitude
 */
public void setEndLat(double endLat) {
	this.endLat = endLat;
}
/**
 * Method to get ending longitude
 * @return endLong: ending longitude
 */
public double getEndLong() {
	return endLong;
}
/**
 * Method to set ending longitude
 * @param endLong: ending longitude
 */
public void setEndLong(double endLong) {
	this.endLong = endLong;
}
/**
 * Method to get end station id
 * @return endStat: end station id
 */
public int getEndStat() {
	return endStat;
}
/**
 * Method to set end station
 * @param endStat: end station id
 */
public void setEndStat(int endStat) {
	this.endStat = endStat;
}
/**
 * Method to get trip route
 * @return tripRoute: trip route
 */
public String getTripRoute() {
	return tripRoute;
}
/**
 * Method to set trip route
 * @param tripRoute
 */
public void setTripRoute(String tripRoute) {
	this.tripRoute = tripRoute;
}
/**
 * Method to get Calendar representation of start time
 * @return calStart: start time as Calendar representation
 */
public Calendar getCalStart() {
	return calStart;
}
/**
 * Method to set Calendar representation of start time
 * @param calStart: start time as Calendar representation
 */
public void setCalStart(Calendar calStart) {
	this.calStart = calStart;
}
/**
 * Method to get Calendar representation of end time
 * @return  calEnd: end time as Calendar representation
 */
public Calendar getCalEnd() {
	return calEnd;
}
/**
 * Method to set Calendar representation of end time
 * @param calEnd:end time as Calendar representation
 */
public void setCalEnd(Calendar calEnd) {
	this.calEnd = calEnd;
}
/**
 * Method to get duration of trip
 * @return duration
 */
public int getDuration() {
	return duration;
}
/**
 * Method to set duration
 * @param duration
 */
public void setDuration(int duration) {
	this.duration = duration;
}
/**
 * Method to get start time of trip
 * @return startTime: start time
 */
public String getStartTime() {
	return startTime;
}
/**
 * Method to set start time
 * @param startTime
 */
public void setStartTime(String startTime) {
	this.startTime = startTime;
}
/**
 * Method to get end time of trip
 * @return endTime: end time
 */
public String getEndTime() {
	return endTime;
}
/**
 * Method to set end Time
 * @param endTime
 */
public void setEndTime(String endTime) {
	this.endTime = endTime;
}
/**
 * Method to get start station id
 * @return startStat: start station Id of trip
 */
public int getStartStat() {
	return startStat;
}
/**
 * Method to set start station id of trip
 * @param startStat: start station id
 */
public void setStartStat(int startStat) {
	this.startStat = startStat;
}
/**
 * 	Method to get passHolderType of a trip
 * @return passHolderType: pass holder type
 */
public String getPassHolderType() {
	return passHolderType;
}
/**
 * Method to set passHolderType of a trip
 * @param passHolderType
 */
public void setPassHolderType(String passHolderType) {
	this.passHolderType = passHolderType;
}
	
}


