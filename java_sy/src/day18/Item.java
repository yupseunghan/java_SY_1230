package day18;

import java.util.Date;

import lombok.Data;

@Data 
public class Item {
	private Date date;
	private Enum Type;
	private int money;
}
