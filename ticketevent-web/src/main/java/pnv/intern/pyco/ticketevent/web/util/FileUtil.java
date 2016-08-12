package pnv.intern.pyco.ticketevent.web.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;

import pnv.intern.pyco.ticketevent.services.model.AccountModel;
import pnv.intern.pyco.ticketevent.services.model.EventModel;

public class FileUtil {
	
	public static void saveImageOnServerBase64(String base64Img, String filePath) {
		byte[] data = Base64.getDecoder().decode(base64Img);
		
		try (
			OutputStream stream = new FileOutputStream(filePath)) {
		    stream.write(data);
		} catch (IOException e) {
		}
	}
	
	public static String createPath(String path) {
		Path pathCreate = Paths.get(path);
        try {
            Files.createDirectories(pathCreate);
        } catch (IOException e) {
        }
        return path.toString().replace("\\", "/") + "/";
	}
	
	public static String getRealPathUploadProfile(String filePath, String nameFile) {
		Path path = Paths.get(filePath);
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
        }
        String fileName = (String) nameFile.subSequence(nameFile.lastIndexOf("\\")+1, nameFile.length());
        return path.toString().replace("\\", "/") + "/" + fileName;
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
	
	public static String getFileNameFromRealPath(String realPath){
		String filePath = (String) realPath.subSequence(realPath.lastIndexOf("/")+1, realPath.length());
		return filePath;
	}

	public static String saveImageEvent(String base64, AccountModel account, EventModel eventModel, String fileName, HttpServletRequest request) {
		if (base64 == null || base64.isEmpty() || base64.split(",").length != 2) {
			return null;
		}
		String base64ImageThumbnail = base64.split(",")[1];
		String filePath = request.getServletContext().getRealPath("/resources/");
		String accountEncryption = EncryptionUtil.encodeId(account.getId());
		String eventEncryption = EncryptionUtil.encodeId(eventModel.getId());
		String expectPath = filePath + "/images/accounts/" + accountEncryption + "/events/" + eventEncryption;
		
        String fullPath = FileUtil.createPath(expectPath) + "/" + fileName + eventEncryption + ".jpg";
		saveImageOnServerBase64(base64ImageThumbnail, fullPath);
		
		return "accounts/" + accountEncryption + "/events/" + eventEncryption + "/" + fileName + eventEncryption + ".jpg";
	}
	
	public static String saveImageEventFreeLayout(String base64, Long accountId, Long eventId, String fileName, HttpServletRequest request) {
		if (base64 == null || base64.isEmpty() || base64.split(",").length != 2) {
			return null;
		}
		if (fileName.contains(".")) {
			fileName = FilenameUtils.removeExtension(fileName);
		}
		String base64ImageThumbnail = base64.split(",")[1];
		String filePath = request.getServletContext().getRealPath("/resources/");
		String accountEncryption = EncryptionUtil.encodeId(accountId);
		String eventEncryption = EncryptionUtil.encodeId(eventId);
		String expectPath = filePath + "/images/accounts/" + accountEncryption + "/events/" + eventEncryption + "/freelayout";
		
        String fullPath = FileUtil.createPath(expectPath) + "/" + fileName + eventEncryption + ".jpg";
        File f = new File(fullPath);
        if(f.exists() && !f.isDirectory()) { 
        	return null;
        }
        long fileCount = 0;
        Path path = Paths.get(expectPath);
        try {
			fileCount = Files.list(Paths.get(path.toString())).count();
		} catch (IOException e) {}
        if (fileCount > 20) {
			return null;
		}
		saveImageOnServerBase64(base64ImageThumbnail, fullPath);
		
		return "accounts/" + accountEncryption + "/events/" + eventEncryption + "/freelayout/" + fileName + eventEncryption + ".jpg";
	}
	
	public static String saveImageEventActivityLayout(String base64, Long accountId, Long eventId, String fileName, HttpServletRequest request) {
		if (base64 == null || base64.isEmpty() || base64.split(",").length != 2 || (!fileName.equals("background") && !fileName.equals("logo"))) {
			return null;
		}
		String base64ImageThumbnail = base64.split(",")[1];
		String filePath = request.getServletContext().getRealPath("/resources/");
		String accountEncryption = EncryptionUtil.encodeId(accountId);
		String eventEncryption = EncryptionUtil.encodeId(eventId);
		String expectPath = filePath + "/images/accounts/" + accountEncryption + "/events/" + eventEncryption + "/activity";
		
        String fullPath = FileUtil.createPath(expectPath) + "/" + fileName + eventEncryption + ".jpg";
        long fileCount = 0;
        Path path = Paths.get(expectPath);
        try {
			fileCount = Files.list(Paths.get(path.toString())).count();
		} catch (IOException e) {}
        if (fileCount > 20) {
			return null;
		}
		saveImageOnServerBase64(base64ImageThumbnail, fullPath);
		
		return "accounts/" + accountEncryption + "/events/" + eventEncryption + "/activity/" + fileName + eventEncryption + ".jpg";
	}
	
