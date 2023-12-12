//package com.w08e.xiaomai.api.controller;
//
//import com.w08e.xiaomai.domain.aggregate.userdomain.entity.entity.UserAdress;
//import com.w08e.xiaomai.domain.aggregate.userdomain.entity.service.UserAdressService;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//
///**
// * (UserAdress)表控制层
// *
// * @author makejava
// * @since 2023-12-04 11:02:04
// */
//@RestController
//@RequestMapping("userAdress")
//public class UserAdressController {
//    /**
//     * 服务对象
//     */
//    @Resource
//    private UserAdressService userAdressService;
//
//    /**
//     * 分页查询
//     *
//     * @param userAdress  筛选条件
//     * @param pageRequest 分页对象
//     * @return 查询结果
//     */
//    @GetMapping
//    public ResponseEntity<Page<UserAdress>> queryByPage(UserAdress userAdress, PageRequest pageRequest) {
//        return ResponseEntity.ok(this.userAdressService.queryByPage(userAdress, pageRequest));
//    }
//
//    /**
//     * 通过主键查询单条数据
//     *
//     * @param id 主键
//     * @return 单条数据
//     */
//    @GetMapping("{id}")
//    public ResponseEntity<UserAdress> queryById(@PathVariable("id") Long id) {
//        return ResponseEntity.ok(this.userAdressService.queryById(id));
//    }
//
//    /**
//     * 新增数据
//     *
//     * @param userAdress 实体
//     * @return 新增结果
//     */
//    @PostMapping
//    public ResponseEntity<UserAdress> add(UserAdress userAdress) {
//        return ResponseEntity.ok(this.userAdressService.insert(userAdress));
//    }
//
//    /**
//     * 编辑数据
//     *
//     * @param userAdress 实体
//     * @return 编辑结果
//     */
//    @PutMapping
//    public ResponseEntity<UserAdress> edit(UserAdress userAdress) {
//        return ResponseEntity.ok(this.userAdressService.update(userAdress));
//    }
//
//    /**
//     * 删除数据
//     *
//     * @param id 主键
//     * @return 删除是否成功
//     */
//    @DeleteMapping
//    public ResponseEntity<Boolean> deleteById(Long id) {
//        return ResponseEntity.ok(this.userAdressService.deleteById(id));
//    }
//
//}
//
