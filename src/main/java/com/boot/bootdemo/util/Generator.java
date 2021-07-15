package com.boot.bootdemo.util;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Generator {
    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + tip + "：");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }


    private static void produceViewObject(String basePackage,String packageName,String type,Boolean isTablePrefix, String... tableNames) {
        for (int i = 0; i < tableNames.length; i++) {
            String tableName = tableNames[i];
            tableName = isTablePrefix ? tableName.substring(tableName.indexOf("_") + 1) : tableName;
            String outPutDir = basePackage + "\\" + (packageName.replace(".", "\\")) + "\\"+type+"\\"
                    + "\\";
            String baseFileName = underline2Camel(tableName, false);
            try {
                File outFile = new File(outPutDir);
                if (!outFile.exists()) {
                    outFile.mkdirs();
                }
                File voFile = new File(outFile, baseFileName +type +".java");
                if (!voFile.exists()) {
                    voFile.createNewFile();
                }
                BufferedReader reader = new BufferedReader(
                        new FileReader(basePackage + "\\" + (packageName.replace(".", "\\")) + "\\entity\\"
                                + baseFileName + ".java"));
                FileWriter fw = new FileWriter(voFile);
                String line = null;
                while ((line = reader.readLine()) != null) {
                    // 将实体类中的entity变为Vo
                    line = line.replace("entity", "vo").replace("Entity", "Vo");
                    // 去掉mybatis-plus注解
                    if (line.contains("TableName") || line.contains("TableField") || line.contains("Accessors") || line.contains("TableId") || line.contains("IdType")) {
                        continue;
                    }

                    if(line.contains("package ")){
                        line="package "+packageName+"."+type+";";
                    }
                    if(line.contains(baseFileName)){
                        line=line.replace(baseFileName,baseFileName+type);
                    }
                    line += "\r\n";
                    fw.write(line);
                }
                fw.close();
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir") + "/src/main/java";
        gc.setOutputDir(projectPath);
        gc.setAuthor("yuzq");
        gc.setOpen(false);
        gc.setFileOverride(true);//是否覆盖文件
        gc.setBaseResultMap(true); // xml resultmap
        gc.setBaseColumnList(true); // xml columlist
        gc.setSwagger2(false);  //实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDriverName("com.mysql.jdbc.Driver");

        dsc.setUrl("jdbc:mysql://192.168.0.239:3306/onlinecar?&characterEncoding=utf8&useSSL=false&serverTimezone=UTC");
        dsc.setUsername("yzcx_dev");
        dsc.setPassword("yzcx123");

//        dsc.setUrl("jdbc:mysql://39.106.121.52:3306/jxtg_pay1?&characterEncoding=utf8&useSSL=false&serverTimezone=UTC");
//        dsc.setUsername("root");
//        dsc.setPassword("mz666");

        dsc.setTypeConvert(new MySqlTypeConvert(){
            // 自定义数据库表字段类型转换【可选】
            @Override
            public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                if ( fieldType.toLowerCase().contains( "datetime" ) ) {
                    return DbColumnType.DATE;
                }
                String t = fieldType.toLowerCase();
                if (t.contains("tinyint(1)")) {
                    return DbColumnType.INTEGER;
                }
                return super.processTypeConvert(globalConfig, fieldType);
            }

        });
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        String packageName = scanner("包名");
        pc.setParent(packageName);
        pc.setController("controller");
        pc.setEntity("entity" );
        pc.setService("service" );
        pc.setServiceImpl("service."+"impl");
        pc.setMapper("dao" );
        pc.setXml("");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + packageName
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);

        // 公共父类
        // 写于父类中的公共字段

        String[] tablesNames=scanner("表名，多个英文逗号分割").split(",");
        strategy.setInclude(tablesNames);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix("t_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();

        produceViewObject(projectPath,packageName,"Vo",false,tablesNames);
        produceViewObject(projectPath,packageName,"Dto",false,tablesNames);
    }


    /**
     * 自定义类型转换
     */
    static class MySqlTypeConvertCustom extends MySqlTypeConvert implements ITypeConvert{
        @Override
        public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
            String t = fieldType.toLowerCase();
            if (t.contains("tinyint(1)")) {
                return DbColumnType.INTEGER;
            }
            return super.processTypeConvert(globalConfig, fieldType);
        }
    }


    /**
     * 下划线转驼峰法(默认小驼峰)
     *
     * @param line 源字符串
     * @param smallCamel 大小驼峰,是否为小驼峰(驼峰，第一个字符是大写还是小写)
     * @return 转换后的字符串
     */
    public static String underline2Camel(String line, boolean... smallCamel) {
        if (StringUtils.isBlank(line)) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile("([A-Za-z\\d]+)(_)?");
        Matcher matcher = pattern.matcher(line);
        // 匹配正则表达式
        while (matcher.find()) {
            String word = matcher.group();
            // 当是true 或则是空的情况
            if ((smallCamel.length == 0 || smallCamel[0]) && matcher.start() == 0) {
                sb.append(Character.toLowerCase(word.charAt(0)));
            } else {
                sb.append(Character.toUpperCase(word.charAt(0)));
            }

            int index = word.lastIndexOf('_');
            if (index > 0) {
                sb.append(word.substring(1, index).toLowerCase());
            } else {
                sb.append(word.substring(1).toLowerCase());
            }
        }
        return sb.toString();
    }

    /**
     * 驼峰法转下划线
     *
     * @param line 源字符串
     * @return 转换后的字符串
     */
    public static String camel2Underline(String line) {
        if (StringUtils.isBlank(line)) {
            return "";
        }
        line = String.valueOf(line.charAt(0)).toUpperCase().concat(line.substring(1));
        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile("[A-Z]([a-z\\d]+)?");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            String word = matcher.group();
            sb.append(word.toUpperCase());
            sb.append(matcher.end() == line.length() ? "" : "_");
        }
        return sb.toString();
    }
}