	public static String saveLibImageEventActivityLayout(String base64, Long accountId, Long eventId, String fileName, HttpServletRequest request) {
		if (base64 == null || base64.isEmpty() || base64.split(",").length != 2) {
			return null;
		}
		if (fileName.contains(".")) {
			fileName = FilenameUtils.removeExtension(fileName);
		}
		String base64ImageThumbnail = base64.split(",")[1];
		String filePath = request.getServletContext().getRealPath("/resources/");
		String accountEncryption = EncryptionUtil.encodeId(accountId);
		String eventEncryption = EncryptionUtil.encodeId(eventId);
		String expectPath = filePath + "/images/accounts/" + accountEncryption + "/events/" + eventEncryption + "/activity/libImage";
		
        String fullPath = FileUtil.createPath(expectPath) + "/" + fileName + eventEncryption + ".jpg";
        File f = new File(fullPath);
        if(f.exists() && !f.isDirectory()) { 
        	return null;
        }
        long fileCount = 0;
        Path path = Paths.get(expectPath);
        try {
			fileCount = Files.list(Paths.get(path.toString())).count();
		} catch (IOException e) {}
        if (fileCount > 20) {
			return null;
		}
		saveImageOnServerBase64(base64ImageThumbnail, fullPath);
		
		return "accounts/" + accountEncryption + "/events/" + eventEncryption + "/activity/libImage/" + fileName + eventEncryption + ".jpg";
	}
	
	public static String saveImageEventMusicLayout(String base64, Long accountId, Long eventId, String fileName, HttpServletRequest request) {
		if (base64 == null || base64.isEmpty() || base64.split(",").length != 2 || (!fileName.equals("banner") && !fileName.equals("place"))) {
			return null;
		}
		String base64ImageThumbnail = base64.split(",")[1];
		String filePath = request.getServletContext().getRealPath("/resources/");
		String accountEncryption = EncryptionUtil.encodeId(accountId);
		String eventEncryption = EncryptionUtil.encodeId(eventId);
		String expectPath = filePath + "/images/accounts/" + accountEncryption + "/events/" + eventEncryption + "/music";
		
        String fullPath = FileUtil.createPath(expectPath) + "/" + fileName + eventEncryption + ".jpg";
        long fileCount = 0;
        Path path = Paths.get(expectPath);
        try {
			fileCount = Files.list(Paths.get(path.toString())).count();
		} catch (IOException e) {}
        if (fileCount > 20) {
			return null;
		}
		saveImageOnServerBase64(base64ImageThumbnail, fullPath);
		
		return "accounts/" + accountEncryption + "/events/" + eventEncryption + "/music/" + fileName + eventEncryption + ".jpg";
	}
	
	public static String saveLibImageEventMusicLayout(String base64, Long accountId, Long eventId, String fileName, HttpServletRequest request) {
		if (base64 == null || base64.isEmpty() || base64.split(",").length != 2) {
			return null;
		}
		if (fileName.contains(".")) {
			fileName = FilenameUtils.removeExtension(fileName);
		}
		String base64ImageThumbnail = base64.split(",")[1];
		String filePath = request.getServletContext().getRealPath("/resources/");
		String accountEncryption = EncryptionUtil.encodeId(accountId);
		String eventEncryption = EncryptionUtil.encodeId(eventId);
		String expectPath = filePath + "/images/accounts/" + accountEncryption + "/events/" + eventEncryption + "/music/libImage";
		
        String fullPath = FileUtil.createPath(expectPath) + "/" + fileName + eventEncryption + ".jpg";
        File f = new File(fullPath);
        if(f.exists() && !f.isDirectory()) { 
        	return null;
        }
        long fileCount = 0;
        Path path = Paths.get(expectPath);
        try {
			fileCount = Files.list(Paths.get(path.toString())).count();
		} catch (IOException e) {}
        if (fileCount > 20) {
			return null;
		}
		saveImageOnServerBase64(base64ImageThumbnail, fullPath);
		
		return "accounts/" + accountEncryption + "/events/" + eventEncryption + "/music/libImage/" + fileName + eventEncryption + ".jpg";
	}
	
