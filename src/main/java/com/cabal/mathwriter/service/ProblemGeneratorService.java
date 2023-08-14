package com.cabal.mathwriter.service;

import com.cabal.mathwriter.pojo.MathJob;
import org.apache.poi.xwpf.usermodel.*;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.UUID;

@Service
public class ProblemGeneratorService {

    private Random random = new Random();

    Path resourceDirectory = Paths.get("src", "main", "resources");

    public String makeMathBook(MathJob mj) {

        String path = "";

        XWPFDocument document = new XWPFDocument();
        setTitle(document, mj.getTitle());

        for(int x=0; x<50; x++) {
            if(x<25) {
                makeMathRow(document, "+");
            } else {
                makeMathRow(document, "-");
            }
        }

        try {
            path = resourceDirectory.toString()+ UUID.randomUUID().toString().replace("-","")+".docx";
            File output = new File(path);
            if(!output.exists()) {
                output.createNewFile();
            }
            FileOutputStream out = new FileOutputStream(output);
            document.write(out);
            out.close();
            document.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return path;
    }

    private int number() {
        return random.nextInt(1, 10);
    }

    private String equationInline(int number, String operator) {
        StringBuilder sb = new StringBuilder(number+".  ");
        return sb.append(number())
                .append(" ")
                .append(operator)
                .append(" ")
                .append(number())
                .append(" = ___   ").toString();
    }
    private void makeMathRow(XWPFDocument document, String operator) {

        XWPFParagraph row = document.createParagraph();
        row.setAlignment(ParagraphAlignment.LEFT);

        for(int x=1; x<25; x++) {
            XWPFRun rowRun = row.createRun();
            rowRun.setText(equationInline(x,operator));
            rowRun.setColor("000000");
            rowRun.setBold(true);
            rowRun.setFontFamily("Courier");
            rowRun.setFontSize(14);
            if(x%3==0) {
                row = document.createParagraph();
                row.setAlignment(ParagraphAlignment.LEFT);
                XWPFRun space = row.createRun();
                space.addCarriageReturn();
                space.addBreak(BreakClear.ALL);
                space.addBreak(BreakClear.ALL);
                space.addBreak(BreakClear.ALL);
            }
        }
    }

    private void setTitle(XWPFDocument document, String titleStr){
        XWPFParagraph title = document.createParagraph();
        title.setAlignment(ParagraphAlignment.CENTER);

        XWPFRun titleRun = title.createRun();
        titleRun.setText("Next Level Math");
        titleRun.setColor("009933");
        titleRun.setBold(true);
        titleRun.setFontFamily("Courier");
        titleRun.setFontSize(20);

        XWPFParagraph subTitle = document.createParagraph();
        subTitle.setAlignment(ParagraphAlignment.CENTER);

        XWPFRun subTitleRun = subTitle.createRun();
        subTitleRun.setText(titleStr);
        subTitleRun.setColor("00CC44");
        subTitleRun.setFontFamily("Courier");
        subTitleRun.setFontSize(16);
        subTitleRun.setTextPosition(20);
        subTitleRun.setUnderline(UnderlinePatterns.DOT_DOT_DASH);
        subTitleRun.addBreak(BreakClear.ALL);

        subTitleRun = subTitle.createRun();
        subTitleRun.setText("From, Ilm Search");
        subTitleRun.setColor("00CC44");
        subTitleRun.setFontFamily("Courier");
        subTitleRun.setFontSize(16);
        subTitleRun.setTextPosition(20);
        subTitleRun.setUnderline(UnderlinePatterns.DOT_DOT_DASH);

        subTitleRun.addBreak(BreakClear.ALL);
        subTitleRun.addBreak(BreakClear.ALL);
        subTitleRun.addBreak(BreakClear.ALL);
        subTitleRun.addBreak(BreakClear.ALL);
        subTitleRun.addBreak(BreakClear.ALL);
        subTitleRun.addBreak(BreakClear.ALL);
        subTitleRun.addBreak(BreakClear.ALL);
        subTitleRun.addBreak(BreakClear.ALL);
        subTitleRun.addBreak(BreakClear.ALL);
        subTitleRun.addBreak(BreakClear.ALL);
        subTitleRun.addBreak(BreakClear.ALL);
        subTitleRun.addBreak(BreakClear.ALL);
        subTitleRun.addBreak(BreakClear.ALL);
        subTitleRun.addBreak(BreakClear.ALL);
    }

}
