package sample.mybatis.mapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sample.mybatis.domain.Restaurant;

@Component
public class RestaurantMapper {
	

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

    public Restaurant selectByPrimaryKey(Integer id){
    	return sqlSessionTemplate.selectOne("sample.mybatis.mapper.RestaurantMapper.selectByPrimaryKey", id);
    }

}