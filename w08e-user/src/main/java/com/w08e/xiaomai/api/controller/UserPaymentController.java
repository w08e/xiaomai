//package com.w08e.xiaomai.api.controller;
//
//import com.w08e.xiaomai.domain.aggregate.userdomain.entity.entity.UserPayment;
//import com.w08e.xiaomai.domain.aggregate.userdomain.entity.service.UserPaymentService;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//
///**
// * (UserPayment)表控制层
// *
// * @author makejava
// * @since 2023-12-04 11:02:05
// */
//@RestController
//@RequestMapping("userPayment")
//public class UserPaymentController {
//    /**
//     * 服务对象
//     */
//    @Resource
//    private UserPaymentService userPaymentService;
//
//    /**
//     * 分页查询
//     *
//     * @param userPayment 筛选条件
//     * @param pageRequest 分页对象
//     * @return 查询结果
//     */
//    @GetMapping
//    public ResponseEntity<Page<UserPayment>> queryByPage(UserPayment userPayment, PageRequest pageRequest) {
//        return ResponseEntity.ok(this.userPaymentService.queryByPage(userPayment, pageRequest));
//    }
//
//    /**
//     * 通过主键查询单条数据
//     *
//     * @param id 主键
//     * @return 单条数据
//     */
//    @GetMapping("{id}")
//    public ResponseEntity<UserPayment> queryById(@PathVariable("id") Long id) {
//        return ResponseEntity.ok(this.userPaymentService.queryById(id));
//    }
//
//    /**
//     * 新增数据
//     *
//     * @param userPayment 实体
//     * @return 新增结果
//     */
//    @PostMapping
//    public ResponseEntity<UserPayment> add(UserPayment userPayment) {
//        return ResponseEntity.ok(this.userPaymentService.insert(userPayment));
//    }
//
//    /**
//     * 编辑数据
//     *
//     * @param userPayment 实体
//     * @return 编辑结果
//     */
//    @PutMapping
//    public ResponseEntity<UserPayment> edit(UserPayment userPayment) {
//        return ResponseEntity.ok(this.userPaymentService.update(userPayment));
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
//        return ResponseEntity.ok(this.userPaymentService.deleteById(id));
//    }
//
//}
//
