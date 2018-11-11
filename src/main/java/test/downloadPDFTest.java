package test;

import com.allan.Util.ExportPDFUtil;


/**
 * 导出PDF文件demo
 */
public class downloadPDFTest {

    /**
     * 导出PDF格式demo
     * @param args
     * @throws Exception
     */
    public static void main(String[] args)throws Exception {
        ExportPDFUtil.exportPDF("导出PDF测试", "导出PDF测试",40);
    }

}
