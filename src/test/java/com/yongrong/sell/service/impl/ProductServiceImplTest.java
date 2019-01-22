package com.yongrong.sell.service.impl;

import com.yongrong.sell.model.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import javax.sound.midi.Soundbank;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by changyong on 2019/1/22.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;
    @Test
    public void findOne() {
        ProductInfo productInfo = productService.findOne("123456");
        System.out.println(productInfo.toString());
    }

    @Test
    public void findAll() {
        PageRequest request = new PageRequest(0, 2);
        Page<ProductInfo> page = productService.findAll(request);
        System.out.println(page.getTotalElements());
        page.get().forEach(productInfo -> System.out.println(productInfo));
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> upAll = productService.findUpAll();
        if (!CollectionUtils.isEmpty(upAll)) {
            upAll.forEach(productInfo -> System.out.println(productInfo.toString()));
        }
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setCategoryType(2);
        productInfo.setProductName("无限极1");
        productInfo.setProductDescription("包治百病1");
        productInfo.setProductPrice(new BigDecimal(200.10));
        productInfo.setProductStatus(0);
        productInfo.setProductStock(500);
        productInfo.setProductIcon("http://xxxx.jpg");
        ProductInfo result = productService.save(productInfo);
        System.out.println(result);
    }
}