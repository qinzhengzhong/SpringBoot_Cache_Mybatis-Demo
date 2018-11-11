package com.allan.PDF;

import com.allan.Util.DateUtil;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;


public class ExportPDFUtil {

    /**
     * 报表导出功能
     *
     * @param fileName 文件名称
     * @param tableList 数据
     * @param response
     * @throws Exception
     */
    public static void export(String fileName, List<PDFTable> tableList, HttpServletResponse response) throws Exception {
        Document document = new Document();
        //主要是用来解决中文字体的问题
        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font titFont = new Font(bfChinese, 14, Font.NORMAL);
        Font docFont = new Font(bfChinese, 12, Font.NORMAL);
        Font subTitle = new Font(bfChinese, 16, Font.NORMAL);
        Font footnoteFont = new Font(bfChinese, 10, Font.NORMAL);

        // 设置response参数，可以打开下载页面
        response.reset();
        response.setContentType("application/pdf;charset=utf-8");
        response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("gb2312"), "ISO8859-1"));

        PdfWriter.getInstance(document, response.getOutputStream());

        //设置标题
        document.addTitle(fileName);
        //打开文档
        document.open();

        //设置title
        Paragraph header = new Paragraph(fileName, titFont);
        header.setAlignment(1);
        document.add(header);

        //设置导出时间
        Paragraph time = new Paragraph("【导出时间：" + DateUtil.format(new Date(), "yyyy 年 MM 月 dd") + " 】", docFont);
        time.setIndentationLeft(300);
        document.add(time);


        for (PDFTable table : tableList) {
            Paragraph title = new Paragraph(table.getTitle(), subTitle);
            document.add(title);
            if (table.getTextDescription() != null) {
                Paragraph textDescription = new Paragraph(table.getTextDescription() + "\n", docFont);
                textDescription.setSpacingBefore(10f);
                textDescription.setIndentationLeft(50);
                document.add(textDescription);
            }
            if (table.getFootnote() != null) {
                Paragraph footnote = new Paragraph(table.getFootnote(), footnoteFont);
                footnote.setIndentationLeft(50);
                document.add(footnote);
            }
            PdfPTable conTable = new PdfPTable(table.getConWidths());
            conTable.setSpacingBefore(5f);
            conTable.setWidthPercentage(80);
            for (PDFColumn column : table.getColumns()) {
                PdfPCell cell = new PdfPCell(new Paragraph(column.getText(), docFont));
                if (column.isBold) {
                    cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                }
                cell.setSpaceCharRatio(10f);
                conTable.addCell(cell);
            }
            document.add(conTable);
        }

        String str = "\n" + "确认（盖章）";
        Paragraph strGaiZhang = new Paragraph(str, titFont);
        strGaiZhang.setIndentationLeft(250);
        document.add(strGaiZhang);

        //关闭文档
        document.close();
    }
}
