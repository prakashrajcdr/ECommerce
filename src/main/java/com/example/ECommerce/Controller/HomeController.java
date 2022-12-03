package com.example.ECommerce.Controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ECommerce.Entity.Products;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class HomeController {
	@Autowired
	JdbcTemplate jdbc;


	@RequestMapping(value="/addProduct",consumes = "application/json", produces = "application/json")
	@ResponseBody
	public String addProduct(@RequestBody Products prod){
		
		
		String query = "";
		int key = 0;

		query = "insert into products set in_or_out_product=? , consumer_cat=? ,"
				+ "product_cat=?, gender=?, sample_cost=?, remarks=?,"
				+ "physical_ref_avail=?, product_img_url=?, status='active', created_on=now(), modified_on=now()"; 
		key = jdbc.update(query, new Object[]{prod.getInOrOutProduct(),prod.getConsumerCat(),prod.getProductCat(), prod.getGender(), prod.getSampleCost(), prod.getRemarks(), prod.getPhysicalRefAvail(), prod.getProductImgUrl()});

		String msg = "{ 'status' : "+key+", 'msg' : "+(key>0 ? "'successfully inserted!'" : "'server busy!'")+"}";

		return  msg;
	}
	
	@RequestMapping(value="/editProduct",consumes = "application/json", produces = "application/json")
	@ResponseBody
	public String editProduct(@RequestBody Products prod){
		
		
		String query = "";
		int key = 0;

		query = "update products set in_or_out_product=? , consumer_cat=? ,"
				+ "product_cat=?, gender=?, sample_cost=?, remarks=?,"
				+ "physical_ref_avail=?, product_img_url=?, modified_on=now() where prod_id=?"; 
		key = jdbc.update(query, new Object[]{prod.getInOrOutProduct(),prod.getConsumerCat(),prod.getProductCat(), prod.getGender(), prod.getSampleCost(), prod.getRemarks(), prod.getPhysicalRefAvail(), prod.getProductImgUrl(), prod.getProdId()});
		System.out.println(query);
		System.out.println(prod.getProductImgUrl());
		
		String msg = "{ 'status' : "+key+", 'msg' : "+(key>0 ? "'successfully upodated!'" : "'server busy!'")+"}";

		
		return  msg;
	}

}