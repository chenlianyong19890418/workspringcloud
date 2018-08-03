package com.dlsmartercity.annualaccount.util;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang.CharRange;
import org.apache.commons.lang.CharSet;
import org.w3c.dom.Document;

public abstract class StringUtils {

	/**
	 * 许可的文件名
	 */
	private static CharSet allowedFileName = CharSet.getInstance("!#$%&'()+,.;=@[]_`{}~ 0-9a-zA-Z-^");

	/**
	 * 许可的mail地址
	 */
	private static CharSet allowedMailAddress = CharSet.getInstance(".@_0-9a-zA-Z-");

	/**
	 * 许可的密码
	 */
	private static CharSet allowedPassword = CharSet.getInstance("`~!@#$%^&*()-_+=|\\{}\\[\\]'\":;,.<>/?0-9a-zA-Z-");

	/**
	 * ASCII 文字（英数字）
	 */
	private static CharSet alphaNumChar = CharSet.getInstance("0-9A-Za-z");

	/**
	 * ASCII 文字（数字）
	 */
	private static CharRange digit = new CharRange('\u0030', '\u0039');
	/**
	 * 汉字
	 */
	private static CharRange simplified = new CharRange('\u4e00', '\u9fa5');

	private static String[] chars = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
			"w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
			"P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

	private static final String CHARSET_NAME = "UTF-8";

	private StringUtils() {
	}

