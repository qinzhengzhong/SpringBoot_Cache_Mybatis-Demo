package test;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * 为PDF文档添加水印
 */
public class WaterMark extends PdfPageEventHelper {

    /**
     * 添加水印
     * @param writer 写入对象
     * @param document 文档对象
     */
    @Override
    public  void onEndPage(PdfWriter writer, Document document) {
        //获取水印图片的路径
        String markImagePath = "D:\\logo.png";//水印图片
        float pageHeight = document.getPageSize().getHeight();
        float pageWidth = document.getPageSize().getWidth();

        try {
            Image img = Image.getInstance(markImagePath);//生成水印图片
            final float IMAGE_SIZE = 0.6f;//图片缩放比例，大小0
            float plainWidth = img.getPlainWidth() * IMAGE_SIZE;
            float plainHeight = img.getPlainHeight() * IMAGE_SIZE;
            img.scaleAbsolute(plainWidth, plainHeight);//设置图片大小
            img.setAlignment(Image.UNDERLYING); // 在字下面
            //设置水印图片的坐标。
            img.setAbsolutePosition(pageWidth - plainWidth - 35, pageHeight - plainHeight - 5);
            //image.setRotation(-30);//设置旋转 弧度
            //image.setRotationDegrees(-45);//设置旋转 角度
            //image.scalePercent(50);//设置依照比例缩放，与设置大小作用相同

            //将水印图片加入到文档中,可使用循环添加多个，添加多个时注意每个图片的坐标等属性
            document.add(img);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("添加水印失败！");
        }
    }
}
