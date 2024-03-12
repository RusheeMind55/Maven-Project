package com.example.ProjectDemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ProjectDemo.entity.Country;
import com.example.ProjectDemo.entity.Employee2;



@Repository
public class MainDao {

	
	@Autowired
	SessionFactory factory;
	
	public String addCountry(Country c) {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
			session.persist(c);
			tx.commit();
			msg="Data added succesfully...";
		} catch (Exception e) {
		
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;
	}
	
	public String updateData(Country c) {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
			
			Country country=session.get(Country.class,c.getCid());
			country.setCname(c.getCname());
			session.merge(country);
			
			tx.commit();
			msg="Data is updated succesfully...";
		} catch (Exception e) {
		
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;
	}
	
public String deleteCountry(Country c) {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
			
			Country country=session.get(Country.class,c.getCid());
			session.remove(c);
			
			tx.commit();
			msg="Data is Deleted succesfully...";
		} catch (Exception e) {
		
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;
	}
	


public String addEmployee(Employee2 e) {
	
	Session session=null;
	Transaction tx=null;
	String msg=null;
	
	try {
		session=factory.openSession();
		tx=session.beginTransaction();
		
		
		session.persist(e);
		
		tx.commit();
		msg="Data is updated succesfully...";
	} catch (Exception e1) {
	
		if(tx!=null) {
			tx.rollback();
		}
		e1.printStackTrace();
	
	}finally {
		if(session!=null) {
			session.close();
		}
	}
	
	return msg;
}


public String updateEmployee(Employee2 e) {
	
	Session session=null;
	Transaction tx=null;
	String msg=null;
	
	try {
		session=factory.openSession();
		tx=session.beginTransaction();
		
		
		Employee2 emp=session.get(Employee2.class,e.getId());
		emp.setName(e.getName());
		emp.setStatus(e.getStatus());
		emp.setCreatedby(e.getCreatedby());
		emp.setCountry(e.getCountry());
		emp.setCreatedt(e.getCreatedt());
		emp.setDepartment(e.getDepartment());
		emp.setUpdateby(e.getUpdateby());
		emp.setUpdatedt(e.getUpdatedt());
		
		
		session.merge(emp);
		
		tx.commit();
		msg="Data is updated succesfully...";
	} catch (Exception e1) {
	
		if(tx!=null) {
			tx.rollback();
		}
		e1.printStackTrace();
	
	}finally {
		if(session!=null) {
			session.close();
		}
	}
	
	return msg;
}


public Country getParticularRecord(int id) {
	
	Session session= factory.openSession();
	session.beginTransaction();
	
	String hqlQuery="from Country where id=:myid";
	
	Query<Country> query= session.createQuery(hqlQuery,Country.class);
	query.setParameter("myid",id );
	
	Country c= query.uniqueResult();
	session.getTransaction().commit();
	session.close();		
	return c;		
}


public List<Country> getAllRecord() {
	
	Session session= factory.openSession();
	session.beginTransaction();
	
	String hqlQuery="from Country";
	
	Query<Country> query= session.createQuery(hqlQuery,Country.class);
	
	List<Country> list= query.list();
	session.getTransaction().commit();
	session.close();	
	
	return list;		
	
}

public String getPerticularRecord(Country c) {
	
	Session session=null;
	Transaction tx=null;
	String msg=null;
	
	try {
		session=factory.openSession();
		tx=session.beginTransaction();
		tx.commit();
		msg="The perticular Record is...";
		
		String hqlQuery="from Country where id=:myid";
		
		Query<Country> query= session.createQuery(hqlQuery,Country.class);
		query.setParameter( "myid",c);
		
		
		Country c1= query.uniqueResult();
		
		
		
	} catch (Exception e1) {
	
		if(tx!=null) {
			tx.rollback();
		}
		e1.printStackTrace();
	
	}finally {
		if(session!=null) {
			session.close();
		}
	}
	
	return msg;
	}

public List<Country> getAllRecords() {
	
	Session session= factory.openSession();
	session.beginTransaction();
	
	String hqlQuery="from Country";
	
	Query<Country> query= session.createQuery(hqlQuery,Country.class);
	
	List<Country> list= query.list();
	session.getTransaction().commit();
	session.close();	
	
	return list;		
	
}
}