	/**
	 * 字符串是数字的判定方法。
	 *
	 * @param str
	 *            字符串
	 * @return 数字 0-9 true
	 */
	public static boolean isDigit(String str) {
		boolean isdigit = false;
		if (StringUtils.isEmpty(str)) {
			return isdigit;
		}
		isdigit = true;
		char[] cs = str.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			if (!digit.contains(cs[i])) {
				isdigit = false;
			}
		}
		return isdigit;
	}

	/** 
	* @Title: isNum 
	* @Description: 字符串是否是数字
	* @param str
	* @return    设定文件 
	* @return boolean    返回类型 
	*/
	public static boolean isNum(String str) {
		if (StringUtils.isEmpty(str)) {
			return false;
		}
		BigDecimal bd = new BigDecimal(str);
		return new BigDecimal(bd.intValue()).compareTo(bd)==0;
	}
	
	/** 
	* @Title: getScale 
	* @Description: 取几位小数
	* @param str
	* @param num
	* @return    设定文件 
	* @return String    返回类型 
	*/
	public static String getScale(String str,int num) {
		if (StringUtils.isEmpty(str)) {
			return str;
		}
		BigDecimal bd = new BigDecimal(str);
		BigDecimal setScale = bd.setScale(num,BigDecimal.ROUND_DOWN);
		return setScale.toPlainString();
	}
	
	/**
	 * 字符串是数值(含小数)的判定方法。
	 *
	 * @param str
	 *            字符串
	 * @return 数值(含小数) true
	 */
	public static boolean isNumeric(String str) {
		if (StringUtils.isEmpty(str)) {
			return false;
		}
		Pattern p = Pattern.compile("^\\d+(\\.\\d+)?$");
		Matcher m = p.matcher(str);
		return m.find();
	}

	/**
	 * 字符串null或空文字判定方法。
	 *
	 * @param str
	 *            字符串
	 * @return true: 字符串null或空文字, false: 字符串不是null也不是空文字
	 */
	public static boolean isNull(String str) {
		return str == null || str.length() == 0;
	}

	public static boolean isBlank(String str) {
		return str == null || str.trim().length() == 0;
	}

	/**
	 * 字符串null或空文字或者全是空白判定方法。
	 *
	 * @param str
	 *            字符串
	 * @return true: 字符串null或空文字, false: 字符串不是null也不是空文字
	 */
	public static boolean isEmpty(String str) {
		return isNull(str) || trim(str).length() == 0;
	}

	/**
	 * 字符串是中文(不包括中文符号)的判定方法。
	 *
	 * @param str
	 *            字符串
	 * @return 中文(不包括中文符号) true
	 */
	public static boolean isSimplified(String str) {
		boolean isSimplified = false;
		if (StringUtils.isEmpty(str)) {
			return isSimplified;
		}
		isSimplified = true;
		char[] cs = str.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			if (!simplified.contains(cs[i])) {
				isSimplified = false;
			}
		}
		return isSimplified;
	}

	/**
	 * 文件名是否许可的检查。
	 *
	 * @param fileName
	 *            文件名
	 * @return 许可 true
	 */
	public static boolean isAllowedFileName(String fileName) {
		if (StringUtils.isEmpty(fileName)) {
			return false;
		}
		boolean allowed = true;
		char[] cs = fileName.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			if (!allowedFileName.contains(cs[i])) {
				allowed = false;
				break;
			}
		}
		if (allowed && isVistaData(fileName)) {
			allowed = false;
		}
		return allowed;
	}

	/**
	 * mail地址是否许可的检查。
	 *
	 * @param mailAddress
	 *            mail地址
	 * @return 许可 true
	 */
	public static boolean isAllowedMailAddress(String mailAddress) {
		if (StringUtils.isEmpty(mailAddress)) {
			return false;
		}
		boolean allowed = true;
		char[] cs = mailAddress.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			if (!allowedMailAddress.contains(cs[i])) {
				allowed = false;
				break;
			}
		}
		return allowed;
	}

	/**
	 * 字符串是英数字的判定方法。
	 *
	 * @param str
	 *            字符串
	 * @return 英数字 true
	 */
	public static boolean isAsciiAlphaNumCharOnly(String str) {
		boolean asciiOnly = true;
		if (StringUtils.isEmpty(str)) {
			return asciiOnly;
		}
		char[] cs = str.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			if (!alphaNumChar.contains(cs[i])) {
				asciiOnly = false;
			}
		}
		return asciiOnly;
	}

	/**
	 * 从Windows Vista被POST数据中含有的文字列是否存在的检查方法。
	 *
	 * @param str
	 *            文字列
	 * @return 存在 true,不存在 false
	 */
	public static boolean isVistaData(String str) {
		Pattern p = Pattern.compile(".*&#\\d+?;.*");
		Matcher m = p.matcher(str);
		return m.find();
	}

	/**
	 * 从Windows Vista被POST数据中含有的文字列是否存在的检查方法。
	 *
	 * @param str
	 *            文字列
	 * @return 通过true,未通过 false
	 */
	public static boolean isBankCard(String str) {
		if (StringUtils.isEmpty(str)) {
			return false;
		}
		if (!StringUtils.isNumeric(str)) {
			return false;
		}
		if (str.length() >= 15 && str.length() < 20) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 字符串前后空格（全角，半角）的trim
	 *
	 * @param orgstr
	 *            文字列
	 * @return trim后的文字列
	 */
	public static String trim(String orgstr) {
		return org.apache.commons.lang.StringUtils.trimToEmpty(orgstr);
	}

	public static int toInt(String str, int defaultVal) {
		int ret = defaultVal;
		try {
			ret = Integer.parseInt(str);
		} catch (NumberFormatException e) {
		}
		return ret;
	}

	public static long toLong(String str, long defaultVal) {
		long ret = defaultVal;
		try {
			ret = Long.parseLong(str);
		} catch (NumberFormatException e) {
		}
		return ret;
	}

	public static String fill(String str, int count) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; ++i) {
			sb.append(str);
		}
		return sb.toString();
	}

	public static String toHexString(byte[] data) {
		return Hex.encodeHexString(data);
	}

	public static byte[] toHex(String hexString) {
		try {
			return Hex.decodeHex(hexString.toCharArray());
		} catch (DecoderException e) {
			e.printStackTrace();
		}
		return new byte[0];
	}

	/**
	 * 对参数的字符串进行 native2ascii 处理的方法。<br>
	 * 第二个参数设置 null的话、使用系统属性 file.encoding设定。
	 *
	 * @param str
	 *            变换的字符串
	 * @param encoding
	 *            字符编码
	 * @return native2ascii 字符串
	 * @throws UnsupportedEncodingException
	 *             指定不受支持的字符编码
	 */
	public static String native2Ascii(String str) {
		StringBuffer buf = new StringBuffer(str.length() * 6);
		char[] carray = str.toCharArray();
		for (int i = 0; i < carray.length; i++) {
			if (carray[i] > '\u007f') {
				buf.append("\\u");
				String hex4 = Integer.toHexString((int) carray[i]);
				if (hex4.length() == 3) {
					hex4 = "0" + hex4;
				} else if (hex4.length() == 2) {
					hex4 = "00" + hex4;
				} else if (hex4.length() == 1) {
					hex4 = "000" + hex4;
				}
				buf.append(hex4);
			} else {
				buf.append(carray[i]);
			}
		}
		return buf.toString();
	}

	/**
	 * 通过传递指定的编码返回转换后的 Unicode 转义字符串的方法。
	 *
	 * @param str
	 *            转义的 Unicode ASCII 字符串
	 * @param encoding
	 *            字符编码
	 * @return ascii 变换的字符串
	 * @throws UnsupportedEncodingException
	 *             指定不受支持的字符编码
	 */
	public static String ascii2Native(String str, String encoding) {
		String sysEnc = System.getProperty("file.encoding");
		if (encoding == null) {
			encoding = sysEnc;
		}
		System.setProperty("file.encoding", encoding);

		StringBuffer buf = new StringBuffer();
		char[] carray = str.toCharArray();
		for (int i = 0; i < carray.length; i++) {
			// 字符串是 \u9999 格式的情况
			if (carray[i] == '\\' && i + 1 < carray.length && carray[i + 1] == 'u' && i + 5 < carray.length
					&& "0123456789abcdefABCDEF".indexOf(carray[i + 2]) > -1 && "0123456789abcdefABCDEF".indexOf(carray[i + 3]) > -1
					&& "0123456789abcdefABCDEF".indexOf(carray[i + 4]) > -1 && "0123456789abcdefABCDEF".indexOf(carray[i + 5]) > -1) {
				StringBuffer hex4 = new StringBuffer(4);
				for (int k = i + 2; k < i + 6; k++) {
					hex4.append(carray[k]);
				}
				buf.append((char) Integer.parseInt(hex4.toString(), 16));
				i = i + 5;
			} else {
				buf.append(carray[i]);
			}
		}

		System.setProperty("file.encoding", sysEnc);
		return buf.toString();
	}

	/**
	 * 取得UUID。
	 *
	 * @return UUID
	 */
	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replace("-", "");
	}

	/**
	 * 取得UUID。
	 *
	 * @return UUID
	 */
	public static String getUUID8() {
		StringBuffer shortBuffer = new StringBuffer();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		for (int i = 0; i < 8; i++) {
			String str = uuid.substring(i * 4, i * 4 + 4);
			int x = Integer.parseInt(str, 16);
			shortBuffer.append(chars[x % 0x3E]);
		}
		return shortBuffer.toString();
	}

	/**
	 * 密码是否许可的检查。
	 *
	 * @param password
	 *            密码
	 * @return 许可 true
	 */
	public static boolean isAllowedPassword(String password) {
		if (StringUtils.isEmpty(password)) {
			return false;
		}
		boolean allowed = true;
		char[] cs = password.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			if (!allowedPassword.contains(cs[i])) {
				allowed = false;
				break;
			}
		}
		return allowed;
	}

	public static boolean isLoginId(String str) {
		String regex = "^[a-zA-z][a-zA-Z0-9_]{3,15}$";
		return match(regex, str);
	}

	public static boolean isMobileNum(String str) {
		String regex = "^13[0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|17[0-9]{9}$|18[0-9]{9}$";
		return match(regex, str);
	}

	public static boolean isPasswordStrength(String str) {
		String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)(?![`~!@#$%^&*()_+=\\\\|{}\\[\\]'\":;,.<>/?-]+$)[`~!@#$%^&*()_+=\\\\|{}\\[\\]'\":;,.<>/?0-9a-zA-Z-]{6,20}$";
		return match(regex, str);
	}

	public static boolean isTelNum(String str) {
		String regex = "\\d{3,5}-\\d{7,8}(-\\d{1,})?$";
		return match(regex, str);
	}

	public static boolean isUrl(String str) {
		String regex = "^(\\w+:\\/\\/)?\\w+(\\.\\w+)+.*$";
		return match(regex, str);
	}

	public static boolean isMoney(String str) {
		String regex = "^[0-9]+(.[0-9]{1,2})?$";
		return match(regex, str);
	}

	public static boolean isAnnualRate(String str) {
		// String regex = "^[1-9][0-9]?(\\.\\d)?$";
		// String regex = "^[1-9][0-9]?([.]{1}[0-9]{1,2}){0,1}$";
		// String regex = "^[1-9]?[0-9]{1}([.]{1}[0-9]{1,2}){0,1}$";
		String regex = "^([1-9]\\d{0,1})$|^(0|[1-9]\\d{0,1})\\.(\\d{1,2})$|^0$|^100$";
		return match(regex, str);
	}

	public static boolean isPermillage(String str) {
		// String regex = "^[1-9][0-9]?(\\.\\d)?$";
		// String regex = "^[1-9][0-9]?([.]{1}[0-9]{1,2}){0,1}$";
		String regex = "^([1-9]\\d{0,2})$|^(0|[1-9]\\d{0,2})\\.(\\d{1,2})$|^0$|^1000$";
		return match(regex, str);
	}

	public static boolean isSettingNum(String str) {
		String regex = "^([1-9]\\d*)$|^(0|[1-9]\\d*)\\.(\\d{1,2})$|^0$";
		return match(regex, str);
	}

	public static boolean isEmail(String str) {
		String regex = "^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
		return match(regex, str);
	}

	/**
	 * 检查充值金额是否正确的方法。<br />
	 * 充值的金额，100的倍数，不大于10,000,000。
	 *
	 * @param str
	 *            要验证的字符串
	 * @return 正确返回true，否则返回false
	 */
	public static boolean isRechargeAmount(String str) {
		String regex = "^(\\d{1,5}|100000)0{2}$";
		return match(regex, str);
	}

	/**
	 * 功能：判断字符串是否为日期格式
	 *
	 * @param str
	 * @return
	 */
	public static boolean isDate(String strDate) {
		Pattern pattern = Pattern.compile(
				"^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
		Matcher m = pattern.matcher(strDate);
		if (m.matches()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断邮政编码是否有效
	 * 
	 * @param postcode
	 *            邮政编码
	 * @return
	 */
	public static boolean isPostcode(String postcode) {
		String regex = "\\d{6}";
		return match(regex, postcode);
	}

	/**
	 * 判断IP地址是否有效
	 * 
	 * @param ip
	 *            IP地址
	 * @return
	 */
	public static boolean isIP(String ip) {
		String regex = "([1-9]|[1-9][0-9]|1\\d\\d|2[0-4]\\d|25[0-5])\\." + "([1-9]|[1-9][0-9]|1\\d\\d|2[0-4]\\d|25[0-5])\\."
				+ "([1-9]|[1-9][0-9]|1\\d\\d|2[0-4]\\d|25[0-5])\\." + "([1-9]|[1-9][0-9]|1\\d\\d|2[0-4]\\d|25[0-5])";
		return match(regex, ip);
	}

	/**
	 * @param regex
	 *            正则表达式字符串
	 * @param str
	 *            要匹配的字符串
	 * @return 如果str 符合 regex的正则表达式格式,返回true, 否则返回 false;
	 */
	public static boolean match(String regex, String str) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	/**
	 * 生成随机登录密码（默认8位长度）
	 * 
	 * @return 登录密码的字符串
	 */
	public static String genUserPassword() {
		return genRandomNum(8);
	}

	/**
	 * 生成随机支付密码（默认8位长度）
	 * 
	 * @return 支付密码的字符串
	 */
	public static String genPaymentPassword() {
		return genRandomNum(8);
	}

	/**
	 * 生成随机密码
	 * 
	 * @param pwdLen
	 *            生成的密码的总长度
	 * @return 密码的字符串
	 */
	public static String genRandomNum(int pwdLen) {
		// 35是因为数组是从0开始的，26个字母+10个 数字
		final int maxNum = 36;
		int i; // 生成的随机数
		int count = 0; // 生成的密码的长度
		char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0',
				'1', '2', '3', '4', '5', '6', '7', '8', '9' };

		StringBuffer pwd = new StringBuffer("");
		Random r = new Random();
		while (count < pwdLen) {
			// 生成随机数，取绝对值，防止 生成负数，
			i = Math.abs(r.nextInt(maxNum)); // 生成的数最大为36-1
			if (i >= 0 && i < str.length) {
				if (i % 2 == 0) {
					pwd.append(Character.toUpperCase(str[i]));
				} else {
					pwd.append(str[i]);
				}
				count++;
			}
		}

		return pwd.toString();
	}

	/**
	 * 功能：身份证的有效验证
	 *
	 * @param IDStr
	 *            身份证号
	 * @return 有效：返回"" 无效：返回String信息
	 * @throws ParseException
	 */
	public static boolean isIdCard(String IDStr) {
		String[] ValCodeArr = { "1", "0", "x", "9", "8", "7", "6", "5", "4", "3", "2" };
		String[] Wi = { "7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7", "9", "10", "5", "8", "4", "2" };
		String Ai = "";
		try {
			// ================ 号码的长度 15位或18位 ================
			if (IDStr.length() != 15 && IDStr.length() != 18) {
				return false;
			}
			// =======================(end)========================

			// ================ 数字 除最后以为都为数字 ================
			if (IDStr.length() == 18) {
				Ai = IDStr.substring(0, 17);
			} else if (IDStr.length() == 15) {
				Ai = IDStr.substring(0, 6) + "19" + IDStr.substring(6, 15);
			}
			// 身份证15位号码都应为数字 ; 18位号码除最后一位外，都应为数字。
			if (isAsciiAlphaNumCharOnly(Ai) == false) {
				return false;
			}
			// =======================(end)========================

			// ================ 出生年月是否有效 ================
			String strYear = Ai.substring(6, 10);// 年份
			String strMonth = Ai.substring(10, 12);// 月份
			String strDay = Ai.substring(12, 14);// 月份
			if (isDate(strYear + "-" + strMonth + "-" + strDay) == false) {
				// 身份证生日无效
				return false;
			}
			GregorianCalendar gc = new GregorianCalendar();
			SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");

			if ((gc.get(Calendar.YEAR) - Integer.parseInt(strYear)) > 150
					|| (gc.getTime().getTime() - s.parse(strYear + "-" + strMonth + "-" + strDay).getTime()) < 0) {
				// 身份证生日不在有效范围。
				return false;
			}

			if (Integer.parseInt(strMonth) > 12 || Integer.parseInt(strMonth) == 0) {
				// 身份证月份无效
				return false;
			}
			if (Integer.parseInt(strDay) > 31 || Integer.parseInt(strDay) == 0) {
				// 身份证日期无效
				return false;
			}
			// =====================(end)=====================

			// ================ 地区码时候有效 ================
			Hashtable<String, String> h = getAreaCode();
			if (h.get(Ai.substring(0, 2)) == null) {
				// 身份证地区编码错误。
				return false;
			}
			// ==============================================

			// ================ 判断最后一位的值 ================
			int TotalmulAiWi = 0;
			for (int i = 0; i < 17; i++) {
				TotalmulAiWi = TotalmulAiWi + Integer.parseInt(String.valueOf(Ai.charAt(i))) * Integer.parseInt(Wi[i]);
			}
			int modValue = TotalmulAiWi % 11;
			String strVerifyCode = ValCodeArr[modValue];
			Ai = Ai + strVerifyCode;

			if (IDStr.length() == 18) {
				if (Ai.equals(IDStr.toLowerCase()) == false) {
					// 身份证无效，不是合法的身份证号码
					return false;
				}
			}
		} catch (NumberFormatException e) {
			return false;
		} catch (ParseException e) {
			return false;
		}
		// =====================(end)=====================
		return true;
	}

	/**
	 * 功能：设置地区编码
	 *
	 * @return Hashtable 对象
	 */
	private static Hashtable<String, String> getAreaCode() {
		Hashtable<String, String> hashtable = new Hashtable<>();
		hashtable.put("11", "北京");
		hashtable.put("12", "天津");
		hashtable.put("13", "河北");
		hashtable.put("14", "山西");
		hashtable.put("15", "内蒙古");
		hashtable.put("21", "辽宁");
		hashtable.put("22", "吉林");
		hashtable.put("23", "黑龙江");
		hashtable.put("31", "上海");
		hashtable.put("32", "江苏");
		hashtable.put("33", "浙江");
		hashtable.put("34", "安徽");
		hashtable.put("35", "福建");
		hashtable.put("36", "江西");
		hashtable.put("37", "山东");
		hashtable.put("41", "河南");
		hashtable.put("42", "湖北");
		hashtable.put("43", "湖南");
		hashtable.put("44", "广东");
		hashtable.put("45", "广西");
		hashtable.put("46", "海南");
		hashtable.put("50", "重庆");
		hashtable.put("51", "四川");
		hashtable.put("52", "贵州");
		hashtable.put("53", "云南");
		hashtable.put("54", "西藏");
		hashtable.put("61", "陕西");
		hashtable.put("62", "甘肃");
		hashtable.put("63", "青海");
		hashtable.put("64", "宁夏");
		hashtable.put("65", "新疆");
		hashtable.put("71", "台湾");
		hashtable.put("81", "香港");
		hashtable.put("82", "澳门");
		hashtable.put("91", "国外");
		return hashtable;
	}

	/**
	 * 将Document内容 写入XML字符串并返回
	 * 
	 * @param doc
	 * @param encoding
	 * @return
	 */
	public static String callWriteXmlString(Document doc, String encoding) {

		try {
			Source source = new DOMSource(doc);
			ByteArrayOutputStream outStream = new ByteArrayOutputStream();
			OutputStreamWriter write = new OutputStreamWriter(outStream);
			Result result = new StreamResult(write);

			Transformer xformer = TransformerFactory.newInstance().newTransformer();
			xformer.setOutputProperty(OutputKeys.ENCODING, encoding);

			xformer.transform(source, result);
			return outStream.toString();

		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
			return null;
		} catch (TransformerException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 生产请求流水号的方法。
	 *
	 * @return 请求流水号
	 */
	public static String createRequestNo() {
		String nano = String.valueOf(System.nanoTime());
		return DateUtils.getTimeStamp() + nano.substring(nano.length() - 7);
	}

	/**
	 * 字符串截取固定Byte。
	 *
	 * @return 截取后字符串
	 */
	public static String getSubString(String str, int length) {
		int count = 0;
		int offset = 0;
		char[] c = str.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] > 256) {
				offset = 2;
				count += 2;
			} else {
				offset = 1;
				count++;
			}
			if (count == length) {
				int countRemain = 0;
				for (int j = i + 1; j < c.length; j++) {
					if (c[i] > 256) {
						countRemain += 2;
					} else {
						countRemain++;
					}
				}
				if (countRemain <= 3) {
					return str;
				} else {
					return str.substring(0, i + 1) + "...";
				}
			}
			if ((count == length + 1 && offset == 2)) {
				int countRemain = 0;
				for (int j = i + 1; j < c.length; j++) {
					if (c[i] > 256) {
						countRemain += 2;
					} else {
						countRemain++;
					}
				}
				if (countRemain <= 3) {
					return str;
				} else {
					return str.substring(0, i) + "...";
				}
			}
		}
		return str;
	}

	/**
	 * 字符串替换。
	 *
	 * @return 替换后字符串
	 */
	public static String replaceStr(String strInput, String strBefore, String strAfter) {
		if (strInput == null || "".equals(strInput)) {
			return "";
		} else {
			return strInput.replace(strBefore, strAfter);
		}
	}

	/**
	 * 手机号中间4位用*显示。
	 *
	 * @return 替换后手机号
	 */
	public static String encryptMobile(String mobile) {
		if (mobile == null || "".equals(mobile)) {
			return "";
		} else {
			String ret = mobile.substring(0, 3);
			ret = ret + "****";
			ret = ret + mobile.substring(7, 11);
			return ret;
		}
	}

	public static String encryptEmail(String email) {
		if (email == null || "".equals(email)) {
			return "";
		} else {
			String ret = email.substring(0, 1);
			ret = ret + "****";
			ret = ret + email.substring(email.length() - 1);
			return ret;
		}
	}

	public static String encryptName(String name) {
		String str = trim(name);
		char[] arrays = str.toCharArray();
		for (int i = 1; i < arrays.length; i++) {
			arrays[i] = '*';
		}
		return String.valueOf(arrays);
	}

	public static String digitToChinese(int str) {
		switch (str) {
		case 1:
			return "一";
		case 2:
			return "二";
		case 3:
			return "三";
		case 4:
			return "四";
		case 5:
			return "五";
		case 6:
			return "六";
		case 7:
			return "七";
		case 8:
			return "八";
		case 9:
			return "九";
		case 10:
			return "十";
		}
		return "";
	}

	public static String getPeriodDisplayValue(String periodType) {
		String str = "";
		if (StringUtils.isEmpty(periodType)) {
			return str;
		}
		switch (periodType) {
		case "1":
			str = "个月";
			break;
		case "2":
			str = "个季度";
			break;
		case "3":
			str = "天";
			break;
		default:
			str = "个月";
			break;
		}
		return str;
	}

	public static String strToConceal(String userId) {
		String subUserId = "";
		if ("".equals(userId)) {
			return subUserId;
		}
		char[] charArray = userId.toCharArray();
		int len = charArray.length;
		if (len < 4) {
			subUserId = String.valueOf(charArray[0]) + "***";
		} else if (len < 5) {
			subUserId = String.valueOf(charArray[0]) + String.valueOf(charArray[1]) + "***" + String.valueOf(charArray[len - 2])
					+ String.valueOf(charArray[len - 1]);
		} else {
			subUserId = String.valueOf(charArray[0]) + String.valueOf(charArray[1]) + String.valueOf(charArray[2]) + "***" + String.valueOf(charArray[len - 2])
					+ String.valueOf(charArray[len - 1]);
		}
		return subUserId;
	}

	public static BigDecimal digitalDisplay(BigDecimal digital) {
		BigDecimal digitalDisp = new BigDecimal("0");
		if (digital.compareTo(new BigDecimal("0")) == 0) {
			return digital;
		}

		// 大于亿的场合,以亿为单位;大于万的以万为单位;否则以元为单位
		if (digital.compareTo(new BigDecimal("100000000")) >= 0) {
			digitalDisp = MathUtils.divide(digital, new BigDecimal("100000000")).setScale(2, BigDecimal.ROUND_HALF_EVEN);
		} else if (digital.compareTo(new BigDecimal("10000")) >= 0) {
			digitalDisp = MathUtils.divide(digital, new BigDecimal("10000")).setScale(2, BigDecimal.ROUND_HALF_EVEN);
		} else {
			digitalDisp = digital;
		}

		return digitalDisp;
	}

	public static String digitalUnitDisplay(BigDecimal digital) {
		String digitalStyleDisp = "元";
		if (digital.compareTo(new BigDecimal("0")) == 0) {
			return digitalStyleDisp;
		}

		// 大于亿的场合,以亿为单位;大于万的以万为单位;否则以元为单位
		if (digital.compareTo(new BigDecimal("100000000")) >= 0) {
			digitalStyleDisp = "亿";
		} else if (digital.compareTo(new BigDecimal("10000")) >= 0) {
			digitalStyleDisp = "万";
		} else {
			digitalStyleDisp = "元";
		}

		return digitalStyleDisp;
	}

	public static boolean isInArray(String[] arr, String val) {
		return Arrays.asList(arr).contains(val);
	}

	public static String getAppkey(String serverId) {
		return serverId + ":" + getUUID();
	}

	public static String getTokenId(String serverId) {
		return serverId + ":" + getUUID();
	}

	public static String[] split(String str, String separator) {
		return org.apache.commons.lang.StringUtils.splitByWholeSeparatorPreserveAllTokens(str, separator);
	}

	public static String getstr(String str) {
		// {}里面的数字可以用来指定前后缀的长度
		String regex = "(\\w{6})(.*)(\\w{4})";
		String result = "";
		Matcher m = Pattern.compile(regex).matcher(str);
		if (m.find()) {
			String rep = m.group(2);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < rep.length(); i++) {
				sb.append("*");
			}
			result = str.replaceAll(rep, sb.toString());
			System.out.println(str.replaceAll(rep, sb.toString()));
		}

		return result;
	}

	public static String substring(String str, int start) {
		return org.apache.commons.lang.StringUtils.substring(str, start);
	}

	public static String substring(String str, int start, int end) {
		return org.apache.commons.lang.StringUtils.substring(str, start, end);
	}

	public static String join(Object[] array) {
		return join(array, ",");
	}

	public static String join(Object[] array, String separator) {
		return org.apache.commons.lang.StringUtils.join(array, separator);
	}

	public static String join(Iterator<?> iterator) {
		return join(iterator, ",");
	}

	public static String join(Iterator<?> iterator, String separator) {
		return org.apache.commons.lang.StringUtils.join(iterator, separator);
	}

	public static String join(Collection<?> collection) {
		return join(collection, ",");
	}

	public static String join(Collection<?> collection, String separator) {
		return join(collection.iterator(), separator);
	}

	/**
	 * 比较版本号的大小,前者大则返回一个1,后者大返回一个-1,相等则返回0
	 * 
	 * @param version1
	 * @param version2
	 * @return
	 */
	public static int compareVersion(String version1, String version2) {
		if (version1 == null || version2 == null) {
			return 9;
		}
		String[] versionArray1 = version1.split("\\.");
		String[] versionArray2 = version2.split("\\.");
		int lengthArray1 = versionArray1.length;
		int lengthArray2 = versionArray2.length;
		int idx = 0;
		int minLength = Math.min(lengthArray1, lengthArray2);
		int diff = 0;
		while (idx < minLength && (diff = lengthArray1 - lengthArray2) == 0 && (diff = versionArray1[idx].compareTo(versionArray2[idx])) == 0) {
			++idx;
		}
		diff = (diff != 0) ? diff : lengthArray1 - lengthArray2;
		return diff == 0 ? 0 : (diff > 0 ? 1 : -1);
	}

	/**
	 * 转换为字节数组
	 * 
	 * @param str
	 * @return
	 */
	public static byte[] getBytes(String str) {
		if (str != null) {
			try {
				return str.getBytes(CHARSET_NAME);
			} catch (UnsupportedEncodingException e) {
				return null;
			}
		} else {
			return null;
		}
	}

	public static String getComma() {
		return ",";
	}
}
