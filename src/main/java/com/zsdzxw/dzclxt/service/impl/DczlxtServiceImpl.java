package com.zsdzxw.dzclxt.service.impl;

import com.zsdzxw.dzclxt.entity.dto.LoginDTO;
import com.zsdzxw.dzclxt.entity.model.Appraise;
import com.zsdzxw.dzclxt.entity.model.Bike;
import com.zsdzxw.dzclxt.entity.model.Order;
import com.zsdzxw.dzclxt.entity.model.User;
import com.zsdzxw.dzclxt.mapper.AppraiseMapper;
import com.zsdzxw.dzclxt.mapper.BikeMapper;
import com.zsdzxw.dzclxt.mapper.OrderMapper;
import com.zsdzxw.dzclxt.mapper.UserMapper;
import com.zsdzxw.dzclxt.service.DczlxtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DczlxtServiceImpl implements DczlxtService {

    @Autowired
    private AppraiseMapper appraiseMapper;

    @Autowired
    private BikeMapper bikeMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserMapper userMapper;


    /**
     * 插入用户（注册）
     *
     * @param user
     * @return
     */
    @Override
    public boolean insertUser(User user) {
        return userMapper.insert(user) > 0;
    }

    /**
     * 获取全部评价
     *
     * @return
     */
    public List<Appraise> getAllAppraise(){
        return appraiseMapper.getAllAppraise();
    }

    /**
     * 插入评价
     *
     * @param appraise
     * @return
     */
    public boolean insertAppraise(Appraise appraise){
        return appraiseMapper.insert(appraise) > 0;
    }


    /**
     * 修改电动车信息
     *
     * @param bike
     * @return
     */
    public boolean updateBike(Bike bike){
        return bikeMapper.updateById(bike) > 0;
    }

    /**
     * 插入电动车信息
     *
     * @param bike
     * @return
     */
    public boolean insertBike(Bike bike){
        return bikeMapper.insert(bike) > 0;
    }

    /**
     * 获取全部电动车信息
     *
     * @return
     */
    public List<Bike> getAllBike(){
        return bikeMapper.getAllBike();
    }

    /**
     * 获取全部用户信息
     *
     * @return
     */
    public List<User> getAllUser(){
        return userMapper.getAllUser();
    }

    /**
     * 登录功能
     *
     * @param dto
     * @return
     */
    public User getUserByNameOrTeleAndPassword(LoginDTO dto){
        return userMapper.getUserByNameOrTeleAndPassword(dto.getUserName(),dto.getUserPassword());
    }

    /**
     * 插入订单
     *
     * @param order
     * @return
     */
    public boolean inserOrder(Order order){
        return orderMapper.insert(order) > 0;
    }

    /**
     * 更新订单
     *
     * @param order
     * @return
     */
    public boolean updateOrder(Order order){
        return orderMapper.updateById(order) > 0;
    }

    /**
     * 通过用户ID查询订单
     *
     * @param userId
     * @return
     */
    public List<Order> getOrdersByUserId(Long userId ,Integer pageNo , Integer pageSize){
        return orderMapper.getOrdersByUserId(userId,pageNo,pageSize);
    }

    @Override
    public List<Order> getAllOrder() {
        return orderMapper.getAllOrder();
    }

    /**
     * 通过电动车ID查询订单
     *
     * @param bikeId
     * @return
     */
    public List<Order> getOrderByBikeId(Long bikeId){
        return orderMapper.getOrdersByBikeId(bikeId);
    }

    @Override
    public List<User> getPageUsers(Integer pageNo, Integer pageSize) {
        return userMapper.getPageUser(pageNo,pageSize);
    }

    @Override
    public List<Order> getPageOrders(Integer pageNo, Integer pageSize) {
        return orderMapper.getPageOrder(pageNo,pageSize);
    }

    @Override
    public List<Bike> getPageBikes(Integer pageNo, Integer pageSize) {
        return bikeMapper.getPageBike(pageNo,pageSize);
    }

    @Override
    public List<Appraise> getPageAppraises(Integer pageNo, Integer pageSize) {
        return appraiseMapper.getPageAppraise(pageNo,pageSize);
    }

    @Override
    public List<Order> getAllOrdersByUserId(Long userId) {
        return orderMapper.getAllOrdersByUserId(userId);
    }

    @Override
    public Bike getBikeById(Long bikeId) {
        return bikeMapper.getBikeById(bikeId);
    }

    @Override
    public Appraise getAppraiseByOrderId(Long orderId) {
        return appraiseMapper.getAppraisesByOrderId(orderId);
    }

    @Override
    public boolean updateUser(User user) {
        return userMapper.updateById(user) > 0;
    }

    @Override
    public boolean deleteUser(User user) {
        return userMapper.deleteById(user.getId()) > 0;
    }

    @Override
    public boolean deleteBike(Bike bike) {
        return bikeMapper.deleteById(bike.getId()) > 0;
    }

    @Override
    public boolean deleteAppraise(Appraise appraise) {
        return appraiseMapper.deleteById(appraise.getId()) > 0;
    }

    @Override
    public User getUserById(Long userId) {
        return userMapper.getUserById(userId);
    }


}
