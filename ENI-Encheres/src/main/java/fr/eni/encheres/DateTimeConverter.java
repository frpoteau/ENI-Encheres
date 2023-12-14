package fr.eni.encheres;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Regroupe les méthodes de conversion pour Date et Time.
 */
public class DateTimeConverter {

	/**
	 * Permet la conversion d'une Date au format "yyyy-MM-dd".
	 * 
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static Date convertStringToDate(String dateStr) throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.FRENCH);
		java.util.Date parsedDate = dateFormat.parse(dateStr);
		Date sqlDate = new Date(parsedDate.getTime());

		return sqlDate;
	}

	/**
	 * Permet la conversion d'une heure (Time) au format "HH:mm".
	 * 
	 * @param heureStr
	 * @return
	 * @throws ParseException
	 */
	public static Time convertStringToTime(String heureStr) throws ParseException {

		SimpleDateFormat heureFormat = new SimpleDateFormat("HH:mm", Locale.FRENCH);
		java.util.Date parsedTime = heureFormat.parse(heureStr);
		Time sqlTime = new Time(parsedTime.getTime());

		return sqlTime;
	}

}
