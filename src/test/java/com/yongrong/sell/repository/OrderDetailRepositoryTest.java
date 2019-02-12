package com.yongrong.sell.repository;

import com.yongrong.sell.model.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by changyong on 2019/2/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void save() {
        OrderDetail detail = new OrderDetail();
        detail.setDetailId("1234567810");
        detail.setOrderId("1111111111");
        detail.setProductIcon("http://xxx.jpg");
        detail.setProductId("1111112");
        detail.setProductName("啥东西");
        detail.setProductPrice(new BigDecimal(3.2));
        detail.setProductQuantity(4);
        OrderDetail save = repository.save(detail);
        System.out.println(save);
    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> byOrderId = repository.findByOrderId("1111111111");
        if (byOrderId.size() > 0) {
            byOrderId.stream().forEach(orderDetail -> System.out.println(orderDetail));
        }
    }
}