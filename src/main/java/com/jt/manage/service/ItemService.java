package com.jt.manage.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jt.common.vo.EasyUIResult;
import com.jt.manage.mapper.ItemDescMapper;
import com.jt.manage.mapper.ItemMapper;
import com.jt.manage.pojo.Item;
import com.jt.manage.pojo.ItemDesc;

@Service
public class ItemService {
	@Autowired
	private ItemMapper itemMapper;
	public EasyUIResult findItemList(Integer page,Integer rows) {
		//引入分页插件PageHelper
		PageHelper.startPage(page,rows);//开启查询select拦截
		//经过了拦截拼接的查询结果,是一个Page对象,page继承了List
		List<Item> itemList = itemMapper.selectAll();//select * from tb_item limit (page-1)*rows ,rows
		List<Item> itemList1 = itemMapper.selectAll();
		//从page对象中获取数据
		PageInfo<Item> pageInfo=new PageInfo<Item>(itemList);
		//利用pageInfo将page对象中封装的数据,
		//总数据条数count,和分页结果
		EasyUIResult result=new EasyUIResult();
		
		result.setTotal((int)pageInfo.getTotal());//获取count
		result.setRows(pageInfo.getList());
		return result;
	}
	@Autowired
	private ItemDescMapper itemDescMapper;
	public void saveItem(Item item, String desc) {
		//desc数据属于另外一张表格,itemMapper没有操作可能性
		//插入商品
		//status 状态,1
		//created创建时间没穿,updated new Date()
		item.setStatus(1);
		item.setCreated(new Date());
		item.setUpdated(item.getCreated());
		itemMapper.insert(item);
		
		//详情 对象封装数据
		ItemDesc itemDesc=new ItemDesc();
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(item.getCreated());
		itemDesc.setUpdated(item.getCreated());
		//持久层框架,在执行insert后,select last_insert_id() 将id封装
		//到item;
		itemDesc.setItemId(item.getId());
		itemDescMapper.insert(itemDesc);
	}
	
}
