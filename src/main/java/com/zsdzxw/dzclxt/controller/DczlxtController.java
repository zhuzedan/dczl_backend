package com.zsdzxw.dzclxt.controller;

import com.zsdzxw.dzclxt.common.Result;
import com.zsdzxw.dzclxt.entity.dto.*;
import com.zsdzxw.dzclxt.entity.model.Appraise;
import com.zsdzxw.dzclxt.entity.model.Bike;
import com.zsdzxw.dzclxt.entity.model.Order;
import com.zsdzxw.dzclxt.entity.model.User;
import com.zsdzxw.dzclxt.entity.vo.AppraiseVO;
import com.zsdzxw.dzclxt.entity.vo.OrderVO;
import com.zsdzxw.dzclxt.entity.vo.PageVO;
import com.zsdzxw.dzclxt.service.DczlxtService;
import io.undertow.util.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/dczlxt")
public class DczlxtController {

    @Autowired
    private DczlxtService dczlxtService;

    @PostMapping("/login")
    public Result login(@RequestBody LoginDTO dto){
        User user = dczlxtService.getUserByNameOrTeleAndPassword(dto);
        if (user == null) {
            return Result.fail(1001,"用户名密码错误");
        }
        user.setUserPassword("");
        return Result.success(user);
    }

    @PostMapping("/register")
    public Result register(@RequestBody RegisterDTO dto){
        User user = new User();
        user.setUserName(dto.getUserName());
        user.setUserTele(dto.getUserTele());
        user.setUserPassword(dto.getUserPassword());
        user.setUserType(dto.getUserType());
        user.setUserStatus(0);
        user.setUserAllowence(0L);
        user.setLastLogin(new Date(System.currentTimeMillis()));
        return Result.success(dczlxtService.insertUser(user));
    }

    @PostMapping("/updateUser")
    public Result updateUser(@RequestBody UpdateUserDTO dto){
        User user = new User();
        user.setUserName(dto.getUserName());
        user.setUserTele(dto.getUserTele());
        user.setUserPassword(dto.getUserPassword());
        user.setUserType(dto.getUserType());
        user.setUserStatus(dto.getUserStatus());
        user.setUserAllowence(dto.getUserAllowence());
        user.setId(dto.getId());
        user.setLastLogin(new Date(System.currentTimeMillis()));
        return Result.success(dczlxtService.updateUser(user));
    }

    @PostMapping("/deleteUser")
    public Result deleteUser(@RequestBody UpdateUserDTO dto){
        User user = new User();
        user.setId(dto.getId());
        return Result.success(dczlxtService.deleteUser(user));
    }

    @PostMapping("/insertBike")
    public Result insertBike(@RequestBody BikeDTO dto){
        Bike bike = new Bike();
        bike.setBikeName(dto.getBikeName());
        bike.setBikeCost(dto.getBikeCost());
        bike.setBikeInsure(dto.getBikeInsure());
        bike.setBikeUrl("https://img.zcool.cn/community/0123aa57ac5a9f0000018c1b20920e.jpg@1280w_1l_2o_100sh.jpg");
        bike.setBikeStatus(1);
        bike.setInsertTime(new Date(System.currentTimeMillis()));
        return Result.success(dczlxtService.insertBike(bike));
    }

    @PostMapping("/deleteBike")
    public Result deleteBike(@RequestBody UpdateBikeDTO dto){
        Bike bike = new Bike();
        bike.setId(dto.getId());
        return Result.success(dczlxtService.deleteBike(bike));
    }

    @PostMapping("/updateBike")
    public Result deleteUser(@RequestBody UpdateBikeDTO dto){
        Bike bike = new Bike();
        bike.setId(dto.getId());
        bike.setBikeUrl(dto.getBikeUrl());
        bike.setBikeName(dto.getBikeName());
        bike.setBikeInsure(dto.getBikeInsure());
        bike.setBikeStatus(dto.getBikeStatus());
        bike.setBikeCost(dto.getBikeCost());
        return Result.success(dczlxtService.updateBike(bike));
    }

