package com.liuduck.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.liuduck.entity.Word;
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

    public static void func() {

        List<Word> wordList = new ArrayList<>();

//        List<String> jsonList = getDataFromJsonFile("duck-vocabulary-test/CET6_1.json");
        List<String> jsonList = getDataFromJsonFile("duck-vocabulary-test/CET4_3.json");

        for (String json : jsonList) {
            JSONObject jsonObject = JSON.parseObject(json);
            String word = (String) jsonObject.get("headWord");
            String mean = (String) jsonObject.getJSONObject("content").
                    getJSONObject("word").
                    getJSONObject("content").
                    getJSONArray("trans").getJSONObject(0).get("tranCn");
            wordList.add(new Word(word, 1, mean));
        }

        for (Word w : wordList) {
            System.out.println(w);
        }

    }


    public static List<String> getDataFromJsonFile(String jsonFilePath) {
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
