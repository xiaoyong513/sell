package com.yongrong.sell.service;

import com.yongrong.sell.model.ProductCategory;

import java.security.PrivateKey;
import java.util.List;

/**
 * Created by changyong on 2019/1/21.
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findCategoryByTypeIn(List<Integer> typeList);

    ProductCategory save(ProductCategory productCategory);
}