    @PostMapping("/insertOrder")
    public Result insertOrder(@RequestBody OrderDTO dto){
        Order order = new Order();
        order.setUserId(dto.getUserId());
        order.setBikeId(dto.getBikeId());
        order.setStartLocation(dto.getStartLocation());
        order.setStartTime(dto.getStartTime());
        order.setEndLocation(dto.getEndLocation());
        order.setEndTime(dto.getEndTime());
        order.setOrderCost(dto.getOrderCost());
        order.setOrderStatus(1);
        order.setMileage(dto.getMileage());
        return Result.success(dczlxtService.inserOrder(order));
    }



    @PostMapping("/insertAppraise")
    public Result insertAppraise(@RequestBody AppraiseDTO dto){
        Appraise appraise = new Appraise();
        appraise.setUserId(dto.getUserId());
        appraise.setOrderId(dto.getOrderId());
        appraise.setBikeId(dto.getBikeId());
        appraise.setAppraiseDescription(dto.getAppraiseDescripition());
        appraise.setAppraiseStar(dto.getAppraiseStar());
        return Result.success(dczlxtService.insertAppraise(appraise));
    }

    @PostMapping("/deleteAppraise")
    public Result deleteAppraise(@RequestBody AppraiseDTO dto){
        Appraise appraise = new Appraise();
        appraise.setId(dto.getId());
        return Result.success(dczlxtService.deleteAppraise(appraise));
    }

    @PostMapping("/getUsers")
    public Result getUsers(@RequestBody PageDTO dto){
        if (dto.getPageSize() == 0 && dto.getPageSize() == 0){
            List<User> users = dczlxtService.getAllUser();
            Long totel = Long.parseLong(users.size()+"");
            return Result.success(new PageVO(totel,dczlxtService.getAllUser()));
        }
        List<User> users = dczlxtService.getAllUser();
        Long totel = Long.parseLong(users.size()+"");
        Integer pageNo = dto.getPageNo();
        Integer pageSize = dto.getPageSize();
        dto.setPageNo((pageNo-1)*pageSize);
        dto.setPageSize(pageNo*pageSize);
        return Result.success(new PageVO(totel,dczlxtService.getPageUsers(dto.getPageNo(),dto.getPageSize())));
    }

