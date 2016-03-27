package sample.mybatis.mapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import sample.mybatis.common.Config;
import sample.mybatis.common.ServiceResult;
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
    
    public ServiceResult register(Customer customer){
    	ServiceResult result = new ServiceResult();

    	try{
    		insertSelective(customer);
    		result.setCode(Config.SUCCESS_CODE);
    		result.setMsg(customer.getId().toString());  		
    	}catch(DuplicateKeyException duplicateKeyException){
    		result.setCode(Config.ERROR_CODE_DB);
    		result.setMsg("DuplicateKeyException: " + customer.getId().toString());
    	}
    	
    	return result;
    }


}