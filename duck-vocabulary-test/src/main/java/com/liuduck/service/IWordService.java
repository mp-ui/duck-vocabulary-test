package com.liuduck.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liuduck.entity.Word;
import com.liuduck.vo.RankingListVo;
import com.liuduck.vo.WordVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liuduck
 * @since 2022-06-14
 */
public interface IWordService extends IService<Word> {

    public List<RankingListVo> getRankingList();

    public List<WordVo> getWords(Integer status, Integer page, Integer number);

//    public List<WordVo> getChuZhongWords(Integer page);
//
//    public List<WordVo> getGaoZhongWords(Integer page);
//
//    public List<WordVo> getLevel4Words(Integer page);
//
//    public List<WordVo> getLevel8Words(Integer page);

}