    @PostMapping("/getOrders")
    public Result getOrders(@RequestBody PageDTO dto){
        if (dto.getPageSize() == 0 && dto.getPageSize() == 0){
            List<Order> orders = dczlxtService.getAllOrder();
            Long totel = Long.parseLong(orders.size()+"");
            return Result.success(new PageVO(totel,dczlxtService.getAllOrder()));
        }
        List<Order> orders = dczlxtService.getAllOrder();
        Long totel = Long.parseLong(orders.size()+"");
        Integer pageNo = dto.getPageNo();
        Integer pageSize = dto.getPageSize();
        dto.setPageNo((pageNo-1)*pageSize);
        dto.setPageSize(pageNo*pageSize);
        List<Order> pageOrders = dczlxtService.getPageOrders(dto.getPageNo(),dto.getPageSize());
        //处理时间字段
        List<OrderVO> newOrders = new ArrayList<>();
        for (Order order : pageOrders){
            String startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getStartTime());
            String endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getEndTime());
            try {
                order.setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startTime));
                order.setEndTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endTime));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            Bike bike = dczlxtService.getBikeById(order.getBikeId());
            OrderVO orderVO = new OrderVO();
            BeanUtils.copyProperties(order,orderVO);
            orderVO.setStartTimeStr(startTime);
            orderVO.setEndTimeStr(endTime);
            if (bike != null){
                orderVO.setBikeName(bike.getBikeName());
                orderVO.setBikeUrl(bike.getBikeUrl());
            }
            newOrders.add(orderVO);
        }
        return Result.success(new PageVO(totel,newOrders));
    }

    @PostMapping("/getOrdersByUserId")
    public Result getOrdersByUserId(@RequestBody UserOrderDTO dto){
        if (dto.getPageSize() == 0 && dto.getPageSize() == 0){
            List<Order> orders = dczlxtService.getAllOrder();
            Long totel = Long.parseLong(orders.size()+"");
            return Result.success(new PageVO(totel,dczlxtService.getAllOrder()));
        }
        List<Order> orders = dczlxtService.getAllOrdersByUserId(dto.getUserId());
        Long totel = Long.parseLong(orders.size()+"");
        Integer pageNo = dto.getPageNo();
        Integer pageSize = dto.getPageSize();
        dto.setPageNo((pageNo-1)*pageSize);
        dto.setPageSize(pageNo*pageSize);
        List<Order> userOrders = dczlxtService.getOrdersByUserId(dto.getUserId(),dto.getPageNo(),dto.getPageSize());
        //处理时间字段
        List<OrderVO> newOrders = new ArrayList<>();
        for (Order order : userOrders){
            String startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getStartTime());
            String endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getEndTime());
            try {
                order.setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startTime));
                order.setEndTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endTime));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            Bike bike = dczlxtService.getBikeById(order.getBikeId());
            Appraise appraise = dczlxtService.getAppraiseByOrderId(order.getId());
            OrderVO orderVO = new OrderVO();
            BeanUtils.copyProperties(order,orderVO);
            orderVO.setStartTimeStr(startTime);
            orderVO.setEndTimeStr(endTime);
            if (bike != null){
                orderVO.setBikeName(bike.getBikeName());
                orderVO.setBikeUrl(bike.getBikeUrl());
            }
            if (appraise != null){
                orderVO.setAppraiseStar(appraise.getAppraiseStar());
                orderVO.setAppraiseDescription(appraise.getAppraiseDescription());
            }
            newOrders.add(orderVO);
        }
        return Result.success(new PageVO(totel,newOrders));
    }

    @PostMapping("/getAppraises")
    public Result getAppraises(@RequestBody PageDTO dto){
        if (dto.getPageSize() == 0 && dto.getPageSize() == 0){
            List<Appraise> appraises = dczlxtService.getAllAppraise();
            Long totel = Long.parseLong(appraises.size()+"");
            return Result.success(new PageVO(totel,appraises));
        }
        List<Appraise> appraises = dczlxtService.getAllAppraise();
        Long totel = Long.parseLong(appraises.size()+"");
        Integer pageNo = dto.getPageNo();
        Integer pageSize = dto.getPageSize();
        dto.setPageNo((pageNo-1)*pageSize);
        dto.setPageSize(pageNo*pageSize);
        List<Appraise> appraiseList = dczlxtService.getPageAppraises(dto.getPageNo(),dto.getPageSize());
        List<AppraiseVO> appraiseVOS = new ArrayList<>();
        for (Appraise appraise : appraiseList){
            AppraiseVO appraiseVO = new AppraiseVO();
            BeanUtils.copyProperties(appraise,appraiseVO);
            User user = dczlxtService.getUserById(appraise.getUserId());
            Bike bike = dczlxtService.getBikeById(appraise.getBikeId());
            if (user != null && bike != null){
                appraiseVO.setUserName(user.getUserName());
                appraiseVO.setBikeName(bike.getBikeName());
            }
            appraiseVOS.add(appraiseVO);
        }
        return Result.success(new PageVO(totel,appraiseVOS));
    }

    @PostMapping("/getBikes")
    public Result getBikes(@RequestBody PageDTO dto){
        if (dto.getPageSize() == 0 && dto.getPageSize() == 0){
            List<Bike> bikes = dczlxtService.getAllBike();
            Long totel = Long.parseLong(bikes.size()+"");
            return Result.success(new PageVO(totel,bikes));
        }
        List<Bike> bikes = dczlxtService.getAllBike();
        Long totel = Long.parseLong(bikes.size()+"");
        Integer pageNo = dto.getPageNo();
        Integer pageSize = dto.getPageSize();
        dto.setPageNo((pageNo-1)*pageSize);
        dto.setPageSize(pageNo*pageSize);
        return Result.success(new PageVO(totel,dczlxtService.getPageBikes(dto.getPageNo(),dto.getPageSize())));
    }

}
