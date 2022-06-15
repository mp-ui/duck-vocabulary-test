package com.liuduck.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuduck.entity.Word;
import com.liuduck.vo.RankingListVo;
import com.liuduck.vo.WordVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liuduck
 * @since 2022-06-14
 */
public interface WordMapper extends BaseMapper<Word> {

    List<RankingListVo> getRankingList();

    List<WordVo> getWords(Integer status, Integer page, Integer number);

//    List<WordVo> getChuZhongWords(Integer status, Integer page, Integer number);
//
//    List<WordVo> getGaoZhongWords(Integer status, Integer page, Integer number);
//
//    List<WordVo> getLevel4Words(Integer status, Integer page, Integer number);
//
//    List<WordVo> getLevel8Words(Integer status, Integer page, Integer number);

}
