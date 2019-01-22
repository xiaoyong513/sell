package com.yongrong.sell.repository;

import com.yongrong.sell.model.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.List;

/**
 * Created by changyong on 2019/1/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest() {
        ProductCategory productCategory = repository.getOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
    public void saveTest() {
        ProductCategory productCategory =  new ProductCategory("男生最爱", 3);
//        productCategory.setCategoryName("小马测试");
//        productCategory.setCategoryType(2);
        repository.save(productCategory);
    }

    @Test
    public void updateTest() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(1);
        productCategory.setCategoryType(2);
        productCategory.setCategoryName("小勇测试");
        repository.save(productCategory);
    }

    @Test
    public void findListByType() {
        List<Integer> typeList = Arrays.asList(2, 3);
        List<ProductCategory> categoryTypeIn = repository.findByCategoryTypeIn(typeList);
        for (ProductCategory p : categoryTypeIn) {
            System.out.println(p.toString());
        }
    }
}