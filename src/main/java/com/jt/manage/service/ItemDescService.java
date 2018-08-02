package com.jt.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.manage.mapper.ItemDescMapper;
import com.jt.manage.pojo.ItemDesc;

@Service
public class ItemDescService {
	@Autowired
	private ItemDescMapper itemDescMapper;
	public ItemDesc findItemDescById(Long itemId){
		ItemDesc itemDesc=itemDescMapper.selectByPrimaryKey(itemId);
		return itemDesc;
	}

}
