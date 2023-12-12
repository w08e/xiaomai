package com.w08e.xiaomai.domain.share.enums;

/**
 * @author jinyuewang
 */
public enum PayType {

    /**
     * 支付宝
     */
    ALIPAY(1),
    /**
     * 微信
     */
    WECHAT(2),
    /**
     * 银联
     */
    UNIONPAY(3),
    /**
     * 现金
     */
    CASH(4),
    /**
     * 余额
     */
    BALANCE(5),
    /**
     * 信用卡
     */
    CREDITCARD(6),
    /**
     * 借记卡
     */
    DEBITCARD(7),
    /**
     * 优惠券
     */
    COUPON(8),
    /**
     * 积分
     */
    INTEGRAL(9),
    /**
     * 其他
     */
    OTHER(10);

    private final Integer value;

    PayType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
