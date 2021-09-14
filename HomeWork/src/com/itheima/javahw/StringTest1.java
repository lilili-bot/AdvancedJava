package com.itheima.javahw;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

/*
##[题目一]
键盘录入一个字符串，使用程序实现在控制台遍历该字符串。


##【训练目标】：
字符串的遍历
##【思路分析】：
1:键盘录入一个字符串，用 Scanner 实现
2:遍历字符串，首先要能够获取到字符串中的每一个字符
    public char charAt(int index)：返回指定索引处的char值，字符串的索引也是从0开始的
3:遍历字符串，其次要能够获取到字符串的长度
    public int length()：返回此字符串的长度
    数组的长度：数组名.length
    字符串的长度：字符串对象.length()
4:遍历字符串的通用格式

##【参考步骤】：
1:键盘录入一个字符串，用 Scanner 实现
2:遍历字符串，首先要能够获取到字符串中的每一个字符
    public char charAt(int index)：返回指定索引处的char值，字符串的索引也是从0开始的
3:遍历字符串，其次要能够获取到字符串的长度
    public int length()：返回此字符串的长度
    数组的长度：数组名.length
    字符串的长度：字符串对象.length()
4:遍历字符串的通用格式
 */
public class StringTest1 {
    public static void main(String[] args) {
        // 1:键盘录入一个字符串，用 Scanner 实现
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        StringIteration(inputString);
    }

    private static char StringIteration(String inputString) {
        //2:遍历字符串，首先要能够获取到字符串中的每一个字符
        //public char charAt(int index)：返回指定索引处的char值，字符串的索引也是从0开始的
        int length = inputString.length();
        char Char = 1;
        for (int i = 0; i < length; i++) {
            Char = inputString.charAt(i);
        }
        return Char;
    }
}
