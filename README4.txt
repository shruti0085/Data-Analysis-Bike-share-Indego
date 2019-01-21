To implement data analysis of Indego station and trip data, 9 classes are created. The CRC consists of the following:
Trip Class: to represent every trip with its associated instance variables.
Station Class: to represent every station with its associated instance variables
Trip Reader: to read in and parse the trip file to create Arraylist of trip objects using readTripFile () with handling for Parse exception.
Station Reader: to read and parse the station file to create ArrayList of station objects.
DataAnalysisStation: to analyse station data using StationReader class's method readStationFile() which returns an arraylist
of station objects. Various methods are created to draw conclusions from station data.
DataAnalysisStationTrip: analyses both station and trip data to draw conclusions using methods and their reader files.
It also creates an ArrayList of objects of NewReportData using getStationReport()  to be printed out into another file later on.
NewReportData: represents objects using data from Station and Trip class to be printed out to the file.
BikeReportPrinter: prints the NewReportData to a file.
Checker: tests and implements all our classes and their associated methods.

Trip Class:
Trip class has the following private instance variables associated with it:
private int tripId: tripId
private int duration: duration of trip
private String startTime: startTime of trip
private String endTime: end time of trip
private int startStat: start station id
private double startLat: start latitude of trip
private double startLong: start longitude of trip
private int endStat: end station of trip
private double endLat: end latitude of trip
private double endLong: end longitude of trip
private int bikeId: bike id
private int planDur: plan duration
private String tripRoute: route of trip
private String passHolderType: type of pass used for trip
private Calendar calStart: representation of start time using Calendar class
private Calendar calEnd: representation of end time using Calendar class
getters and setters for all these variables are created.

Station Class
private int stationId: stationID
private String stationName : name of the station
private String liveDate : Go live Date of the station
private Calendar calLive : representation of Date using Calendar class
private boolean status : status -Active/Inactive of station
getters and setters for each are created

TripReader and StationReader
Both these classes reads in a file, in this case trip file and station file, parses it and creates ArrayList
of Trip and Station objects respectively.
The file is parsed line by line using scanner class and then splitted on comma as delimiter:


TripReader
a)Since the original start and end time are in double quotes, all double quotes for any data is removed by using substring.
b)The startTime and endTime are further split on"\\s+"- to account for whitespace between time and date.
c)"-" and ":" are used for splitting date and time respectively.The combined time is then set using Calendar class.
  The same is followed to get endTime and its representation in Calendar class.
d)parseInt and parseDouble are used to parse integer and double values respectively.
e)To account for missing values in latitude and longititude fields, we check if they have empty strings("") using charAt(0) == "/""
 and if yes,assign them values of 0.0.
f)The trip objects are then created after parsing and added to an ArrayList of Trip objects.
  IO exception is handled using a try catch block.

StationReader
a)The same above method is followed to read and parse the file and further create station objects.
b)To account for 2 name stations, falsely split using comma as delimiter:
   An if-else loop is used which checks if there are double quotes at the first position in the stationName string using charAt,same as shown in TripReader.
c)If yes, then quotes are removed, if not then they remain the same.
d)The liveDate is represented using SimpleDateFormat and Calendar class.
e)Status is represented as a boolean variable, if the status of the station is active,then true else false.
f)Each station object is then added to an ArrayList.

NewReportData
Represents objects to be printed out as defined in the instruction pdf.
It consists of the following instance variables:
private int statId:station ID
private String statName:station name
private int totalTrips:total trips originated from that station
private double avgDur:average duration of trips taken from that station
private double maxDur:maximum duration of trip taken from that station
private int oneWayTrips: number of one way trips taken from that station
private int diffStartEnd:difference between no of trips that started and that ended at the station
getters and setters are created for each

