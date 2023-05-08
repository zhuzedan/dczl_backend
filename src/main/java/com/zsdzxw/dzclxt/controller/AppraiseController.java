package com.zsdzxw.dzclxt.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zsdzxw.dzclxt.common.Result;
import com.zsdzxw.dzclxt.common.ResultCode;
import com.zsdzxw.dzclxt.entity.model.Appraise;
import com.zsdzxw.dzclxt.entity.model.Bike;
import com.zsdzxw.dzclxt.entity.vo.FrontAppraiseVO;
import com.zsdzxw.dzclxt.service.AppraiseService;
import com.zsdzxw.dzclxt.service.DczlxtService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * (Appraise)表控制层
 *
 * @author zzd
 * @since 2023-05-07 22:27:03
 */
@RestController
@RequestMapping("/dczlxt")
public class AppraiseController {

    @Autowired
    private AppraiseService appraiseService;
    @Autowired
    private DczlxtService dczlxtService;
    @ApiOperation(value = "评价列表")
    @GetMapping("/getAppraiseList")
    public Result getAppraiseList(String userId) {
        LambdaQueryWrapper<Appraise> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Appraise::getUserId,userId);
        List<Appraise> list = appraiseService.list(lambdaQueryWrapper);
        List<FrontAppraiseVO> frontAppraiseVOS = new ArrayList<>();
        for (Appraise appraise: list) {
            FrontAppraiseVO frontAppraiseVO = new FrontAppraiseVO();
            frontAppraiseVO.setAppraiseStar(appraise.getAppraiseStar());
            frontAppraiseVO.setAppraiseDescription(appraise.getAppraiseDescription());
            Bike bike = dczlxtService.getBikeById(appraise.getBikeId());
            frontAppraiseVO.setBikeName(bike.getBikeName());
            frontAppraiseVOS.add(frontAppraiseVO);
        }
        return Result.success(frontAppraiseVOS);
    }

    // @ApiOperation(value = "新增数据")
    // @PostMapping("/insertAppraise")
    // public Result insert(@RequestBody Appraise appraise) {
    //     boolean flag = appraiseService.save(appraise);
    //     if (flag) {
    //         return Result.success(null);
    //     } else {
    //         return Result.fail(ResultCode.API_AUTH_FAIL);
    //     }
    // }
    //
    // @ApiOperation(value = "修改数据")
    // @PostMapping("/updateAppraise")
    // public Result update(@RequestBody Appraise appraise) {
    //     appraiseService.updateById(appraise);
    //     return Result.success(null);
    // }
    //
    // @ApiOperation(value = "删除数据")
    // @DeleteMapping("/deleteAppraise")
    // public Result delete(Long id) {
    //     boolean flag = appraiseService.removeById(id);
    //     if (flag) {
    //         return Result.success(null);
    //     } else {
    //         return Result.fail(ResultCode.API_AUTH_FAIL);
    //     }
    // }
}

