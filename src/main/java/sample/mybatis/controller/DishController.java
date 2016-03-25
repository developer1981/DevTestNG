package sample.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONArray;
import sample.mybatis.common.Config;
import sample.mybatis.common.Result;
import sample.mybatis.domain.Dish;
import sample.mybatis.mapper.DishMapper;

@RestController
@RequestMapping("/api/dish")
public class DishController {
	
	@Autowired
	DishMapper dishMapper;
	
	@RequestMapping(value="/queryDishByVendorId")
	public Result queryDishByVendorId(@RequestParam("vid") String vid){
		
		List<Dish> dishes = dishMapper.selectByVendorId(Integer.parseInt(vid));
		
		Result result = new Result();
		result.setCode(Config.SUCCESS_CODE);
		
		JSONArray jsonDishes = JSONArray.fromObject(dishes);  
		result.setMsg(jsonDishes.toString());
		
		return result;
		
	}
}
