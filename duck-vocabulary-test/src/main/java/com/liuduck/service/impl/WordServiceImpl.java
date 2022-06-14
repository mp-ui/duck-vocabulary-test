package com.liuduck.service.impl;

import com.liuduck.entity.Word;
import com.liuduck.mapper.WordMapper;
import com.liuduck.service.IWordService;
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
public class WordServiceImpl extends ServiceImpl<WordMapper, Word> implements IWordService {

}
