package pnv.intern.pyco.ticketevent.web.util;

public class EncryptionUtil {

	public static String encodeId(Long id) {
		int count = 2387;
		if (id % 2 == 0) {
			count *= 5;
		}
		String result = Long.toHexString(id * count);
		return result;
	}
	
	public static Long decodeId(String encode) {
		Long result = Long.parseLong(encode, 16);
		result /= 2387;
		if (result % 5 == 0 && result / 5 % 2 == 0) {
			result /= 5;
		}
		return result;
	}
}
