package com.yongrong.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yongrong.sell.model.ProductInfo;
import lombok.Data;

import java.util.List;

/**
 * Created by changyong on 2019/1/23.
 */
@Data
public class ProductVO {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
