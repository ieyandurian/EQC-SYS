package com.EQCSYS.app.datasourcetotext;

import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFManager {

	private PDFTextStripper pdfStripper;
	private PDDocument pdDoc;
	private String Text;
	private String filePath;

	public PDFManager() {

	}

	public String ToText() throws IOException {
		this.pdfStripper = null;
		this.pdDoc = null;
		pdDoc = PDDocument.load(new File(filePath));
		pdfStripper = new PDFTextStripper();
		pdDoc.getNumberOfPages();
		pdfStripper.setStartPage(1);
		pdfStripper.setEndPage(pdDoc.getNumberOfPages());
		try {
			Text = pdfStripper.getText(pdDoc);
		} finally {
			pdDoc.close();
		}
		return Text;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}