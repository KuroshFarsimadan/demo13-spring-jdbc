package ir.kuroshfarsimadan.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ir.kuroshfarsimadan.bean.Person;

public class PersonDAOSpringJdbcImpl implements PersonDAO {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void save(Person h) {
		String sql = "insert into person(firstname, lastname) values(?,?)";
		Object[] parameters = new Object[] { h.getFirstname(), h.getLastname() };
		jdbcTemplate.update(sql, parameters);
	}

	public Person find(int id) {
		String sql = "select firstname, lastname, id from person where id = ?";
		Object[] parameters = new Object[] { id };
		RowMapper<Person> mapper = new PersonRowMapper();
		Person p = jdbcTemplate.queryForObject(sql, parameters, mapper);
		return p;
	}

	public List<Person> retrieveAll() {
		String sql = "select id, firstname, lastname from person";
		RowMapper<Person> mapper = new PersonRowMapper();
		List<Person> persons = jdbcTemplate.query(sql, mapper);
		return persons;
	}

}
