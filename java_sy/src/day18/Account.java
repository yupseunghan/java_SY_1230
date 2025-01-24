package day18;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Data;
@Data
public class Account implements Serializable{
	private static final long serialVersionUID = 1L;
	private Bank bank;
	private String num,name,pw;
	private int money;
	List<Item> list;//입출금 내역
	public Account(Bank bank, String num, String name, String pw) {
		this.bank = bank;
		this.num = num;
		this.name = name;
		this.pw = pw;
		list = new ArrayList<>();
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
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
}
