package senCity;

public class Trace {

	String ts;
	String ssid;
	int signal;
	GPS g;

	public Trace(String ts, String ssid, int signal, GPS g){
		this.ts = ts;
		this.ssid = ssid;
		this.signal = signal;
		this.g = g;
	}

	public String toString(){
		String a = null;
		a=("ts : "+ts+" ssid : "+ssid+" signal : "+signal+" gps : "+g +"\n");
		return a;
	}
	
	public String getSsid(){
		return this.ssid;
	}
	
	public String getTs(){
		return this.ts;
	}
	
	public int getSignal(){
		return this.signal;
	}
	
	public GPS getGps(){
		return this.g;
	}
}
