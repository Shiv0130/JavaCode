import java.util.regex.Pattern;

/*
 * Utility class — validates dates, times, and numeric input.
 * All methods are static so no object is needed.
 */
public class Validator {

    // dd/mm/yyyy pattern
    private static final Pattern DATE_PATTERN =
            Pattern.compile("^(0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/\\d{4}$");

    // HH:mm pattern
    private static final Pattern TIME_PATTERN =
            Pattern.compile("^([01]\\d|2[0-3]):[0-5]\\d$");

    public static boolean isValidDate(String date) {
        return DATE_PATTERN.matcher(date).matches();
    }

    public static boolean isValidTime(String time) {
        return TIME_PATTERN.matcher(time).matches();
    }

    /* Makes sure input is a positive integer */
    public static boolean isPositiveInt(String input) {
        try {
            return Integer.parseInt(input) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isNotEmpty(String input) {
        return input != null && !input.trim().isEmpty();
    }
}
