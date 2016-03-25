package sample.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONObject;
import sample.mybatis.common.Config;
import sample.mybatis.common.Result;
import sample.mybatis.domain.Restaurant;
import sample.mybatis.mapper.RestaurantMapper;

@RestController
@RequestMapping("/api/vendor")
public class VendorController {
	
	@Autowired
	private RestaurantMapper restaurantMapper;
	
    @RequestMapping(value="/queryVendorById")
    public Result queryVendorById(@RequestParam("id") String id) {
    	
		Result result = new Result();
		result.setCode(Config.SUCCESS_CODE);
		
		Restaurant  restaurant = restaurantMapper.selectByPrimaryKey(Integer.parseInt(id));
		JSONObject json = JSONObject.fromObject(restaurant);
		result.setMsg(json.toString());
		
        return  result;
    }
}
