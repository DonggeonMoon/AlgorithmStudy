package ValidationUtils;

public class ValidationImpl implements Validation {

    @Override
    public boolean isNotNull(String input) {
        return input != null;
    }

    @Override
    public boolean isNotBlank(String input) {
        return !input.equals("");
    }

    @Override
    public boolean isNotEmpty(String input) {
        return input != null && !input.equals("");
    }

    @Override
    public boolean isNumberOnly(String input) {
        return !input.matches("[^0-9]+");
    }

    @Override
    public boolean isAlphabetOnly(String input) {
        return !input.matches("[^A-z]+");
    }

    @Override
    public boolean isHangeulOnly(String input) {
        return !input.matches("[^ㄱ-ㅎㅏ-ㅣ가-힣]+");
    }

    @Override
    public boolean isEmail(String input) {
        return input.matches("^[A-z0-9~!#$%&*-_=+|{}.?]+@[A-z0-9.-]+$");
    }

    @Override
    public boolean isMobilePhoneNumber(String input) {
        return input.matches("[0-9]{3}-[0-9]{3,4}-[0-9]{3,4}");
    }

    @Override
    public boolean hasCorrectDateFormat(String input, String dateFormat) {
        //TODO
        return false;
    }

    @Override
    public String stripCharacters(String input) {
        return input.replaceAll("[^0-9]+", "");
    }
}
