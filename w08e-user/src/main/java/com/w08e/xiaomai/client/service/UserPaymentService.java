//package com.w08e.xiaomai.client.service;
//
//import com.w08e.xiaomai.domain.aggregate.userdomain.entity.entity.UserPayment;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//
///**
// * (UserPayment)表服务接口
// *
// * @author makejava
// * @since 2023-12-04 11:02:05
// */
//public interface UserPaymentService {
//
//    /**
//     * 通过ID查询单条数据
//     *
//     * @param id 主键
//     * @return 实例对象
//     */
//    UserPayment queryById(Long id);
//
//    /**
//     * 分页查询
//     *
//     * @param userPayment 筛选条件
//     * @param pageRequest 分页对象
//     * @return 查询结果
//     */
//    Page<UserPayment> queryByPage(UserPayment userPayment, PageRequest pageRequest);
//
//    /**
//     * 新增数据
//     *
//     * @param userPayment 实例对象
//     * @return 实例对象
//     */
//    UserPayment insert(UserPayment userPayment);
//
//    /**
//     * 修改数据
//     *
//     * @param userPayment 实例对象
//     * @return 实例对象
//     */
//    UserPayment update(UserPayment userPayment);
//
//    /**
//     * 通过主键删除数据
//     *
//     * @param id 主键
//     * @return 是否成功
//     */
//    boolean deleteById(Long id);
//
//}
