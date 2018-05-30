/**
 * 
 */
package com.cwp.alice.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.cwp.alice.constants.GenericConstants;

/**
 * @author lugupta
 *
 */
@Component
public class DateUtil {

	private DateUtil() {
	}

	/**
	 * Get today date in String
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateInString(Date date) {
		return new SimpleDateFormat(GenericConstants.SDF_MM_DD_YYYY_HH_MM).format(date);
	}

	/**
	 * Get today date in String
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateInMMDDYYYYString(Date date) {
		return new SimpleDateFormat(GenericConstants.SDF_MM_DD_YYYY).format(date);
	}

	/**
	 * Get today day and date in String
	 * 
	 * @param date
	 * @return
	 */
	public static String getDayAndDateInString(Date date) {
		return new SimpleDateFormat(GenericConstants.SDF_E_MM_DD_YYYY).format(date);
	}

	/**
	 * Get any time in hh:mm a format (ex. 11:30 PM)
	 * 
	 * @return
	 */
	public static String getTimeInHHMMA() {
		return new SimpleDateFormat(GenericConstants.SDF_HH_MM_A).format(new Date(2018, 05, 14, 11, 30));
	}

}
