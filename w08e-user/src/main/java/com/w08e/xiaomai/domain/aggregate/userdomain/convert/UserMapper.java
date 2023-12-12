package com.w08e.xiaomai.domain.aggregate.userdomain.convert;

import com.w08e.xiaomai.domain.aggregate.userdomain.User;
import com.w08e.xiaomai.domain.aggregate.userdomain.UserAddress;
import com.w08e.xiaomai.domain.aggregate.userdomain.UserPayment;
import com.w08e.xiaomai.domain.share.valueObject.Adress;
import com.w08e.xiaomai.infrastructure.db.model.UserAdresssEntity;
import com.w08e.xiaomai.infrastructure.db.model.UserEntity;
import com.w08e.xiaomai.infrastructure.db.model.UserPaymentEntity;

/**
 * @Author: jinyuewang
 * @Date: 2023/12/4 14:37
 */

public class UserMapper {

    /**
     * 将UserEntity对象转换为User对象
     *
     * @param userEntity        UserEntity对象
     * @return User对象
     */
    public static User entity2Domain(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setName(userEntity.getName());
        user.setUserName(userEntity.getUserName());
//        user.setPassword(userEntity.getPassword());
        user.modiyfMail(userEntity.getMail());
        user.modiyfMobile(userEntity.getMobile());
        user.setDeleted(userEntity.isDelete());
        user.setCreateTime(userEntity.getCreateTime());
        user.setStatus(userEntity.getStatus());
        user.setModifyTime(userEntity.getModifyTime());
        user.setLastLoginTime(userEntity.getLastLoginTime());
        return user;
    }


    public static UserEntity domain2Entity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setName(user.getName());
        userEntity.setUserName(user.getUserName());
        userEntity.setPassword(user.getPassword());
        userEntity.setMail(user.getMail());
        userEntity.setMobile(user.getMobile());
        userEntity.setModifyTime(user.getModifyTime());
        userEntity.setLastLoginTime(user.getLastLoginTime());
        return userEntity;
    }

    public static UserAdresssEntity domain2Entity(UserAddress userAdress) {
        UserAdresssEntity userAdresssEntity = new UserAdresssEntity();
        userAdresssEntity.setId(userAdress.getId());
        userAdresssEntity.setUserId(userAdress.getUserId());
        userAdresssEntity.setName(userAdress.getName());
        userAdresssEntity.setProvince(userAdress.getAdress().getProvince());
        userAdresssEntity.setCity(userAdress.getAdress().getCity());
        userAdresssEntity.setDistrict(userAdress.getAdress().getDistrict());
        userAdresssEntity.setDetail(userAdress.getAdress().getDetail());
        userAdresssEntity.setPhone(userAdress.getPhone());
        userAdresssEntity.setIsDefault(userAdress.getIsDefault());
        userAdresssEntity.setModifyTime(userAdress.getModifyTime());
        return userAdresssEntity;
    }

    public static UserPaymentEntity domain2Entity(UserPayment userPayment) {
        UserPaymentEntity userPaymentEntity = new UserPaymentEntity();
        userPaymentEntity.setId(userPayment.getId());
        userPaymentEntity.setUserId(userPayment.getUserId());
        userPaymentEntity.setAccount(userPayment.getAccount());
        userPaymentEntity.setIsDefault(userPayment.getIsDefault());
        userPaymentEntity.setModifyTime(userPayment.getModifyTime());
        userPaymentEntity.setType(userPayment.getType());
        return userPaymentEntity;
    }

    public static UserAddress entity2Domain(UserAdresssEntity userAdresssEntity) {
        UserAddress userAdress = new UserAddress();
        userAdress.setId(userAdresssEntity.getId());
        userAdress.setUserId(userAdresssEntity.getUserId());
        userAdress.setName(userAdresssEntity.getName());
        userAdress.setPhone(userAdresssEntity.getPhone());
        userAdress.setIsDefault(userAdresssEntity.getIsDefault());
        userAdress.setModifyTime(userAdresssEntity.getModifyTime());
        userAdress.setAdress(new Adress(userAdresssEntity.getProvince(), userAdresssEntity.getCity(), userAdresssEntity.getDistrict(), userAdresssEntity.getDetail()));
        return userAdress;
    }

    public static UserPayment entity2Domain(UserPaymentEntity userPaymentEntity) {
        UserPayment userPayment = new UserPayment();
        userPayment.setId(userPaymentEntity.getId());
        userPayment.setUserId(userPaymentEntity.getUserId());
        userPayment.setAccount(userPaymentEntity.getAccount());
        userPayment.setIsDefault(userPaymentEntity.getIsDefault());
        userPayment.setModifyTime(userPaymentEntity.getModifyTime());
        userPayment.setType(userPaymentEntity.getType());
        return userPayment;
    }
}
