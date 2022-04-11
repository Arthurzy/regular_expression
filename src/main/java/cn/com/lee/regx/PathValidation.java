package cn.com.lee.regx;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class PathValidation 
{
	/**
	 * Is the path validated
	 * 
	 * @param path
	 * @return
	 */
	public static boolean isValidatePath(String path) {
		if(path==null) {
			return false;
		}
		String pattern = ".*0-all_data.*";
		return Pattern.matches(pattern, path) || isValidateDatePath(path, null) || isValidMailPath(path);
	}

	/**
	 * is the path an validated date path
	 * 
	 * @param path
	 * @param dateFormat
	 * @return
	 */
	private static boolean isValidateDatePath(String path, String dateFormat) {
		boolean isValidPath = true;
		if (dateFormat == null || "".equals(dateFormat)) {
			dateFormat = "yyyy-MM-dd";
		}
		String datePathPattern = ".*\\d{4}-\\d{2}-\\d{2}.*";
		String datePattern = "\\d{4}-\\d{2}-\\d{2}";
		if (Pattern.matches(datePathPattern, path)) {
			Pattern p = Pattern.compile(datePattern);
			Matcher m = p.matcher(path);
			if (m.find()) {

				String dateString = m.group(0);
				// If the date valid or not
				SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
				sdf.setLenient(false);
				try {
					Date d = sdf.parse(dateString);
					System.out.println(d);
					isValidPath = true;
				} catch (ParseException e) {
					System.out.println(e.getMessage());
					isValidPath = false;
				}
			}
		} else {
			isValidPath = false;
		}
		return isValidPath;
	}

	/**
	 * is the path an validated mail path
	 * 
	 * @param path
	 * @return
	 */
	private static boolean isValidMailPath(String path) {
		boolean isValidPath = true;
		String datePathPattern = ".*mail\\d{4}\\d{2}\\d{2}-\\d{6}.*";
		String datePattern = "\\d{4}\\d{2}\\d{2}-\\d{6}";
		if (Pattern.matches(datePathPattern, path)) {
			Pattern p = Pattern.compile(datePattern);
			Matcher m = p.matcher(path);
			if (m.find()) {

				String dateString = m.group(0);
				// If the date valid or not
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
				sdf.setLenient(false);
				try {
					sdf.parse(dateString);
//					System.out.println(d);
					isValidPath = true;
				} catch (ParseException e) {
					System.out.println(e.getMessage());
					isValidPath = false;
				}
			}
		} else {
			isValidPath = false;
		}
		return isValidPath;

	}
}
