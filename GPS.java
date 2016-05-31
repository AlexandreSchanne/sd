package senCity;

public class GPS {

	double longitude;
	double latitude;
	
	public GPS(double longitude, double latitude){
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public double getLongitude(){
		return this.longitude;
	}
	
	public double getLatitude(){
		return this.latitude;
	}
	
	public void setLongitude(double longitude){
		this.longitude = longitude;
	}
	
	public void setLatitude(double latitude){
		this.latitude=latitude;
	}
	
	public String toString(){
		return ("latitude : "+latitude+" et longitude : "+longitude);
	}
}
