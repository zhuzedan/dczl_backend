package com.zsdzxw.dzclxt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zsdzxw.dzclxt.entity.model.Store;
import com.zsdzxw.dzclxt.mapper.StoreMapper;
import com.zsdzxw.dzclxt.service.StoreService;
import org.springframework.stereotype.Service;

/**
 * 门店表(Store)表服务实现类
 *
 * @author zzd
 * @since 2023-05-07 09:22:35
 */
@Service("storeService")
public class StoreServiceImpl extends ServiceImpl<StoreMapper, Store> implements StoreService {

}