	public static String saveImageFamousPersonMusicLayout(String base64, Long accountId, Long eventId, Long famousPersonId, HttpServletRequest request) {
		if (base64 == null || base64.isEmpty() || base64.split(",").length != 2) {
			return null;
		}
		
		String base64ImageThumbnail = base64.split(",")[1];
		String filePath = request.getServletContext().getRealPath("/resources/");
		String accountEncryption = EncryptionUtil.encodeId(accountId);
		String eventEncryption = EncryptionUtil.encodeId(eventId);
		String famousPersonEncryption = EncryptionUtil.encodeId(famousPersonId);
		String expectPath = filePath + "/images/accounts/" + accountEncryption + "/events/" + eventEncryption + "/music/famousPerson";
		
        String fullPath = FileUtil.createPath(expectPath) + "/" + famousPersonEncryption + ".jpg";
        File f = new File(fullPath);
        if(f.exists() && !f.isDirectory()) { 
        	return null;
        }
        long fileCount = 0;
        Path path = Paths.get(expectPath);
        try {
			fileCount = Files.list(Paths.get(path.toString())).count();
		} catch (IOException e) {}
        if (fileCount > 20) {
			return null;
		}
		saveImageOnServerBase64(base64ImageThumbnail, fullPath);
		
		return "accounts/" + accountEncryption + "/events/" + eventEncryption + "/music/famousPerson/" + famousPersonEncryption + ".jpg";
	}
	
	public static String saveImageEventCourseLayout(String base64, Long accountId, Long eventId, String fileName, HttpServletRequest request) {
		if (base64 == null || base64.isEmpty() || base64.split(",").length != 2 || (!fileName.equals("banner") && !fileName.equals("place"))) {
			return null;
		}
		String base64ImageThumbnail = base64.split(",")[1];
		String filePath = request.getServletContext().getRealPath("/resources/");
		String accountEncryption = EncryptionUtil.encodeId(accountId);
		String eventEncryption = EncryptionUtil.encodeId(eventId);
		String expectPath = filePath + "/images/accounts/" + accountEncryption + "/events/" + eventEncryption + "/course";
		
        String fullPath = FileUtil.createPath(expectPath) + "/" + fileName + eventEncryption + ".jpg";
        long fileCount = 0;
        Path path = Paths.get(expectPath);
        try {
			fileCount = Files.list(Paths.get(path.toString())).count();
		} catch (IOException e) {}
        if (fileCount > 20) {
			return null;
		}
		saveImageOnServerBase64(base64ImageThumbnail, fullPath);
		
		return "accounts/" + accountEncryption + "/events/" + eventEncryption + "/course/" + fileName + eventEncryption + ".jpg";
	}

	public static String saveImageSpeakerCourseLayout(String base64, Long accountId, Long eventId, Long speakerId, HttpServletRequest request) {
		if (base64 == null || base64.isEmpty() || base64.split(",").length != 2) {
			return null;
		}
		
		String base64ImageThumbnail = base64.split(",")[1];
		String filePath = request.getServletContext().getRealPath("/resources/");
		String accountEncryption = EncryptionUtil.encodeId(accountId);
		String eventEncryption = EncryptionUtil.encodeId(eventId);
		String speakerEncryption = EncryptionUtil.encodeId(speakerId);
		String expectPath = filePath + "/images/accounts/" + accountEncryption + "/events/" + eventEncryption + "/course/speaker";
		
        String fullPath = FileUtil.createPath(expectPath) + "/" + speakerEncryption + ".jpg";
        File f = new File(fullPath);
        if(f.exists() && !f.isDirectory()) { 
        	return null;
        }
        long fileCount = 0;
        Path path = Paths.get(expectPath);
        try {
			fileCount = Files.list(Paths.get(path.toString())).count();
		} catch (IOException e) {}
        if (fileCount > 20) {
			return null;
		}
		saveImageOnServerBase64(base64ImageThumbnail, fullPath);
		
		return "accounts/" + accountEncryption + "/events/" + eventEncryption + "/course/speaker/" + speakerEncryption + ".jpg";
	}
	public static boolean deleteFileUrlAfterImagesFolder(String urlAfterImagesFolderContainFileName, HttpServletRequest request) {
		String filePath = request.getServletContext().getRealPath("/resources/images");
		String fullPath = filePath + "/" + urlAfterImagesFolderContainFileName;
		File file = new File(fullPath);
    	
		if(file.delete()){
			return true;
		}else{
			return false;
		}
	}
	
	public static String convertImageToBase64(String fullPath) {
		String base64String = null;
		File file = new File(fullPath);

        try {
            FileInputStream imageInFile = new FileInputStream(file);
            byte[] imageData = new byte[(int) file.length()];
            imageInFile.read(imageData);
            imageInFile.close();

    		StringBuilder sb = new StringBuilder();
    		sb.append("data:image/jpeg;base64,");
    		sb.append(Base64.getEncoder().encodeToString(imageData));
    		base64String = sb.toString();
        } catch (FileNotFoundException e) {
        } catch (IOException ioe) {
        }
		return base64String;
	}
}
