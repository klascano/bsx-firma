package com.besixplus.firmador;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;

import com.lowagie.text.Utilities;

import net.sf.jsignpdf.BasicSignerOptions;
import net.sf.jsignpdf.SignerLogic;

public class Firmar {

	private final static Logger LOGGER = Logger.getLogger(Firmar.class);

	public static void main(String[] args) {

		try {

			BasicSignerOptions tmpOpts = new BasicSignerOptions();

			if (args.length == 4) {

				PDDocument doc = PDDocument.load(new File(args[2]));
				int lp = doc.getNumberOfPages();

				tmpOpts.setInFile(args[2]);
				tmpOpts.setOutFile(args[3]);
				tmpOpts.setKsType("PKCS12");
				tmpOpts.setKsFile(args[0]);
				tmpOpts.setKsPasswd(args[1]);
				tmpOpts.setVisible(true);
				tmpOpts.setReason(
						"Documento firmado segun LEY DE COMERCIO ELECTRONICO, FIRMAS Y MENSAJES DE DATOS DEL ECUADOR https://tinyurl.com/29wed4es");
				tmpOpts.setPage(lp);

				// XY inicial
				tmpOpts.setPositionLLX(Utilities.millimetersToPoints(210f - 60f));
				tmpOpts.setPositionLLY(297f - 200f);

				// XY final
				tmpOpts.setPositionURX(tmpOpts.getPositionLLX() + Utilities.millimetersToPoints(60f));
				tmpOpts.setPositionURY(tmpOpts.getPositionLLY() + Utilities.millimetersToPoints(50f));

				SignerLogic tmpObj = new SignerLogic(tmpOpts);
				tmpObj.signFile();
			} else {
				System.out.println(
						"Ayuda bsx-firma ejemplo: bsx-firma c:\\firma.p12 miclave c:\\proforma.pdf c:\\proforma_firmada.pdf");
				System.out.println("param1 ruta firma .p12");
				System.out.println("param2 clave firma");
				System.out.println("param3 ruta archivo pdf");
				System.out.println("param4 ruta archivo pdf firmado");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
