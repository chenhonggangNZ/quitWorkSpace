package com.vae.test;

import java.sql.SQLException;
import java.util.List;

import com.vae.dao.PersonDao;
import com.vae.dao.PersonDaoImpl;
import com.vae.domain.Person;

public class Test {

	public static void main(String[] args) throws SQLException {
		PersonDao dao = new PersonDaoImpl();

		 //dao.add(new Person("生命叁号",22,"我是通过Java命令而增加的记录"));

		 //dao.update(new Person(1,"生命壹号",23,"我是通过Java命令而修改的记录"));

		 //dao.delete(4);

		 //Person p = dao.findById(1);
		 //System.out.println(p);

		//List<Person> persons = dao.findAll();
		//System.out.println(persons);

		long count = dao.personCount();
		System.out.println(count);
	}

}
