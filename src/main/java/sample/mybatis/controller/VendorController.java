package sample.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import sample.mybatis.common.Config;
import sample.mybatis.common.Response;
import sample.mybatis.common.ServiceResult;
import sample.mybatis.domain.Restaurant;
import sample.mybatis.mapper.RestaurantMapper;

@RestController
@RequestMapping("/api/vendor")
public class VendorController {
	
	@Autowired
	private RestaurantMapper restaurantMapper;
	
    @RequestMapping(value="/queryVendorById", method = RequestMethod.GET)
    public Response queryVendorById(@RequestParam("id") String id) {
    	
		ServiceResult result = new ServiceResult();
		result.setCode(Config.SUCCESS_CODE);
		
		Restaurant  restaurant = restaurantMapper.selectByPrimaryKey(Integer.parseInt(id));

		Response resp = new Response();
		
		resp.setMessage("OK!");
		resp.setStatusCode(Config.SUCCESS_CODE);
		
		resp.setRespData(restaurant);
		
        return  resp;
    }
}
