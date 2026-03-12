package innovate.tamergroup.opencart.rest.utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class OpencartDateDeserializer implements JsonDeserializer<Date> {

    private static final String[] DATE_FORMATS = new String[] { "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd", "yyyy-MM-dd" };

    public OpencartDateDeserializer() {
        super();
    }

    @Override
    public Date deserialize(JsonElement jsonElement, Type type,
                            JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        for (String format : DATE_FORMATS) {
            try {
                return new SimpleDateFormat(format).parse(jsonElement.getAsString());
            } catch (ParseException e) {
            }
            /*throw new JsonParseException("Unparseable date: \"" + jsonElement.getAsString()
                            + "\". Supported formats: " + Arrays.toString(DATE_FORMATS));*/
        }
        return null;
    }
}
