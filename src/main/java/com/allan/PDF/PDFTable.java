package com.allan.PDF;

import lombok.Data;

import java.util.List;

@Data
public class PDFTable {
    private String title;//标题
    private int numColumns;
    private float widthPercent;
    private List<PDFColumn> columns;
    private float[] conWidths;
    private String textDescription;
    private String footnote;
}
