package klu.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service
public class EmployeeManager {
	
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public EmployeeManager(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//INSERT
	public String saveData(Employee E)
	{
		try
		{
			String qry = "insert into employee values("+ E.getId() +",'"+ E.getName() +"')";
			jdbcTemplate.update(qry);
			return "New employee has been added";
		}catch (Exception e) 
		{
			return e.getMessage();
		}
	}
	
	//UPDATE
	public String updateData(Employee E)
	{
		try
		{
			String qry = "update employee set name='"+ E.getName() +"' where id="+ E.getId() +"";
			jdbcTemplate.update(qry);
			return "Employee details has been updated";
		}catch (Exception e) 
		{
			return e.getMessage();
		}
	}
	
	//DELETE
	public String deleteData(int id)
	{
		try
		{
			String qry = "delete from employee where id="+ id +"";
			jdbcTemplate.update(qry);
			return "Employee data has been deleted";
		}catch (Exception e) 
		{
			return e.getMessage();
		}
	}
	
	
	//READ
	
	public List<String> readData()
	{
		List<Employee> elist = null;
		try {
			String qry = "select * from employee";
			elist = jdbcTemplate.query(qry,new RowMapper<Employee>() {

				@Override
				public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
					Employee tmp = new Employee();
					tmp.setId(rs.getInt(1));
					tmp.setName(rs.getString(2));
					return tmp;
				}});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		List<String> result = new ArrayList<String>();
		
		for(Employee E:elist) {
			result.add(toJSON(E));
		}
		
		return result;
	}
	
	// Converting java object to JSON
	public String toJSON(Object obj)
	{
		Gson G = new GsonBuilder().create();
		return G.toJson(obj);
	}
}
