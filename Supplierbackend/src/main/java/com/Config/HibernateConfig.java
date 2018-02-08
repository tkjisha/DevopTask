package com.Config;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import com.DaoImpl.SupplierDaoImpl;


@ComponentScan("com.*")
public class HibernateConfig {

	
	@Bean(name="datasource")
	public DataSource getH2Data()
	{
		DriverManagerDataSource dsource=new DriverManagerDataSource();
		dsource.setDriverClassName("org.h2.Driver");
		dsource.setUrl("jdbc:h2:tcp://localhost/~/supplierdb");
		dsource.setUsername("sa");
		dsource.setPassword("");
		System.out.println("H2 connected");
		return dsource;
		
	}
	private Properties getHiberProp()
	{
		Properties p=new Properties();
		p.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		p.put("hibernate.hbm2.ddl.auto","update" );
		p.put("hibernate.show_sql", "true");
		System.out.println("Data created");
		return p;
	}
	@Bean(name="sessionFactory")
	
	public SessionFactory getSessionFac(DataSource datasource)
	{
		LocalSessionFactoryBuilder sb=new LocalSessionFactoryBuilder(datasource);
		sb.addProperties(getHiberProp());
		sb.addAnnotatedClass(com.Model.Supplier.class);
		sb.addAnnotatedClass(com.Model.Category.class);
		sb.addAnnotatedClass(com.Model.Product.class);
		sb.addAnnotatedClass(com.Model.User.class);
		return sb.buildSessionFactory();
	}
	@Bean(name="transactionManager")
	@Autowired
	 public HibernateTransactionManager gettrans(SessionFactory sf)
	 {
		 HibernateTransactionManager tm=new HibernateTransactionManager(sf);
		 return tm;
	 }
}
