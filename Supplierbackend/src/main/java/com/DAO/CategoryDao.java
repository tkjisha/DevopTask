package com.DAO;

import com.Model.Category;
import com.Model.Supplier;

public interface CategoryDao {

	boolean insertCategory(Category cat);
	boolean deleteCategory(Category cat);
	boolean updateCategory(Category cat);
	Category getById();
}
