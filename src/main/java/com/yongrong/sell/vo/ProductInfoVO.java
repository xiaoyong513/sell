package com.yongrong.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yongrong.sell.model.ProductInfo;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by changyong on 2019/1/23.
 */
@Data
public class ProductInfoVO {

    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private  String productDescription;

    @JsonProperty("icon")
    private String productIcon;

    public ProductInfoVO() {
    }

    public ProductInfoVO(ProductInfo productInfo) {
        this.productId = productInfo.getProductId();
        this.productName = productInfo.getProductName();
        this.productPrice = productInfo.getProductPrice();
        this.productDescription = productInfo.getProductDescription();
        this.productIcon = productInfo.getProductIcon();
    }
}
