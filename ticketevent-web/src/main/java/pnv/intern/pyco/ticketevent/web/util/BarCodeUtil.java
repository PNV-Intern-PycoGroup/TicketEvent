package pnv.intern.pyco.ticketevent.web.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import pnv.intern.pyco.ticketevent.services.model.TicketModel;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class BarCodeUtil {
	private static Md5PasswordEncoder md5Encode = new Md5PasswordEncoder();
	
	public static boolean saveImageBarCodeUrl(String barCode, int width, int height, String pathOutput) {
		String imageFormat = "png";
		BitMatrix bitMatrix;
		try {
			bitMatrix = new QRCodeWriter().encode(barCode, BarcodeFormat.QR_CODE, width, height);
			MatrixToImageWriter.writeToStream(bitMatrix, imageFormat, new FileOutputStream(new File(pathOutput)));
		} catch (WriterException | IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	// path: /barcode/event/{eventEncode}/ticket/{ticketName}{ticketEncode}.png
	public static boolean saveBarCodeTicket(TicketModel ticket, HttpServletRequest request) {
		String barCode = md5Encode.encodePassword(ticket.getId().toString(), NonDataConstantUtil.BARCODE_CREATE_TICKET);
		String ticketNameMd5Code = md5Encode.encodePassword(ticket.getName(), NonDataConstantUtil.BARCODE_CREATE_TICKET);
		String encodeTicket = EncryptionUtil.encodeId(ticket.getId());
		String encodeEvent = EncryptionUtil.encodeId(ticket.getEvent().getId());
		String pathOutput = request.getServletContext().getRealPath("/resources/images/") + "/barcode/event/" + encodeEvent + "/ticket/";
		String fullPath = FileUtil.createPath(pathOutput) + ticketNameMd5Code + encodeTicket + ".png";
		return saveImageBarCodeUrl(barCode, 200, 200, fullPath);
	}
}
