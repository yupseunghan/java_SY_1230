package day18;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Data;

@Data
public class Account implements Serializable, Cloneable{

	private static final long serialVersionUID = 1L;
	
	private Bank bank; //은행
	private String num;//계좌번호
	private String name;//이름
	private String pw;//비번
	private long money;//잔액
	
	List<Item> list;//입출금 내역

	public Account(Bank bank, String num, String name, String pw) {
		this.bank = bank;
		this.num = num;
		this.name = name;
		this.pw = pw;
		list = new ArrayList<Item>();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return bank == other.bank && Objects.equals(num, other.num);
	}

	@Override
	public int hashCode() {
		return Objects.hash(bank, num);
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public boolean deposit(long money) {
		if(money <= 0) {
			return false;
		}
		this.money += money;
		
		//입출금 내역을 추가
		Item item = new Item(Type.입금, money);
		list.add(item);
		
		return true;
	}

	public boolean withdrawal(long money) {
		if(money <= 0) {
			return false;
		}
		money -= money;
		if(this.money + money <0)
			return false;
		this.money+=money;
		//입출금 내역을 추가
		Item item = new Item(Type.출금, money);
		list.add(item);
		
		return true;
	}
}