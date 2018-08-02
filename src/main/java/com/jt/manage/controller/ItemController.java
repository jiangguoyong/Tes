package com.jt.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.EasyUIResult;
import com.jt.common.vo.SysResult;
import com.jt.manage.pojo.Item;
import com.jt.manage.service.ItemService;

@Controller
public class ItemController {
	/*
	 * 查询所有，在这个基础上修改成分页查询
	 * */
	@Autowired
	private ItemService itemService;
	//item/query   ----接口文件中，请求连接：http:manage.jt.com/item/query
	@RequestMapping("item/query")
	@ResponseBody
	public EasyUIResult findItemList(Integer page,Integer rows){
		EasyUIResult itemList=itemService.findItemList(page,rows);
		return itemList;
	}
	/*
	 * 新增商品 和商品详情
	 * */
	@RequestMapping("item/save")
	@ResponseBody
	public SysResult saveItem(Item item,String desc){
		//成功插入，SysResult对象status=200
		//如果失败，SysResult对象的status=201
		try {
			itemService.saveItem(item,desc);
			//返回一个带有200成功的信心SysResult对象，利用静态方法返回对象
			return SysResult.oK();//status=200,msg="ok"
		} catch (Exception e) {
			return SysResult.build(201, e.getMessage());
		}
	}
	
}
