package kr.kh.spring.model.vo;

import java.util.Date;

import lombok.Data;

@Data
public class PostVo {
	int po_num;
	String po_title,po_content,po_me_id;
	Date po_date;
	int po_view;
	int po_up,po_down;
	String po_del;
	@Override
	public String toString() {
		return po_num+" "+po_title+" "+po_content+" "+po_date+" "+po_view;
	}
	
}
