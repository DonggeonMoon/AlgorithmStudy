package palindrome;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PalindromeTest {
    @ParameterizedTest
    @CsvSource({
            "mom, true",
            "wow, true",
            "noon, true",
            "level, true",
            "God's dog, true",
            "역삼역, true",
            "기러기, true",
            "일요일, true",
            "복불복, true",
            "meemaw, false"
    })
    void testPalindrome(String string, boolean isPalindrome) {
        Palindrome palindrome = Palindrome.create();

        assertThat(palindrome.isPalindrome(string)).isEqualTo(isPalindrome);
    }
}
