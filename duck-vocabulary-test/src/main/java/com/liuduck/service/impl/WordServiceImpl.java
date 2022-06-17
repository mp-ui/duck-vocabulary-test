package com.liuduck.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liuduck.entity.Word;
import com.liuduck.mapper.WordMapper;
import com.liuduck.service.IWordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuduck.vo.RankingListVo;
import com.liuduck.vo.WordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private WordMapper wordMapper;

    public List<RankingListVo> getRankingList() {
        List<RankingListVo> list = wordMapper.getRankingList();
        return list;
    }

    public List<WordVo> getWords(Integer status, Integer page, Integer number) {
        return wordMapper.getWords(status, page, number);
    }

//    public List<WordVo> getChuZhongWords(Integer page) {
//        return wordMapper.getChuZhongWords(page);
//    }
//
//    public List<WordVo> getGaoZhongWords(Integer page) {
//        return wordMapper.getGaoZhongWords(page);
//    }
//
//    public List<WordVo> getLevel4Words(Integer page) {
//        return wordMapper.getLevel4Words(page);
//    }
//
//    public List<WordVo> getLevel8Words(Integer page) {
//        return wordMapper.getLevel8Words(page);
//    }

}
