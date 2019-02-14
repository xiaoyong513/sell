package com.yongrong.sell.controller;

import com.yongrong.sell.converter.OrderForm2OrderDTO;
import com.yongrong.sell.dto.OrderDTO;
import com.yongrong.sell.enums.ResultEnum;
import com.yongrong.sell.exception.SellException;
import com.yongrong.sell.form.OrderForm;
import com.yongrong.sell.service.BuyerService;
import com.yongrong.sell.service.OrderService;
import com.yongrong.sell.utils.ResultUtils;
import com.yongrong.sell.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by changyong on 2019/2/13.
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BuyerService buyerService;

    // 创建底单
    @PostMapping("/create")
    public Result<Map<String, String>> create(@Valid OrderForm orderForm,
                                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("[创建订单] 参数不正确, orderForm={}", orderForm);
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTO.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error(" [创建订单] 购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createResult = orderService.create(orderDTO);
        Map<String, String> map = new HashMap<>();
        map.put("orderId", orderDTO.getOrderId());
        return ResultUtils.success(map);
    }
    // 订单列表
    @GetMapping("/list")
    public Result<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                       @RequestParam(value = "page", defaultValue = "0") Integer page,
                                       @RequestParam(value = "size", defaultValue = "10") Integer size) {
        if (StringUtils.isEmpty(openid)) {
            log.error("[查询订单列表] openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        PageRequest pageRequest = PageRequest.of(page, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, pageRequest);
        return ResultUtils.success(orderDTOPage.getContent());
    }
    // 订单详情
    @GetMapping("/detail")
    public Result<OrderDTO> detail(@RequestParam("openid") String openid,
                                   @RequestParam("orderId") String orderId) {
        if (StringUtils.isEmpty(openid)) {
            log.error("[查询订单列表] openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        if (StringUtils.isEmpty(orderId)) {
            log.error("[查询订单列表] orderId为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        OrderDTO orderDTO = buyerService.findOrderOne(openid, orderId);
        return ResultUtils.success(orderDTO);
    }
    // 取消订单
    @PostMapping("/cancel")
    public Result cancel(@RequestParam("openid") String openid,
                         @RequestParam("orderId") String orderId) {
        if (StringUtils.isEmpty(openid)) {
            log.error("[查询订单列表] openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        if (StringUtils.isEmpty(orderId)) {
            log.error("[查询订单列表] orderId为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        OrderDTO orderDTO = buyerService.cancelOrder(openid, orderId);
        return ResultUtils.success();
    }
}
