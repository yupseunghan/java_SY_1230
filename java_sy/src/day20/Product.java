package day20;

import java.text.DecimalFormat;
import java.util.Objects;

import lombok.Data;

@Data
public class Product {
	private String code,name,option,codePrefix;
	Category category;
	private int amount,price;
	public Product(String code, String name, String option, Category category, int price) {
		this.code = code;
		this.name = name;
		this.option = option;
		this.category = category;
		this.price = price;
	}
	public Product(int max,String name, String option, Category category, int price) {
		this("",name,option,category,price);
		String prefix = Product.getCodePrefix(category.name());
		DecimalFormat format = new DecimalFormat("000");
		String suffix = format.format(max+1);
		this.code=prefix+suffix;
	}
	@Override
	public String toString() {
		return "["+category+"] "+name+" "+option+" - "+code+" : "+price+"원 수량: "+amount;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(code, other.code);
	}
	public static String getCodePrefix(String category) {
		switch(category) {
		case "문구":
			return"ABC";
		case "의류":
			return"DEF";
		case "식품":
			return"XYZ";
		case "가전":
			return"ELC";
		case "기타":
			return"ETC";
		default:
			return"다시 입력";
		}
	}
	public void update(String name, String option, int price) {
		this.name=name;
		this.option=option;
		this.price=price;
	}
	public void amount(int store) {
		this.amount+=store;
	}
}
