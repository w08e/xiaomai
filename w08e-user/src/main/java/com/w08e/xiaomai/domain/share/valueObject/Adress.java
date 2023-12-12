package com.w08e.xiaomai.domain.share.valueObject;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: jinyuewang
 * @Date: 2023/12/4 15:01
 */
@Data
public class Adress implements Serializable {

    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 详细地址
     */
    private String detail;
    /**
     * 区
     */
    private String district;

    public Adress(String province, String city, String district, String detail) {
        this.province = province;
        this.city = city;
        this.detail = detail;
        this.district = district;
    }
}
