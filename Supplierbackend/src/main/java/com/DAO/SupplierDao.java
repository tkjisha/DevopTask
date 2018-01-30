package com.DAO;

import com.Model.Supplier;

public interface SupplierDao {

	boolean insertSupp(Supplier supp);
	boolean deleteSupp(Supplier supp);
	boolean updateSupp(Supplier supp);
	Supplier get(String s);
}
