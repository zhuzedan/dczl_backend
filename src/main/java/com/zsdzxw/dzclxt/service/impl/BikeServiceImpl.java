package com.zsdzxw.dzclxt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zsdzxw.dzclxt.entity.model.Bike;
import com.zsdzxw.dzclxt.mapper.BikeMapper;
import com.zsdzxw.dzclxt.service.BikeService;
import org.springframework.stereotype.Service;

/**
 * (Bike)表服务实现类
 *
 * @author zzd
 * @since 2023-05-07 20:31:40
 */
@Service("bikeService")
public class BikeServiceImpl extends ServiceImpl<BikeMapper, Bike> implements BikeService {
}

