package com.study.utils.pinyin;

import cn.hutool.extra.pinyin.PinyinUtil;

/**
 *
 * @author zkx
 */
public class Pinyinutils {

    public static String[] HanziChangeToPinyin(String str) {
        String[] split = str.split(". ", 2)[1].split("：");
        StringBuffer sb = new StringBuffer();
        for (char c : split[0].toCharArray()) {
            //汉字范围内
            if ('\u4E00' <=  c && c <= '\u9FA5') {
                sb.append(PinyinUtil.getFirstLetter(c));
            }
        }
        return new String[]{sb.toString(),split[1],"1"};
    }

}
