package com.w08e.xiaomai.api.controller;


import com.w08e.xiaomai.api.model.dto.UserCommand;
import com.w08e.xiaomai.api.model.dto.UserEditCommand;
import com.w08e.xiaomai.api.model.vo.UserVo;
import com.w08e.xiaomai.client.service.UserService;
import com.w08e.xiaomai.common.result.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2023-12-04 11:02:04
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 分页查询
     *
     * @param user        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
//    @GetMapping
//    public Result<Page<User>> queryByPage(User user, PageRequest pageRequest) {
//        return Result.ok(this.userService.queryByPage(user, pageRequest));
//    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public Result<UserVo> queryById(@PathVariable("id") Long id) {
        return Result.success(userService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @PostMapping
    public Result<Long> add(@RequestBody UserCommand user) {
        return Result.success(userService.insert(user));
    }

    /**
     * 编辑数据
     *
     * @param user 实体
     * @return 编辑结果
     */
    @PutMapping("{id}")
    public Result<Long> edit(@RequestBody UserEditCommand user,@PathVariable("id") Long id) {
        return Result.success(userService.update(user, id));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public Result<Boolean> deleteById(Long id) {
        return Result.success(Boolean.TRUE);
    }

}

