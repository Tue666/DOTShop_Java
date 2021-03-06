package com.manage.DAL;

import java.util.List;

import com.manage.Models.CategoryModel;

public interface ICategoryDAL {
	
	List<CategoryModel> getCategory();
	
	int insertCategory (String title,String slug,String image, String parentID, String displayorder,String banner,String status,String createdat,String createdby,String updatedat,String updatedby);
	
	int updateCategory(String title,String slug,String image, String parentID, String displayorder,String banner,String status,String createdat,String createdby,String updatedat,String updatedby, int ID);
	
	CategoryModel findByID(int ID);
	
	int removeCategory (int ID);
}
