public class Validator {
    //Checks date strings that are of YYYY-MM-DD format and has simple range checks

    public static boolean isValidDate(String date) {
        if (date == null || date.length() != 10) return false;
        if (date.charAt(4) != '-' || date.charAt(7) != '-') return false;

        try {
            int year = Integer.parseInt(date.substring(0, 4));
            int month = Integer.parseInt(date.substring(5, 7));
            int day = Integer.parseInt(date.substring(8));
            //Does not consider month-specific day constraints or leap years

            return year > 0 && month >= 1 && month <= 12 && day >= 1 && day <= 31;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    //Checks time strings in 24-hour format HH: mm

    public static boolean isValidTime(String time) {
        if (time == null || time.length() != 5) return false;
        if (time.charAt(2) != ':') return false;

        try {
            int hours = Integer.parseInt(time.substring(0, 2));
            int minutes = Integer.parseInt(time.substring(3));

            return hours >= 0 && hours <= 23 && minutes >= 0 && minutes <= 59;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    //Returns true when the input is an integer that is more than zero

    public static boolean isPositiveInt(String input) {
        try {
            return Integer.parseInt(input) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    //Checks whether the string has a non-whitespace character and is not null

    public static boolean isNotEmpty(String input) {
        return input != null && !input.trim().isEmpty();
    }
}
