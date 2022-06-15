package com.liuduck.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liuduck.common.Result;
import com.liuduck.dto.OptionDTO;
import com.liuduck.entity.Score;
import com.liuduck.entity.Word;
import com.liuduck.enums.ClassificationEnum;
import com.liuduck.enums.ScoreIncrementEnum;
import com.liuduck.service.IScoreService;
import com.liuduck.service.IWordService;
import com.liuduck.vo.OptionVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wyt
 * @since 2022-06-14
 */
@Api("词汇测试")
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private IWordService wordService;

    @Autowired
    private IScoreService scoreService;

    @ApiOperation("进行词汇测试")
    @PostMapping("/estimate")
    public Result<OptionVO> vocabularyTest(@RequestBody OptionDTO optionDTO) {
        OptionVO optionVO = new OptionVO();
        // 开始测试
        if (optionDTO.getNum() == 0) {
            // 初试分数为 500
            optionVO.setScore(500);
            optionVO.setWrong(0);
            optionVO.setCtnwrong(0);
            // 提取一个初中的词汇和释义，还有三个其他单词的释义
            QueryWrapper<Word> wordQueryWrapper = new QueryWrapper<>();
            wordQueryWrapper.eq("status", 1);
            List<Word> wordList = wordService.list(wordQueryWrapper);
            Random random = new Random();
            int num = random.nextInt(wordList.size());
            Word word = wordList.get(num);
            optionVO.setWord(word.getWord());
            optionVO.setAnswer(word.getMean());
            optionVO.setIsFinish(false);
            // 正确的选项的位置(1~4)
            optionVO.setAnswerPos(random.nextInt(4) + 1);
            optionVO.setOption1(wordList.get((num + 200) % wordList.size()).getMean());
            optionVO.setOption2(wordList.get((num + 600) % wordList.size()).getMean());
            optionVO.setOption3(wordList.get((num + 1200) % wordList.size()).getMean());
        } else if (optionDTO.getNum() == 15) {
            int score = optionDTO.getScore();
            // 全部提交，统计分数
            boolean isCorrect = optionDTO.getOption().equals(optionDTO.getAnswer());
            int ctnwrong = optionDTO.getCtnwrong();
            int wrong = optionDTO.getWrong();
            if (optionDTO.getOption() == 0) {
                ctnwrong++;
                wrong++;
            } else if (!isCorrect) {
                ctnwrong += 2;
                wrong++;
            }
            score = calScore(score, isCorrect, ctnwrong);
            optionVO.setIsFinish(false);
            optionVO.setScore(score);
            // 提交到数据库
            Score scoreEntity = new Score();
            scoreEntity.setScore((double) score);
            scoreEntity.setUid(optionDTO.getId());
            scoreEntity.setTime(LocalDateTime.now());
            scoreEntity.setRightcount(15 - wrong);
            scoreService.saveOrUpdate(scoreEntity);
        } else {
            int score = optionDTO.getScore();
            boolean isCorrect = optionDTO.getOption().equals(optionDTO.getAnswer());
            int ctnwrong = optionDTO.getCtnwrong();
            int wrong = optionDTO.getWrong();
            if (optionDTO.getOption() == 0) {
                ctnwrong++;
                wrong++;
            } else if (!isCorrect) {
                ctnwrong += 2;
                wrong++;
            }

            score = calScore(score, isCorrect, ctnwrong);
            // 初试分数为 500
            optionVO.setScore(score);
            optionVO.setWrong(wrong);
            optionVO.setCtnwrong(ctnwrong);
            int status = ClassificationEnum.getStatus(score);
            // 提取一个初中的词汇和释义，还有三个其他单词的释义
            QueryWrapper<Word> wordQueryWrapper = new QueryWrapper<>();
            wordQueryWrapper.eq("status", status);
            List<Word> wordList = wordService.list(wordQueryWrapper);
            Random random = new Random();
            int num = random.nextInt(wordList.size());
            Word word = wordList.get(num);
            optionVO.setWord(word.getWord());
            optionVO.setAnswer(word.getMean());
            optionVO.setIsFinish(false);
            // 正确的选项的位置(1~4)
            optionVO.setAnswerPos(random.nextInt(4) + 1);
            optionVO.setOption1(wordList.get((num + 200) % wordList.size()).getMean());
            optionVO.setOption2(wordList.get((num + 600) % wordList.size()).getMean());
            optionVO.setOption3(wordList.get((num + 1200) % wordList.size()).getMean());
        }

        return Result.succ(optionVO);
    }

    /**
     * 计算成绩
     *
     * @param score
     * @param isCorrect
     * @return
     */
    private int calScore(int score, boolean isCorrect, int ctnwrong) {
        int scoreIncrement = 0;
        if (ctnwrong < 5) {
            scoreIncrement = ScoreIncrementEnum.getScoreIncrement(ctnwrong);
        } else {
            scoreIncrement = ScoreIncrementEnum.ZERO.getScoreIncrement();
        }

        if (!isCorrect) {
            scoreIncrement = -scoreIncrement;
        }

        return score + scoreIncrement;
    }
}

