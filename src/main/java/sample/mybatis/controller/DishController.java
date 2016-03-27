package sample.mybatis.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sample.mybatis.common.Config;
import sample.mybatis.common.Response;
import sample.mybatis.domain.Dish;
import sample.mybatis.mapper.DishMapper;

@RestController
@RequestMapping("/api/dish")
public class DishController {
	
	@Autowired
	DishMapper dishMapper;
	
	@RequestMapping(value="/queryDishByVendorId", method = RequestMethod.GET)
	public Response queryDishByVendorId(@RequestParam("vid") String vid){
		
		Response resp = new Response();
		List<Dish> dishes = dishMapper.selectByVendorId(Integer.parseInt(vid));		
		
		
		resp.setMessage("OK!");
		resp.setRespData(dishes);
		resp.setStatusCode(Config.SUCCESS_CODE);

		
		return  resp;
		
	}
}
