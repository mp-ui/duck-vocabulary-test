package com.liuduck.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.liuduck.entity.Word;
import com.liuduck.enums.ClassificationEnum;
import com.liuduck.mapper.WordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DZHooo
 * @version 1.0
 * @date 2022/6/14 15:44
 * @description: TODO
 */

@Component
public class JsonConvertUtil {

    @Resource
    private WordMapper wordMapper;

    public void wordsToDataBase() {
        // 初中
        insertWord("D:\\gitRepos\\duck-vocabulary-test\\duck-vocabulary-test\\ChuZhong_2.json", ClassificationEnum.MIDDLE);
        insertWord("D:\\gitRepos\\duck-vocabulary-test\\duck-vocabulary-test\\ChuZhong_3.json", ClassificationEnum.MIDDLE);
        insertWord("D:\\gitRepos\\duck-vocabulary-test\\duck-vocabulary-test\\ChuZhongluan_2.json", ClassificationEnum.MIDDLE);
        // 高中
        insertWord("D:\\gitRepos\\duck-vocabulary-test\\duck-vocabulary-test\\GaoZhong_2.json", ClassificationEnum.HIGH);
        insertWord("D:\\gitRepos\\duck-vocabulary-test\\duck-vocabulary-test\\GaoZhong_3.json", ClassificationEnum.HIGH);
        insertWord("D:\\gitRepos\\duck-vocabulary-test\\duck-vocabulary-test\\GaoZhongluan_2.json", ClassificationEnum.HIGH);
        // 专四
        insertWord("D:\\gitRepos\\duck-vocabulary-test\\duck-vocabulary-test\\Level4_1.json", ClassificationEnum.TEM4);
        insertWord("D:\\gitRepos\\duck-vocabulary-test\\duck-vocabulary-test\\Level4_2.json", ClassificationEnum.TEM4);
        insertWord("D:\\gitRepos\\duck-vocabulary-test\\duck-vocabulary-test\\Level4luan_1.json", ClassificationEnum.TEM4);
        insertWord("D:\\gitRepos\\duck-vocabulary-test\\duck-vocabulary-test\\Level4luan_2.json", ClassificationEnum.TEM4);
        // 专八
        insertWord("D:\\gitRepos\\duck-vocabulary-test\\duck-vocabulary-test\\Level8_1.json", ClassificationEnum.TEM8);
        insertWord("D:\\gitRepos\\duck-vocabulary-test\\duck-vocabulary-test\\Level8_2.json", ClassificationEnum.TEM8);
        insertWord("D:\\gitRepos\\duck-vocabulary-test\\duck-vocabulary-test\\Level8luan_2.json", ClassificationEnum.TEM8);
    }

    public void insertWord(String path, ClassificationEnum classify) {

        List<Word> wordList = new ArrayList<>();

        List<String> jsonList = getDataFromJsonFile(path);

        for (String json : jsonList) {

            JSONObject jsonObject = JSON.parseObject(json);

            String word = (String) jsonObject.get("headWord");

            String mean = (String) jsonObject.getJSONObject("content").
                    getJSONObject("word").
                    getJSONObject("content").
                    getJSONArray("trans").getJSONObject(0).get("tranCn");

            wordList.add(new Word(word, classify.getCode(), mean));

        }

        for (Word w : wordList) {
            wordMapper.insert(w);
        }

    }


    public List<String> getDataFromJsonFile(String jsonFilePath) {
        List<String> jsonList = new ArrayList<>();
        File file = new File(jsonFilePath);
        if (file.exists()) {
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
                String s = null;
                while ((s = bufferedReader.readLine()) != null) {
                    jsonList.add(s);
                }
            } catch (IOException e) {
                System.out.println("=====获取数据异常=====" + e);
            } finally {
                if (null != bufferedReader) {
                    try {
                        bufferedReader.close();
                    } catch (IOException ex) {
                        System.out.println("=======获取数据时，关闭流异常=======" + ex);
                    }
                }
            }
        }
        return jsonList;
    }

}
