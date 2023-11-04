package validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class ValidationImplTest {

    ValidationImpl validation = new ValidationImpl();

    @Test
    void isNotNull() {
        assertTrue(validation.isNotNull("null"));
        assertFalse(validation.isNotNull(null));
    }

    @Test
    void isNotBlank() {
        assertTrue(validation.isNotBlank("blank"));
        assertFalse(validation.isNotBlank("  "));
        assertFalse(validation.isNotBlank(" "));
        assertFalse(validation.isNotBlank(""));
    }

    @Test
    void isNotEmpty() {
        assertTrue(validation.isNotEmpty("null"));
        assertFalse(validation.isNotEmpty(null));
        assertTrue(validation.isNotEmpty("blank"));
        assertFalse(validation.isNotEmpty("  "));
        assertFalse(validation.isNotEmpty(" "));
        assertFalse(validation.isNotEmpty(""));
    }

    @Test
    void isNumberOnly() {
        assertTrue(validation.isNumberOnly("1234"));
        assertFalse(validation.isNumberOnly("1q2w3e4r"));
        assertFalse(validation.isNumberOnly("q1w2e3r4"));
        assertFalse(validation.isNumberOnly("1ㄱ2ㄴ3ㄷ4ㄹ"));
        assertFalse(validation.isNumberOnly("ㄱ1ㄴ2ㄷ3ㄹ4"));
        assertFalse(validation.isNumberOnly("1가2나3다4라"));
        assertFalse(validation.isNumberOnly("가1나2다3라4"));
        assertFalse(validation.isNumberOnly("1大2韓3民4國"));
        assertFalse(validation.isNumberOnly("大1韓2民3國4"));
    }

    @Test
    void isAlphabetOnly() {
        assertFalse(validation.isAlphabetOnly("1234"));
        assertFalse(validation.isAlphabetOnly("1q2w3e4r"));
        assertFalse(validation.isAlphabetOnly("q1w2e3r4"));
        assertTrue(validation.isAlphabetOnly("qwer"));
        assertTrue(validation.isAlphabetOnly("QWER"));
        assertFalse(validation.isAlphabetOnly("1ㄱ2ㄴ3ㄷ4ㄹ"));
        assertFalse(validation.isAlphabetOnly("ㄱ1ㄴ2ㄷ3ㄹ4"));
        assertFalse(validation.isAlphabetOnly("1가2나3다4라"));
        assertFalse(validation.isAlphabetOnly("가1나2다3라4"));
        assertFalse(validation.isAlphabetOnly("1大2韓3民4國"));
        assertFalse(validation.isAlphabetOnly("大1韓2民3國4"));
    }

    @Test
    void isHangeulOnly() {
        assertFalse(validation.isHangeulOnly("1234"));
        assertFalse(validation.isHangeulOnly("1q2w3e4r"));
        assertFalse(validation.isHangeulOnly("q1w2e3r4"));
        assertFalse(validation.isHangeulOnly("qwer"));
        assertFalse(validation.isHangeulOnly("QWER"));
        assertFalse(validation.isHangeulOnly("1ㄱ2ㄴ3ㄷ4ㄹ"));
        assertFalse(validation.isHangeulOnly("ㄱ1ㄴ2ㄷ3ㄹ4"));
        assertFalse(validation.isHangeulOnly("1가2나3다4라"));
        assertFalse(validation.isHangeulOnly("가1나2다3라4"));
        assertTrue(validation.isHangeulOnly("가나다라"));
        assertFalse(validation.isHangeulOnly("1大2韓3民4國"));
        assertFalse(validation.isHangeulOnly("大1韓2民3國4"));
    }

    @Test
    void isEmail() {
        assertTrue(validation.isEmail("abc@email.com"));
        assertTrue(validation.isEmail("abc@e.mail.com"));
        assertFalse(validation.isEmail(";dsfjla;s"));
        assertFalse(validation.isEmail("a한글bc@e.mail.com"));
    }

    @Test
    void isMobilePhoneNumber() {
        assertTrue(validation.isMobilePhoneNumber("010-1234-1234"));
        assertFalse(validation.isMobilePhoneNumber("01012341234"));
        assertFalse(validation.isMobilePhoneNumber("010일1241이24"));
    }

    @Test
    void hasCorrectDateFormat() {
        assertTrue(validation.hasCorrectDateFormat("2022-06-29"));
        assertFalse(validation.hasCorrectDateFormat("2022-0629"));
        assertFalse(validation.hasCorrectDateFormat("2022년 6월 29일"));
        assertFalse(validation.hasCorrectDateFormat("Jan-1-2022"));
    }

    @Test
    void stripCharacters() {
        assertEquals("1234", validation.stripCharacters("1q2w3e4r"));
        assertEquals("1234", validation.stripCharacters("q1w2e3r4"));
    }

    @Test
    void test() {
        String time = "2:1:5";
        LocalTime localDateTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("H:m:s"));
        System.out.println("localDateTime = " + localDateTime);
    }
}