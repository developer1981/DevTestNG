package sample.mybatis.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sample.mybatis.domain.Dish;
@Component
public class DishMapper {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
    public Dish selectByPrimaryKey(Integer id){
    	return sqlSessionTemplate.selectOne("sample.mybatis.mapper.DishMapper.selectByPrimaryKey", id);

    }
    
    
    public List<Dish> selectByVendorId(Integer vendorId){
    	return sqlSessionTemplate.selectList("sample.mybatis.mapper.DishMapper.selectByVendorId", vendorId);
    	
    }

}