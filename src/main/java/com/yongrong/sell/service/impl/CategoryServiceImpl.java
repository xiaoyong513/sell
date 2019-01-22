package com.yongrong.sell.service.impl;

import com.yongrong.sell.model.ProductCategory;
import com.yongrong.sell.repository.ProductCategoryRepository;
import com.yongrong.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by changyong on 2019/1/21.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    ProductCategoryRepository repository;


    @Override
    public ProductCategory findOne(Integer categoryId) {
        return repository.getOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findCategoryByTypeIn(List<Integer> typeList) {
        return repository.findByCategoryTypeIn(typeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
