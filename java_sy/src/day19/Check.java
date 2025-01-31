package day19;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;
@Data
public class Check {
	private Date date;
	private boolean check;
	public Check() {
		date = new Date();
	}
	public Check(String str, boolean isboolean) {
		try {
			this.date= new SimpleDateFormat("yyyy-MM-dd").parse(str);
			this.check=check;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public String getDstr() {
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	public String checked() {
		if(check)
			return "O";
		else
			return "X";
	}
}
