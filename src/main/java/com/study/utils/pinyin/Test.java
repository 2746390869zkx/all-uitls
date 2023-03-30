package com.study.utils.pinyin;

import com.study.utils.csv.CsvUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试汉字转拼音
 * @author zkx
 */
public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        List<Object[]> info = test.getInfo();
        if (info == null) {
            System.out.println("数据读取失败");
            return;
        }
        List<Object[]> info1 = test.getInfo();
        CsvUtil.writeCsvWithHeader(null,info1,"D:\\unit3.csv");
    }

    //读取文件
    public List<Object[]> getInfo(){

        ArrayList<Object[]> ans = null;

        File file = new File("D:\\桌面\\unit3.txt");

        if (!file.exists()) {
            System.out.println("文件不存在");
            return ans;
        }
        ans = new ArrayList<>();


        BufferedReader reader = null;
        FileReader fileReader = null;
        //进行读取
        try {
            fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);

            Object[] alls = reader.lines().map(s -> {
                return (String) s;
            }).toArray();

            for (Object str : alls) {
                String[] strings = Pinyinutils.HanziChangeToPinyin((String)str);
                ans.add(strings);
            }

            System.out.println("一共读取到了" + alls.length + "行");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件读取失败");
        } catch (IOException e) {
            System.out.println("文件读取失败");
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("数据读取成功");
        return ans;
    }

}
