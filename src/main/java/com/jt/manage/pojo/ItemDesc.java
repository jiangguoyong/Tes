package com.jt.manage.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jt.common.po.BasePojo;

@Table(name="tb_item_desc")
public class ItemDesc extends BasePojo{
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long ItemId;
	private String ItemDesc;
	public Long getItemId() {
		return ItemId;
	}
	public void setItemId(Long itemId) {
		ItemId = itemId;
	}
	public String getItemDesc() {
		return ItemDesc;
	}
	public void setItemDesc(String itemDesc) {
		ItemDesc = itemDesc;
	}
	
}
