package com.tsfn.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

@Repository
@PropertySource(value = {"classpath:application.properties"})
public class CustomerDAO {
	
	@Autowired
	private Environment env;
	
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	
	@Bean
	public DataSource getDataSource() {
	  DriverManagerDataSource dataSource = new DriverManagerDataSource();
	  dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
	  dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
	  dataSource.setUsername(env.getRequiredProperty("jdbc.username"));
	  dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
	  return dataSource;
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	  jdbcTemplate.setResultsMapCaseInsensitive(true);
	  return jdbcTemplate;
	}
	
	public int count(){
	    return this.jdbcTemplate.queryForObject("select count(*) from Customer",Integer.class);
	}
	
	
	public String getCustomerById(int id) {
		String sql = "select name from customer where id = ?";
		String name = jdbcTemplate.queryForObject(sql, new Object[] { id }, String.class);
		return name;
	}

	public List<Customer> getAllCustomers() {
		String sql = "select * from Customer";
		Object[] args = null; // { id } ;
		List<Customer> list = jdbcTemplate.query(sql, args, new CustomerRowMapper());
		return list;
	   }
	   
	   public List<Customer> getCustomerByNameLike(String name) {
		String sql = "select * from Customer where CustName like ?";
		 name = "%" + name + "%";
		Object[] args = { name };
		List<Customer> list = jdbcTemplate.query(sql, args, new CustomerRowMapper());
		return list;
	   }
	   
	   public int saveCustomer(Customer e) {
		String sql = "insert  into customer(custName) values  (?)";
		Object[] args = { e.getName() };
		int[] types = { Types.VARCHAR};
		int insertCount = jdbcTemplate.update(sql, args, types);
		return insertCount;
	   }

	   public int udpateCust(Customer e) {
		String sql = "udpate  customer set custName=?) where custID=?";
		Object[] args = { e.getName(), e.getId() };
		int[] types = { Types.VARCHAR,  Types.INTEGER };
		int insertCount = jdbcTemplate.update(sql, args, types);
		return insertCount;
	   }
	   

}


class CustomerRowMapper implements RowMapper<Customer> { 
	  
	public  Customer mapRow(ResultSet rs, int index) throws  SQLException   { 
			 Customer Customer   = new Customer();
			 Customer .setId  ( rs.getInt   ("custID")  );
			 Customer .setName( rs.getString("custName"));
			
			 return Customer;
		}
	}
	
