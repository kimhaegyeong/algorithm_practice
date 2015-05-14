package accountManage02;
import java.text.SimpleDateFormat;
import java.util.Date;


public class History {
	protected	String	statue; 
	protected	String  time;
	
	History() {}
	
	History(boolean statue) { 
		if (statue) {
			this.statue = "+";
		} else {
			this.statue = "-";
		}
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		this.time = dayTime.format(new Date(System.currentTimeMillis()));		
	}

	public String getStatue() {
		return statue;
	}

	public void setStatue(String statue) {
		this.statue = statue;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
}
