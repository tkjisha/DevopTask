package com.DaoImpl;

import org.springframework.stereotype.Repository;

import com.DAO.ProductDao;
import com.Model.Product;

@Repository("productDaoImpl")

public class ProductDaoImpl implements ProductDao{

	public boolean insertProd(Product prod) {
		
		return false;
	}

}
