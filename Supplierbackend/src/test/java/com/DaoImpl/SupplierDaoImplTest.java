package com.DaoImpl;

import org.junit.Test;

import com.DAO.SupplierDao;
import com.DaoImpl.SupplierDaoImpl;
import com.Model.Supplier;

import junit.framework.TestCase;

public class SupplierDaoImplTest extends TestCase {

	SupplierDao supdao;
	/*	@Test
	public void testInsertSupp() {
		supdao=new SupplierDaoImpl();
		Supplier sup=new Supplier();
		sup.setSid("5");
		sup.setSupplierName("asd");
		assertTrue("Error ",supdao.insertSupp(sup));
	}

	@Test
	public void testDeleteSupp() {
		supdao=new SupplierDaoImpl();
		Supplier sp=supdao.get("1");
		assertTrue("Error ",supdao.deleteSupp(sp));
	}
*/
	@Test
	public void testUpdateSupp() {
		supdao=new SupplierDaoImpl();
		Supplier sp=supdao.get("5");
		sp.setSupplierName("adminss");
		assertTrue("Error ",supdao.updateSupp(sp));
	}

}
