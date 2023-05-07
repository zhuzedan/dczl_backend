package com.zsdzxw.dzclxt.service;

import com.zsdzxw.dzclxt.entity.dto.LoginDTO;
import com.zsdzxw.dzclxt.entity.model.Appraise;
import com.zsdzxw.dzclxt.entity.model.Bike;
import com.zsdzxw.dzclxt.entity.model.Order;
import com.zsdzxw.dzclxt.entity.model.User;

import java.util.List;

public interface DczlxtService {

    boolean insertUser(User user);
    List<Appraise> getAllAppraise();
    boolean insertAppraise(Appraise appraise);
    boolean updateBike(Bike bike);
    boolean insertBike(Bike bike);
    List<Bike> getAllBike();
    List<User> getAllUser();
    User getUserByNameOrTeleAndPassword(LoginDTO dto);
    boolean inserOrder(Order order);
    boolean updateOrder(Order order);
    List<Order> getOrdersByUserId(Long userId,Integer pageNo , Integer pageSize);

    List<Order> getAllOrder();
    List<Order> getOrderByBikeId(Long bikeId);
    List<User> getPageUsers(Integer pageNo,Integer pageSize);
    List<Order> getPageOrders(Integer pageNo,Integer pageSize);
    List<Bike> getPageBikes(Integer pageNo,Integer pageSize);
    List<Appraise> getPageAppraises(Integer pageNo,Integer pageSize);

    List<Order> getAllOrdersByUserId(Long userId);

    Bike getBikeById(Long bikeId);

    Appraise getAppraiseByOrderId(Long orderId);
    boolean updateUser(User user);

    boolean deleteUser(User user);

    boolean deleteBike(Bike bike);

    boolean deleteAppraise(Appraise appraise);

    User getUserById(Long userId);



}
