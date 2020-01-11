package com.apidoc.utis;

/**
 * main方法测试
 * @author Angin
 * @date 2019/3/18 0018.
 */
public class MainClass {
    public static void main(String[] args) throws Exception {
    PdfToWord convert=new PdfToWord();
//   convert.convertText("G:\\Inv_16685_from_Centex_Trading_Group_Inc._9596.pdf");
        //PdfToWord.readFile("G:\\Inv_16685_from_Centex_Trading_Group_Inc.txt");
        convert.readFile("G:\\Inv_16685_from_Centex_Trading_Group_Inc.txt");
    }
}