package com.yongrong.sell.service.impl;

import com.yongrong.sell.model.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by changyong on 2019/1/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    CategoryServiceImpl categoryService;

    @Test
    public void findOne() {
        ProductCategory category = categoryService.findOne(1);
        System.out.println(category.toString());
    }

    @Test
    public void findAll() {
        List<ProductCategory> list = categoryService.findAll();
        if (!CollectionUtils.isEmpty(list)) {
            list.forEach(productCategory -> System.out.println(productCategory.toString()));
        }
    }

    @Test
    public void findCategoryByTypeIn() {
        List<Integer> typeList = Arrays.asList(2, 3);
        List<ProductCategory> list = categoryService.findCategoryByTypeIn(typeList);
        if (!CollectionUtils.isEmpty(list)) {
            list.forEach(productCategory -> System.out.println(productCategory.toString()));
        }
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory("女生最爱", 4);
        ProductCategory save = categoryService.save(productCategory);
        Assert.assertNotNull(save);

    }
}