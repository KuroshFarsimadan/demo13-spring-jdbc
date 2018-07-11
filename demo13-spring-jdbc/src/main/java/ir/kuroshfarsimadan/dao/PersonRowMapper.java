package ir.kuroshfarsimadan.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import ir.kuroshfarsimadan.bean.Person;
import ir.kuroshfarsimadan.bean.PersonImpl;

public class PersonRowMapper implements RowMapper<Person> {

	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		Person p = new PersonImpl();
		p.setFirstname(rs.getString("firstname"));
		p.setLastname(rs.getString("lastname"));
		p.setId(rs.getInt("id"));
		return p;
	}

}
