package com.yongrong.sell.repository;

import com.yongrong.sell.model.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import javax.swing.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by changyong on 2019/1/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    ProductInfoRepository repository;

    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setCategoryType(2);
        productInfo.setProductName("无限极");
        productInfo.setProductDescription("包治百病");
        productInfo.setProductPrice(new BigDecimal(200.00));
        productInfo.setProductStatus(0);
        productInfo.setProductStock(50);
        productInfo.setProductIcon("http://xxx.jpg");
        ProductInfo result = repository.save(productInfo);
        System.out.println(result.toString());
    }
    @Test
    public void findByProductStatus() {
        List<ProductInfo> byProductStatus = repository.findByProductStatus(0);
        if (!CollectionUtils.isEmpty(byProductStatus)) {
            byProductStatus.forEach(productInfo -> System.out.println(productInfo));
        }
    }
}