package validationutils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

public class ValidationImpl implements Validation {

    @Override
    public boolean isNotNull(String input) {
        return input != null;
    }

    @Override
    public boolean isNotBlank(String input) {
        return !input.trim().equals("");
    }

    @Override
    public boolean isNotEmpty(String input) {
        return input != null && !input.trim().equals("");
    }

    @Override
    public boolean isNumberOnly(String input) {
        char[] chars = input.toCharArray();
        for (char i : chars) {
            if (i < 48 || i > 57) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isAlphabetOnly(String input) {
        char[] chars = input.toCharArray();
        for (char i : chars) {
            if (i < 65 || i > 122) {
                return false;
            }

            if (i >= 91 && i <= 96) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isHangeulOnly(String input) {
        char[] chars = input.toCharArray();
        for (char i : chars) {
            if (i < 44032 || i > 55203) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isEmail(String input) {
        Pattern pattern = Pattern.compile("^[A-z0-9~!#$%&*\\-_=+|{}.?]+@[A-z0-9.-]+$");
        return pattern.matcher(input).matches();
    }

    @Override
    public boolean isMobilePhoneNumber(String input) {
        Pattern pattern = Pattern.compile("[0-9]{3}-[0-9]{3,4}-[0-9]{3,4}");
        return pattern.matcher(input).matches();
    }

    @Override
    public boolean hasCorrectDateFormat(String input) {
        try {
            LocalDate.parse(input);
            return true;
        } catch (DateTimeParseException dtpe) {
            return false;
        }
    }

    @Override
    public String stripCharacters(String input) {
        return input.replaceAll("[^0-9]+", "");
    }
}
