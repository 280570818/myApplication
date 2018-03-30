package swing.sys.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期处理工具
 * @author wang_xf
 */
public class DateUtil {

	public static final String DATE_FORMAT_NONE = "yyyyMMddHHmmss";
	public static final String DATE_FORMAT_NORML = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FORMAT_DATE = "yyyy-MM-dd";
	public static final String DATE_FORMAT_TIME = "HH:mm:ss";
	
	/**@return 20180330160755*/
	public static String getCurrentDateTimeNoChar(){
		return getDateStr(new Date(), DATE_FORMAT_NONE);
	}
	/**@return 2018-03-30 16:07:55*/
	public static String getCurrentDateTime(){
		return getDateStr(new Date(), DATE_FORMAT_NORML);
	}
	/**@return 2018-03-30*/
	public static String getCurrentDate(){
		return getDateStr(new Date(), DATE_FORMAT_DATE);
	}
	/**@return 16:07:55*/
	public static String getCurrentTime(){
		return getDateStr(new Date(), DATE_FORMAT_TIME);
	}
	/**@return 20180330160755*/
	public static String getDateTimeNoChar(Date date){
		return getDateStr(date, DATE_FORMAT_NONE);
	}
	/**@return 2018-03-30 16:07:55*/
	public static String getDateTime(Date date){
		return getDateStr(date, DATE_FORMAT_NORML);
	}
	/**@return 2018-03-30*/
	public static String getDate(Date date){
		return getDateStr(date, DATE_FORMAT_DATE);
	}
	/**@return 16:07:55*/
	public static String getTime(Date date){
		return getDateStr(date, DATE_FORMAT_TIME);
	}
	public static String getDateStr(Date date, String dateFormatStr){
		if(date == null || dateFormatStr == null)
			return null;
		return new SimpleDateFormat(dateFormatStr).format(date);
	}
	public static Date getDate(String DateStr, String dateFormatStr){
		if(BaseUtil.isNullOrEmpty(dateFormatStr) || BaseUtil.isNullOrEmpty(DateStr))
			return null;
		try {
			return new SimpleDateFormat(dateFormatStr).parse(DateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}
