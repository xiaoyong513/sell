package com.yongrong.sell.repository;

import com.yongrong.sell.model.OrderMaster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by changyong on 2019/1/30.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    OrderMasterRepository repository;

    @Test
    public void saveOrderMaster() {
        OrderMaster orderMaster = new OrderMaster();

        orderMaster.setOrderId("123458");
        orderMaster.setBuyerName("二孩2");
        orderMaster.setBuyerPhone("12344445555");
        orderMaster.setBuyerAddress("谢巨兴");
        orderMaster.setBuyerOpenid("110110");
        orderMaster.setOrderAmount(new BigDecimal(2.3));
        OrderMaster master = repository.save(orderMaster);
        System.out.println(master);
    }

    @Test
    public void findByBuyerOpenid() {
        PageRequest pageRequest = PageRequest.of(0, 3);
        Page<OrderMaster> orderMasters = repository.findByBuyerOpenid("110110", pageRequest);
        System.out.println(orderMasters.getTotalElements());
        System.out.println(orderMasters.getTotalPages());
        if (orderMasters.getContent().size() > 0) {
            orderMasters.get().forEach(orderMaster -> System.out.println(orderMaster));
        }
    }
}