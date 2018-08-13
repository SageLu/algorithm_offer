package com.sagelu.javaproblems;

import org.junit.Test;

/**
 一、题目
 请实现一个函数，把字符串中的每个空格替换成"%20"，例如“We are happy.”，则输出“We%20are%20happy.”。

 */
public class RemoveSpaceTest {
    @Test
    public void addition_isCorrect() throws Exception {
        char[] str="We are happy.".toCharArray();
        //此方式不行？  好像结果不对
//        int blank = replaceBlank(str, 3);
//        System.out.println("转换后使用的字符长度，-1表示处理失败："+blank);

        //此方式很对
        StringBuffer stringBuffer = new StringBuffer("We are happy.");
        String replaceSpace = replaceSpace(stringBuffer);
        System.out.println("转换后的字符"+replaceSpace);//转换后的字符We%20are%20happy.
    }
    /*
     二、解题思路
 先判断字符串中空格的数量。根据数量判断该字符串有没有足够的空间替换成"%20"。

 如果有足够空间，计算出需要的空间。根据最终需要的总空间，维护一个指针在最后。

 从后到前，遇到非空的就把该值挪到指针指向的位置，然后指针向前一位，遇到“ ”，则指针前移，依次替换为“02%”。

     * 请实现一个函数，把字符串中的每个空格替换成"%20"，例如“We are happy.“，则输出”We%20are%20happy.“。
     *
     * @param string     要转换的字符数组
     * @param usedLength 已经字符数组中已经使用的长度
     * @return 转换后使用的字符长度，-1表示处理失败
     */
    public  int replaceBlank(char[] string, int usedLength) {
        // 判断输入是否合法
        if (string == null || string.length < usedLength) {
            return -1;
        }

        // 统计字符数组中的空白字符数
        int whiteCount = 0;
        for (int i = 0; i < usedLength; i++) {
            if (string[i] == ' ') {
                whiteCount++;
            }
        }

        // 计算转换后的字符长度是多少
        int targetLength = whiteCount * 2 + usedLength;
        int tmp = targetLength; // 保存长度结果用于返回
        if (targetLength > string.length) { // 如果转换后的长度大于数组的最大长度，直接返回失败
            return -1;
        }

        // 如果没有空白字符就不用处理
        if (whiteCount == 0) {
            return usedLength;
        }

        usedLength--; // 从后向前，第一个开始处理的字符
        targetLength--; // 处理后的字符放置的位置

        // 字符中有空白字符，一直处理到所有的空白字符处理完
        while (usedLength >= 0 && usedLength < targetLength) {
            // 如是当前字符是空白字符，进行"%20"替换
            if (string[usedLength] == ' ') {
                string[targetLength--] = '0';
                string[targetLength--] = '2';
                string[targetLength--] = '%';
            } else { // 否则移动字符
                string[targetLength--] = string[usedLength];
            }
            usedLength--;
        }
        System.out.println("最终的元素："+new String(string));
        return tmp;
    }


    /*
    解题思路
在字符串尾部填充任意字符，使得字符串的长度等于字符串替换之后的长度。
因为一个空格要替换成三个字符（%20），因此当遍历到一个空格时，需要在尾部填充两个任意字符。
令 P1 指向字符串原来的末尾位置，P2 指向字符串现在的末尾位置。
P1 和 P2从后向前遍历，当 P1 遍历到一个空格时，就需要令 P2 指向的位置依次填充 02%（注意是逆序的），
否则就填充上 P1 指向字符的值。
从后向前遍是为了在改变 P2 所指向的内容时，不会影响到 P1 遍历原来字符串的内容。
     */
    public String replaceSpace(StringBuffer str) {
        int oldLen = str.length();
        for (int i = 0; i < oldLen; i++)
            if (str.charAt(i) == ' ')
                str.append("  ");

        int P1 = oldLen - 1, P2 = str.length() - 1;
        while (P1 >= 0 && P2 > P1) {
            char c = str.charAt(P1--);
            if (c == ' ') {
                str.setCharAt(P2--, '0');
                str.setCharAt(P2--, '2');
                str.setCharAt(P2--, '%');
            } else {
                str.setCharAt(P2--, c);
            }
        }
        return str.toString();
    }
}
