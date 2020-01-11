package com.apidoc.utis;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 把pdf转换为word格式
 *
 * @author Angin
 * @date 2019/3/18 0018.
 */
public class PdfToWord {
    /**
     * 转换
     */

    @Autowired
    private IPhoneMapper iPhoneMapper;

    private final static Log log = LogFactory.get();

    public void convertText(String pdfPath) {
        PDDocument doc = null;
        OutputStream fos = null;
        Writer writer = null;
        PDFTextStripper stripper = null;
        try {
            doc = PDDocument.load(new File(pdfPath));
            fos = new FileOutputStream(pdfPath.substring(0, pdfPath.indexOf(".")) + ".txt");
            writer = new OutputStreamWriter(fos, "UTF-8");
            stripper = new PDFTextStripper();
            int pageNumber = doc.getNumberOfPages();
            stripper.setSortByPosition(true);
            stripper.setStartPage(1);
            stripper.setEndPage(pageNumber);
            stripper.writeText(doc, writer);
            writer.close();
            doc.close();
            //IoUtil.readUtf8Lines(fos,13);


        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("end..");
    }

    public void readFile(String filePath) throws Exception{
        List<String> stringList = new ArrayList<>();
        List<IPhone> IphoneList = new ArrayList<>();
        IPhone iPhone = new IPhone();
        File file = new File(filePath);
        BufferedReader reader = null;
        String content = null;
        int line =0;
        int toLong =0;
        String keyword = "APLXS-VZW";
        boolean flag = true;
        String[] arrayStr = null;
        String[] dnaStr = null;
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"GBK"));
        while ((content = reader.readLine()) != null) {
            if (content.contains(keyword)){
                stringList.add(content);
            }
            stringList.add(content);

        }
        log.debug(stringList.toString());
        for (String  value: stringList) {
            arrayStr = value.split("  ");
            dnaStr = arrayStr[line + 2].split(" ");
            iPhone.setItem(arrayStr[line]);
            iPhone.setDescription(arrayStr[line+1]+"  "+dnaStr[toLong]);
            iPhone.setQty(dnaStr[toLong+1]);
            iPhone.setRate(dnaStr[toLong+2]);
            iPhone.setAmount(dnaStr[toLong+3]);
            line=line+3;
            toLong = toLong+4;
            iPhoneMapper.insertSelective(iPhone);
        }
    }
}