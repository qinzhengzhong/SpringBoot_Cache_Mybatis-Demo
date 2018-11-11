package com.allan.Util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.WaterMark;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * 导出PDF格式 工具类（未完成）
 */
public class ExportPDFUtil {
    private final Logger logger = LoggerFactory.getLogger(ExportPDFUtil.class);

    /**
     * 导出PDF格式
     * @param pdfName 文件名稱
     * @param title 文件标题
     * @throws Exception
     */
    public static void exportPDF(String pdfName,String title,int size) throws  Exception{
        //主要是用来解决中文字体的问题
        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font FontChinese = new Font(bfChinese, 12, Font.NORMAL);
        Font timeFont = new Font(bfChinese, 8, Font.NORMAL);

        // 第一步，创建document对象
        Rectangle rectPageSize = new Rectangle(PageSize.A4);

        //下面代码设置页面横置
        //rectPageSize = rectPageSize.rotate();

        //创建document对象并指定边距
        Document doc = new Document(rectPageSize,50,50,50,50);
        Document document = new Document();
        try {
            setDocumentPro(document);
           /* //创建 PdfWriter 对象 第一个参数是对文档对象的引用，第二个参数是文件的实际名称，在该名称中还会给出其输出路径
           PdfWriter writer =PdfWriter.getInstance(document,new FileOutputStream(filePath));*/

            // 第二步,将Document实例和文件输出流用PdfWriter类绑定在一起,从而完成向Document写，即写入PDF文档
            PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream("D:\\"+pdfName+".pdf"));
//            PdfWriter.getInstance(document, response.getOutputStream());//直接下载文件

            //添加水印
            writer.setPageEvent(new WaterMark());
            //第3步,打开文档
            document.open();

            //------------开始写数据-------------------
            Paragraph titleText = new Paragraph(title, FontChinese);// 标题
            titleText.setAlignment(Element.ALIGN_CENTER); // 居中设置
            titleText.setLeading(1f);//设置行间距,设置上面空白宽度
            document.add(titleText);

            //设置导出时间
            Paragraph time = new Paragraph("【导出时间：" + DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss") + " 】", timeFont);
            time.setIndentationLeft(400);
            document.add(time);

            //创建表格
            PdfPTable table = new PdfPTable(6);//列数
            table.setHorizontalAlignment(Element.ALIGN_CENTER);//内容水平居中
            for(int i=0;i<size;i++) {
                if (i == 0) {
                    PdfPCell headCell = new PdfPCell();
                    headCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    headCell.setColspan(6);//表格头合并单元格
                    headCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    headCell.addElement(new Paragraph("表格头" , FontChinese));
                    //设置居中显示
                    headCell.setUseAscender(true);
                    headCell.setUseDescender(true);
                    headCell.setVerticalAlignment(Element.ALIGN_CENTER);//内容垂直居中
                    headCell.setHorizontalAlignment(Element.ALIGN_CENTER); //内容水平居中
                    table.addCell(headCell);
                } else {
                    PdfPCell dataCell = new PdfPCell();
                    dataCell.addElement(new Paragraph("表格内容" , FontChinese));
                    dataCell.setVerticalAlignment(Element.ALIGN_CENTER);//内容垂直居中
                    dataCell.setHorizontalAlignment(Element.ALIGN_CENTER); //内容水平居中
                    table.addCell(dataCell);
                }
            }
            document.add(table);//向文档中添加内容

        } catch (DocumentException de) {
            de.printStackTrace();
            System.err.println(de.getMessage());
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.err.println(ioe.getMessage());
        }finally {
            //关闭document文档
            document.close();
        }

        System.out.println("***** 生成HelloPdf成功 *****");
    }

    /**
     * 设置文档属性  (与文档是否打开没有关联)
     * @param document 文档对象
     */
    private static void setDocumentPro(Document document){
        document.addTitle("geely");
        document.addAuthor("allan qin"); // 作者
        document.addSubject("Subject@iText sample"); // 主题
        document.addKeywords("Keywords@iText");// 关键字
        document.addCreator("allanQin@iText");// 创建者
    }



}
