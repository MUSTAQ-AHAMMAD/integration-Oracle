package innovate.tamergroup.fusion.soap.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class MappingUtils {
    
    
    public static Date getTimeZoneOffsetDate(Date utcDate, Integer hoursOffset, Integer minutesOffset) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(utcDate);
        calendar.add(Calendar.HOUR, hoursOffset);
        calendar.add(Calendar.MINUTE, minutesOffset);
        return calendar.getTime();
    }
    
    public static XMLGregorianCalendar convertToGregCalendar(Date date) {
        if (date == null) return null;
        try {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTime(date);
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        } catch (DatatypeConfigurationException e) {
            return null;
        }
    }
}
