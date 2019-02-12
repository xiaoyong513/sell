package com.yongrong.sell.service.impl;

import com.yongrong.sell.dto.OrderDTO;
import com.yongrong.sell.model.OrderDetail;
import com.yongrong.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by changyong on 2019/2/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String BUYER_OPENID = "110110";

    @Test
    public void create() {
        OrderDTO dto = new OrderDTO();

        dto.setBuyerName("小马");
        dto.setBuyerAddress("永荣商城");
        dto.setBuyerOpenid(BUYER_OPENID);
        dto.setBuyerPhone("18347660201");

        // 购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("123456");
        o1.setProductQuantity(1);
        orderDetailList.add(o1);

        dto.setOrderDetailList(orderDetailList);

        OrderDTO orderDTO = orderService.create(dto);
        log.info("[创建订单] result={}", orderDTO);
    }

    @Test
    public void findOne() {
    }

    @Test
    public void findList() {
    }

    @Test
    public void cancel() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void paid() {
    }
}