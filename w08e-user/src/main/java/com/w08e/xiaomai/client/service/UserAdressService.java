//package com.w08e.xiaomai.client.service;
//
//import com.w08e.xiaomai.domain.aggregate.userdomain.entity.entity.UserAdress;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//
///**
// * (UserAdress)表服务接口
// *
// * @author makejava
// * @since 2023-12-04 11:02:05
// */
//public interface UserAdressService {
//
//    /**
//     * 通过ID查询单条数据
//     *
//     * @param id 主键
//     * @return 实例对象
//     */
//    UserAdress queryById(Long id);
//
//    /**
//     * 分页查询
//     *
//     * @param userAdress  筛选条件
//     * @param pageRequest 分页对象
//     * @return 查询结果
//     */
//    Page<UserAdress> queryByPage(UserAdress userAdress, PageRequest pageRequest);
//
//    /**
//     * 新增数据
//     *
//     * @param userAdress 实例对象
//     * @return 实例对象
//     */
//    UserAdress insert(UserAdress userAdress);
//
//    /**
//     * 修改数据
//     *
//     * @param userAdress 实例对象
//     * @return 实例对象
//     */
//    UserAdress update(UserAdress userAdress);
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
