package com.w08e.xiaomai.domain.aggregate.userdomain;

import com.w08e.xiaomai.domain.share.valueObject.Adress;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

/**
 * UserAdress
 *
 * @author makejava
 * @since 2023-12-04 11:02:04
 */
@Data
@NoArgsConstructor
public class UserAddress {


    private Long id;

    private OffsetDateTime createTime;

    private Boolean isDeleted;

    private OffsetDateTime modifyTime;

    /**
     * 是否默认地址
     */
    private Boolean isDefault;

    /**
     * 地址备注
     */
    private String name;
    /**
     * 手机号
     */
    private String phone;

    private Long userId;

    private Adress adress;

    public UserAddress(Long id, OffsetDateTime createTime, Boolean isDeleted, OffsetDateTime modifyTime, Boolean isDefault, String name, String phone, Long userId, Adress adress) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.adress = adress;
        this.createTime = createTime;
        this.isDeleted = isDeleted;
        this.phone = phone;
        this.isDefault = isDefault;
        this.modifyTime = modifyTime;
    }

    public void update(String adressName, String adressPhone, Adress adress, Boolean isDefault) {
        //todo 校验
        this.name = adressName;
        this.phone = adressPhone;
        this.adress = adress;
        this.isDefault = isDefault;
    }

}

