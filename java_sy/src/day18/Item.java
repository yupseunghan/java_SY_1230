package day18;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Item implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Date date;//입출금 날짜
	private Type type; //입금 또는 출금
	private long money; //금액
	
	public Item(Type type,long money) {
		this.type=type;
		this.money=money;
		this.date=new Date();
	}
}
