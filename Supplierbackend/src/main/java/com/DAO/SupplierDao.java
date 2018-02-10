package com.DAO;

import java.util.List;

import com.Model.Supplier;

public interface SupplierDao {

	boolean insertSupp(Supplier supp);
	boolean deleteSupp(Supplier supp);
	boolean updateSupp(Supplier supp);
	List<Supplier> retrieveSupplier();
	List listSupp();
}
