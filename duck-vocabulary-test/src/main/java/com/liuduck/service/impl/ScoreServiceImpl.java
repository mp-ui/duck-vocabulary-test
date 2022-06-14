package com.liuduck.service.impl;

import com.liuduck.entity.Score;
import com.liuduck.mapper.ScoreMapper;
import com.liuduck.service.IScoreService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuduck
 * @since 2022-06-14
 */
@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score> implements IScoreService {

}
