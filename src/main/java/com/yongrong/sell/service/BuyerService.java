package com.yongrong.sell.service;

import com.yongrong.sell.dto.OrderDTO;

/**
 * Created by changyong on 2019/2/14.
 */
public interface BuyerService {
    // 查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);
    // 取消订单
    OrderDTO cancelOrder(String openid, String orderId);
}
