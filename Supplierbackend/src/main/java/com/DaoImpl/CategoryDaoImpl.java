package com.DaoImpl;

import java.util.List;


import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Config.HibernateConfig;
import com.DAO.CategoryDao;
import com.Model.Category;

import javassist.bytecode.Descriptor.Iterator;

@Repository("categoryDaoImpl")
@Service
public class CategoryDaoImpl implements CategoryDao{

	HibernateConfig hc;
	DataSource ds;
	SessionFactory sFactory;
	Session session;
	HibernateTransactionManager htm;
	public CategoryDaoImpl()
	{
		System.out.println("ds");
		hc=new HibernateConfig();
		ds=hc.getH2Data();System.out.println(ds);
		sFactory=hc.getSessionFac(ds);
		session=sFactory.openSession();
		htm=hc.gettrans(sFactory);
	}
	public boolean insertCategory(Category cat) {
		System.out.print(session);
		try{
		session.beginTransaction();
		session.save(cat);
		session.getTransaction().commit();
		return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public boolean deleteCategory(Category cat) {
		
		return false;
	}

	public boolean updateCategory(Category cat) {
		
		return false;
	}

	public Category getById() {
		
		return null;
	}
	@Override
	public List<Category> retrieveCategory() {
		session.beginTransaction();
		List<Category> catList=session.createQuery("from Category").list();
		session.getTransaction().commit();
		
		return catList;
	}

}
