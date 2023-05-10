package com.zsdzxw.dzclxt.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zsdzxw.dzclxt.common.Result;
import com.zsdzxw.dzclxt.common.ResultCode;
import com.zsdzxw.dzclxt.entity.dto.PageDTO;
import com.zsdzxw.dzclxt.entity.model.Store;
import com.zsdzxw.dzclxt.service.StoreService;
import com.zsdzxw.dzclxt.util.PageHelper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @apiNote 门店接口
 * @author zzd
 * @date 2023/5/7 9:21
 */
@RestController
@RequestMapping("/dczlxt")
public class StoreController {
    @Autowired
    private StoreService storeService;

    @PostMapping("/getAllStore")
    public Result getAllStore() {
        LambdaQueryWrapper<Store> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Store::getStatus, 1);
        List<Store> list = storeService.list(lambdaQueryWrapper);
        return Result.success(list);
    }

    @PostMapping("/getStorePage")
    public Result getStorePage(@RequestBody PageDTO dto) {
        Page<Store> page = new Page<>(dto.getPageNo(), dto.getPageSize());
        LambdaQueryWrapper<Store> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        IPage<Store> iPage = storeService.page(page, lambdaQueryWrapper);
        PageHelper<Store> storePageHelper = PageHelper.restPage(iPage);
        return Result.success(storePageHelper);
    }

    @ApiOperation(value = "新增数据")
    @PostMapping("/insertStore")
    public Result insert(@RequestBody Store store) {
        boolean flag = storeService.save(store);
        if (flag) {
            return Result.success(null);
        } else {
            return Result.fail(ResultCode.API_AUTH_FAIL);
        }
    }

    @ApiOperation(value = "修改数据")
    @PostMapping("/updateStore")
    public Result update(@RequestBody Store store) {
        storeService.updateById(store);
        return Result.success(null);
    }

    @ApiOperation(value = "删除数据")
    @DeleteMapping("/deleteStore")
    public Result delete(Long id) {
        boolean flag = storeService.removeById(id);
        if (flag) {
            return Result.success(null);
        } else {
            return Result.fail(ResultCode.API_AUTH_FAIL);
        }
    }
}
