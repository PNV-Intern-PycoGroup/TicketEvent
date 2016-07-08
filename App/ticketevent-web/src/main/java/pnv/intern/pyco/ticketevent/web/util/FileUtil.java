package pnv.intern.pyco.ticketevent.web.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class FileUtil {
	public static void saveImageOndisk(String base64Img, String filePath) {
		byte[] data = Base64.getDecoder().decode(base64Img);
		
		try (
			OutputStream stream = new FileOutputStream(filePath)) {
		    stream.write(data);
		} catch (IOException e) {
		}
	}
	
	public static String getRealPath(String filePath) {
		long fileCount = 0;
		Path path = Paths.get(filePath);
        try {
            Files.createDirectories(path);
            fileCount = Files.list(Paths.get(path.toString())).count();
        } catch (IOException e) {
        }
        
        return path.toString().replace("\\", "/") + "/" + fileCount + ".jpg";
	}
}
