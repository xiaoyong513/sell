package com.yongrong.sell.controller;

import com.yongrong.sell.model.ProductCategory;
import com.yongrong.sell.model.ProductInfo;
import com.yongrong.sell.service.CategoryService;
import com.yongrong.sell.service.ProductService;
import com.yongrong.sell.utils.ResultUtils;
import com.yongrong.sell.vo.ProductInfoVO;
import com.yongrong.sell.vo.ProductVO;
import com.yongrong.sell.vo.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by changyong on 2019/1/22.
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public Result getProductList() {
        // 查询所有上架的商品
        List<ProductInfo> upAll = productService.findUpAll();
        // 查询类目(一次擦查询)
        List<Integer> categoryTypeList = new ArrayList<>();
        categoryTypeList = upAll.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> categoryByTypeIn = categoryService
                .findCategoryByTypeIn(categoryTypeList);
        // 数据拼装
        Map<Integer, List<ProductInfo>> collect = upAll.stream().collect(Collectors.groupingBy(ProductInfo::getCategoryType));
        List<ProductVO> productVOList = new ArrayList<>();
        categoryByTypeIn.forEach(productCategory -> {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());
            List<ProductInfo> productInfos = collect.get(productCategory.getCategoryType());
            List<ProductInfoVO> productInfoVOList = productInfos.stream()
                    .map(e -> new ProductInfoVO(e)).collect(Collectors.toList());
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        });

        return ResultUtils.success(productVOList);
    }
}
