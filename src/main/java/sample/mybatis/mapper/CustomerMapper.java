package sample.mybatis.mapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sample.mybatis.common.Config;
import sample.mybatis.common.Result;
import sample.mybatis.domain.Customer;
@Component
public class CustomerMapper {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
		
    public int insertSelective(Customer record){
    	return sqlSessionTemplate.insert("sample.mybatis.mapper.CustomerMapper.insertSelective", record);
    }

    public Customer selectByName(String name){
    	return sqlSessionTemplate.selectOne("sample.mybatis.mapper.CustomerMapper.selectByName", name);
    }
    
    public Result register(Customer customer){
    	Result result = new Result();
    	
    	Customer savedCus = selectByName(customer.getName());
    	if (savedCus!=null){
    		result.setCode(Config.ERROR_CODE);
    		result.setMsg(customer.getName() + "existed!");
    		
    	}else{
    		insertSelective(customer);
    		result.setCode(Config.SUCCESS_CODE);
    		result.setMsg(customer.getId().toString());    		
    	}
    	
    	return result;
    }


}