package sample.mybatis.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sample.mybatis.common.Result;
import sample.mybatis.domain.Customer;
import sample.mybatis.mapper.CustomerMapper;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired
	CustomerMapper customerMapper;
	
	
	
    @RequestMapping(value="/register")	
	public Result register(@RequestParam("name") String name, @RequestParam("password")String password,
			@RequestParam("tel") String tel, @RequestParam("address") String address, @RequestParam("email") String email){
		
		Customer customer = new Customer();
		customer.setName(name);
		customer.setCredentials(password);
		customer.setTel(tel);
		customer.setAddress(address);
		customer.setEmail(email);
		Result result = customerMapper.register(customer);
		
		return result;
		
	}
}
