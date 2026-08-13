/* Utility class for input validation
 * All methods are static — no object needed to use them */
public class Validator {

    public static boolean isValidDate(String date) { // check if date matches dd/mm/yyyy format manually
        if (date == null || date.length() != 10) return false; // must be exactly 10 characters
        if (date.charAt(2) != '/' || date.charAt(5) != '/') return false; // slashes must be in right place
        try {
            int day   = Integer.parseInt(date.substring(0, 2)); // extract dd
            int month = Integer.parseInt(date.substring(3, 5)); // extract mm
            int year  = Integer.parseInt(date.substring(6));    // extract yyyy
            return day >= 1 && day <= 31 && month >= 1 && month <= 12 && year > 0; // validate ranges
        } catch (NumberFormatException e) { // catches any non-numeric characters
            return false;
        }
    }

    public static boolean isValidTime(String time) { // check if time matches HH:mm format manually
        if (time == null || time.length() != 5) return false; // must be exactly 5 characters
        if (time.charAt(2) != ':') return false; // colon must be in position 2
        try {
            int hours   = Integer.parseInt(time.substring(0, 2)); // extract HH
            int minutes = Integer.parseInt(time.substring(3));    // extract mm
            return hours >= 0 && hours <= 23 && minutes >= 0 && minutes <= 59; // validate ranges
        } catch (NumberFormatException e) { // catches any non-numeric characters
            return false;
        }
    }

    public static boolean isPositiveInt(String input) { // returns true if input is a whole number greater than zero
        try {
            return Integer.parseInt(input) > 0; // parse and check it is positive
        } catch (NumberFormatException e) {      // catches letters, symbols, decimals, etc.
            return false;
        }
    }

    public static boolean isNotEmpty(String input) { // returns true if input is not null or blank
        return input != null && !input.trim().isEmpty(); // trim removes surrounding whitespace before checking
    }
}