DataAnalysisStation
Analyses only station data.It has instance variable of:
ArrayList<Station> stationData: arraylist of station objects read in from the station file
Methods:
numOfActiveOrInactiveStations(String status): returns the number of active /inactive stations in Q2 of 2018.
We check the status of all stations from station data and keeps a count of those that are Active/Inactive.String status specifies the status-Active/Inactive.
getActiveInYear(int year, String status): returns the no of active/inactive stations with go live date in given year passed as parameter.
We check the stations that has a go live date in the year by getting their startYear using Calendar class and then check if their status is Active
to get the total no of active/inactive stations.

DataAnalysisStationTrip: analyses station and trip data read to draw conclusions. It also creates objects to be printed out to report.
It has instance variables:
ArrayList<Station> stationData: list of station objects
ArrayList<Trip> tripData: list of trip objects
ArrayList<NewReportData> reportData: list of NewReportData objects

Methods:
getTripsFromStation(String statName): returns the number of trips from given station, specified by station name parameter passed as String variable.
We first iterate through the station data, to procure station name, and check if it matches the parameter.
Then we iterate through trip data to get no. of trips from that station by checking the station id for given station name.

getPopularStartStation(): returns the name of the most popular station, which has maximum trips originating from it.
We use two enhanced for loops, first through station data, to get current station id and compare it with start stations of trips while using another for loop. 
if they match we increment the count of number of trips.
We then check for the given station, if tripCount>maxCount, if yes, we update maxCount and assign popStatName with the current station name,else loop again 
and after entire loop of stations, return the most popular station.

getMostPassTypeMonth(String passType): returns the Month in which maximum trips with the passType specified by the parameter are made.
We first create an ArrayList of Integers which consists of all month numbers in which the specified passHolderType trip is made.
We then get the month with the most occurences of the passType and return that Month using Month class to convert the integer value into equivalent month.

getAverageDuration(): returns the average duration of bike rental.
It sum all the durations for all trips and divides it by the total no of trips to get the average duration of bike rental.

getTripsBetweenSlots(int start, int end): returns the number of trips between specified time slots,start and end as specified by the parameter.
We only look at the hour in this case and only for rides taken in the same day and same month.
The code is designed to follow 24 Hr format.

getStationReportData(): returns an ArrayList of NewReportData objects by using trip and station data.
station data is used to get station name and station id, we loop through trips to get total no of trips from the station
and calculate the total duration of trips taken from that station, we divide the two to get average duration.
Similarly we get other instance variables associated with NewReportData object.


BikeReportPrinter
It has instance variable DataAnalysisStationTrip dStat.
createBikeReport(String fileName): writes to the fileName passed as parameter.
It uses the getStationReport() method of DataAnalysisStationTrip to create an arrayList of NewReportData objects and 
write them to the file using PrintWriter.

Checker:
It is the main method where all our class objects and methods are tested and implemented.
We create objects of StationReader, TripReader, DataAnalysisStationTrip, DataAnalysisStation and BikeReportPrinter.
We then test their method to answer the question asked.
The following results are obtained:

1.The no of active stations inQ2 2018:130
We use numOfActiveorInactiveStations("Active") method of DataAnalysisStation object to get the no of active stations.

2.The no stations that are still active:19
We use getActiveInYear(2017, "Active") method of DataAnalysisStation object to get the no of station with go live date 2017 that are still active.

3.The no of trips from amtrak:3245
We use the getTripsFromStation("Amtrak 30th Street Station")of DataAnalysisStationTrip object, with the following string passed as station name, to get the trips.

4.The most popular months for walkup:APRIL
We use the getMostPassTypeMonth("Walk-up"), with Walk-up passed as the passHolderType for which we want to get the most popular month
We use this method of DataAnalysisStationTrip object.

5.The average duration of rental:21.75488037138436
We use averageDuration() method of DataAnalysisStationTrip object.

6.The no of trips between 10 and 1pm:24300
We use getTripsbetweenSlot(10,13) of DataAnalysisStationTrip object with the start time as 10 and end time as 13i.e 1pm

7.Wildcard:The most popular station is:15th & Spruce
We use getPopularStartStation() method of DataAnalysisStationTrip object to get the most popular station.


We finally print the report using the BikeReportPrinter in BikeStationReport.txt file




