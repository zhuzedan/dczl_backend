package com.zsdzxw.dzclxt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zsdzxw.dzclxt.entity.model.Appraise;
import com.zsdzxw.dzclxt.mapper.AppraiseMapper;
import com.zsdzxw.dzclxt.service.AppraiseService;
import org.springframework.stereotype.Service;

/**
 * (Appraise)表服务实现类
 *
 * @author zzd
 * @since 2023-05-07 22:27:07
 */
@Service("appraiseService")
public class AppraiseServiceImpl extends ServiceImpl<AppraiseMapper, Appraise> implements AppraiseService {
}

