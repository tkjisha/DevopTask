package com.DaoImpl;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.stereotype.Repository;

import com.DAO.SupplierDao;
import com.Model.Supplier;
import com.Config.HibernateConfig;

@Repository("supdaoImpl")
public class SupplierDaoImpl implements SupplierDao{

	HibernateConfig hc;
	DataSource ds;
	SessionFactory sFactory;
	Session session;
	HibernateTransactionManager htm;
	
	public SupplierDaoImpl()
	{System.out.println("ds");
		hc=new HibernateConfig();
		ds=hc.getH2Data();System.out.println(ds);
		sFactory=hc.getSessionFac(ds);
		session=sFactory.openSession();
		htm=hc.gettrans(sFactory);
	}
	public boolean insertSupp(Supplier supp) {
		
		try{
		session.getTransaction().begin();
		session.save(supp);
		session.getTransaction().commit();
		return true;
		}
		catch(Exception e){
			return false;
		}
	}

	public boolean deleteSupp(Supplier supp) {
		
			try{
				session.getTransaction().begin();
				session.delete(supp);
				session.getTransaction().commit();
				return true;
				}
				catch(Exception e){
					return false;
				}
			
	}

	public boolean updateSupp(Supplier supp) {
		
		try{
			
			session.getTransaction().begin();
			session.update(supp);
			session.getTransaction().commit();
			
			return true;
			}
			catch(Exception e){
				return false;
			}
	}
	public Supplier get(String sid) {
		Supplier sup=session.get(Supplier.class, sid);
		return sup;
	}
	public Supplier getSupp(String s) {
		// TODO Auto-generated method stub
		return null;
	}
	public List listSupp() {
		// TODO Auto-generated method stub
		return null;
	}

}
