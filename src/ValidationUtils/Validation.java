package ValidationUtils;

public interface Validation {
    /**
     * 입력 값이 null이 아닌지 확인한다.
     * @param input 입력 값
     * @return 입력값이 null이 아니면 true, 그렇지 않으면 false
     */
    boolean isNotNull(String input);

    /**
     * 입력값이 공백("")이 아닌지 확인한다.
     * @param input 입력 값
     * @return 입력값이 공백이 아니면 true, 그렇지 않으면 false
     */
    boolean isNotBlank(String input);

    /**
     * 입력 값이 null과 공백("")이 아닌지 확인한다.
     * @param input 입력 값
     * @return 입력값이 null과 공백("")이 아니면 true, 그렇지 않으면 false
     */
    boolean isNotEmpty(String input);

    /**
     * 입력 값이 숫자만으로 이루어졌는지 확인한다.
     * @param input 입력 값
     * @return 입력값이 숫자로만 구성되었으면 true, 그렇지 않으면 false
     */
    boolean isNumberOnly(String input);

    /**
     * 입력 값이 알파벳만으로 이루어졌는지 확인한다.
     * @param input 입력 값
     * @return 입력값이 알파벳만으로 구성되었으면 true, 그렇지 않으면 false
     */
    boolean isAlphabetOnly(String input);

    /**
     * 입력 값이 한글만으로 이루어졌는지 확인한다.
     * @param input 입력 값
     * @return 입력값이 한글만으로 구성되었으면 true, 그렇지 않으면 false
     */
    boolean isHangeulOnly(String input);

    /**
     * 입력 값이 이메일 형식인지 확인한다.
     * @param input 입력 값
     * @return 입력값이 이메일 형식이면 true, 그렇지 않으면 false
     */
    boolean isEmail(String input);

    /**
     * 입력 값이 휴대폰 번호 형식인지 확인한다.
     * @param input 입력 값
     * @return 입력값이 휴대폰 번호 형식이면 true, 그렇지 않으면 false
     */
    boolean isMobilePhoneNumber(String input);

    /**
     * 입력 값이 날짜 형식을 따르는지 확인한다.
     * @param input 입력 값
     * @return 입력값이 날짜 형식을 따르고 있으면 true, 그렇지 않으면 false
     */
    boolean hasCorrectDateFormat(String input);

    /**
     * 입력 값에서 문자(숫자를 제외한 모든 글자)를 제거한다.
     * @param input 입력 값
     * @return 문자가 제거된 숫자로만 구성된 결과값
     */
    String stripCharacters(String input);
}
