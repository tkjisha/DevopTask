package com.DaoImpl;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Config.HibernateConfig;
import com.DAO.UserDao;
import com.Model.User;

@Repository("userdaoImpl")
@Service
public class UserDaoImpl implements UserDao{

	
	
	
	/*public UserDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}*/
	HibernateConfig hc;
	DataSource ds;
	SessionFactory sFactory;
	Session session;
	public UserDaoImpl(){
		System.out.println("ds");
		hc=new HibernateConfig();
		ds=hc.getH2Data();System.out.println(ds);
		sFactory=hc.getSessionFac(ds);
		session=sFactory.openSession();
		
	}
	@Override
	public boolean insertUser(User user) {
		try{
		System.out.println("insert");
		session.getTransaction().begin();
		session.save(user);
		session.getTransaction().commit();
		return true;
		}
		catch(Exception e){
		return false;
		}
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
