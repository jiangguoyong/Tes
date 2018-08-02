package com.jt.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.sql.dialect.postgresql.ast.stmt.PGSelectQueryBlock.ForClause;
import com.jt.common.vo.SysResult;
import com.jt.manage.pojo.ItemDesc;
import com.jt.manage.service.ItemDescService;

@Controller
public class ItemDescController {
	// 查询商品详情
	@Autowired
	private ItemDescService itemDescService;
	@RequestMapping("item/query/item/desc/{itemId}")
	@ResponseBody
	public SysResult findItemDescById(@PathVariable Long itemId) {
		//利用注入的service将商品详情查询返回
		//成功与否的返回，可以利用异常，利用返回的int
		try {
			ItemDesc itemDesc=itemDescService.findItemDescById(itemId);
			return SysResult.oK(itemDesc);
		} catch (Exception e) {
			return SysResult.build(201, e.getMessage());
		}
		
	}
		
 
}
