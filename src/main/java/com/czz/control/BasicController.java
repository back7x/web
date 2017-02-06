package com.czz.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zzvc.model.World;

@Controller
public class BasicController {
	
	private NamedParameterJdbcTemplate jdbcTemplate;

	KeyHolder keyHolder = new GeneratedKeyHolder();

	@Autowired
	public void setDataSource(DataSource dataSouce) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSouce);
	}
	
	@RequestMapping("/basic")
	public void basic(){
		System.out.println("the world!!");
		//World world = new World();
		/*world.setValue("king");
		String sql = "insert into world(value) "
				+ "values(:value)";
		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(
				world);
		jdbcTemplate.update(sql, sqlParameterSource, keyHolder);
		System.out.println(keyHolder.getKey().intValue());*/
		String sql = "select * from world where version = :version and rare LIKE :rare";
		String likeVal = "%" + "r" + "%";
		MapSqlParameterSource para = new MapSqlParameterSource().addValue(
				"version", "1");
		para.addValue("rare", likeVal);
		//List<Map<String,Object>> results = jdbcTemplate.queryForList(sql, para);
		List<World> results = jdbcTemplate.query(sql, para, new BeanPropertyRowMapper<World>(World.class));
		for(World result:results){
			System.out.println(result.toString());
		}
	}
}	
