package com.liuduck.generator;


import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @author Prince
 */
public class CodeGenerator {

    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://101.33.200.230:3306/vocabulary?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=Asia/Shanghai", "root", "yayaword608")
                .globalConfig(builder -> {
                    builder.author("liuduck") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D:\\Projects\\duck-vocabulary-test\\duck-vocabulary-test\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\Projects\\duck-vocabulary-test\\duck-vocabulary-test\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("score")
                            .addInclude("user")
                            .addInclude("word")
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }

}