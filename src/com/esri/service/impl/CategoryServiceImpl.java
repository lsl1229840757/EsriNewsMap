package com.esri.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.esri.dao.CategoryDao;
import com.esri.entity.Category;
import com.esri.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Resource
	private CategoryDao cd;
	
	@Override
	public List<Category> findAll() {
		return cd.findAll();
	}

}
