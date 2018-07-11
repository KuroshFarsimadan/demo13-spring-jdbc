package ir.kuroshfarsimadan.dao;

import java.util.List;

import ir.kuroshfarsimadan.bean.Person;

public interface PersonDAO {

	public abstract void save(Person henkilo);

	public abstract Person find(int id);

	public abstract List<Person> retrieveAll();

}