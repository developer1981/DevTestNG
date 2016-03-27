package sample.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sample.mybatis.common.Encrypt;
import sample.mybatis.common.Response;
import sample.mybatis.common.ServiceResult;
import sample.mybatis.domain.Customer;
import sample.mybatis.mapper.CustomerMapper;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired
	CustomerMapper customerMapper;
	
	
	
    @RequestMapping(value="/register", method = RequestMethod.GET)	
	public Response register(@RequestParam("name") String name, @RequestParam("password")String password,
			@RequestParam("tel") String tel, @RequestParam("address") String address, @RequestParam("email") String email){
		
		Customer customer = new Customer();
		customer.setName(name);
		String enc = Encrypt.Base64Encode(Encrypt.desCrypto(password.getBytes()));
	//	System.out.println(">>>>>>>>" + new String(Encrypt.desDecrypt(Encrypt.Base64Decode(enc))));
		customer.setCredentials(enc);
		customer.setTel(tel);
		customer.setAddress(address);
		customer.setEmail(email);
		ServiceResult result = customerMapper.register(customer);
		
		Response resp = new Response();
		resp.setMessage(result.getMsg());
		resp.setStatusCode(result.getCode());
		return resp;
		
	}
    
}
