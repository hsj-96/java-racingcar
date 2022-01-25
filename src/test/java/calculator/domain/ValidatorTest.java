package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @ValueSource(strings = {"", "  "})
    @ParameterizedTest
    void 입력값_null_or_빈칸(String input) {
        assertThat(Validator.isValidExpression(input)).isFalse();
    }

    @ValueSource(strings = {"1+3a", "1.2+3", "1@"})
    @ParameterizedTest
    void 정수_사칙연산_기호_아닌_문자(String input) {
        assertThat(Validator.isValidExpression(input)).isFalse();
    }

    @ValueSource(strings = {"1+3 33", "33 * 1 23", "1+ 0 1"})
    @ParameterizedTest
    void 숫자_다음_숫자가_나오는_경우(String input) {
        assertThat(Validator.isValidExpression(input)).isFalse();
    }

    @ValueSource(strings = {"1+ +", "1 + + 2", "1--2", "1+2*/3"})
    @ParameterizedTest
    void 사칙연산_기호_다음_기호가_또_나오는_경우(String input) {
        assertThat(Validator.isValidExpression(input)).isFalse();
    }

    @ValueSource(strings = {"+1+3", "-1*2", "1+0/"})
    @ParameterizedTest
    void 사칙연산_기호가_제일_앞이나_뒤에_올_경우(String input) {
        assertThat(Validator.isValidExpression(input)).isFalse();
    }

    @ValueSource(strings = {"1+3/0", "1*23-1/0", "1/01", "1/0", "0/0"})
    @ParameterizedTest
    void 숫자_0으로_나눌_경우(String input) {
        assertThat(Validator.isValidExpression(input)).isFalse();
    }

    @ValueSource(strings = {"01+3", "3-02"})
    @ParameterizedTest
    void 숫자_0으로_시작하는_경우(String input) {
        assertThat(Validator.isValidExpression(input)).isFalse();
    }

    @ValueSource(strings = {"0+3", "3-0"})
    @ParameterizedTest
    void 숫자_0만_사용하는_경우(String input) {
        assertThat(Validator.isValidExpression(input)).isTrue();
    }

    @ValueSource(strings = {"1+2/3*4", "1-2", "1/2+0-391", "1 + 2 - 3 / 4 * 5", "100 / 50+2", "1 +2 + 3"})
    @ParameterizedTest
    void 정상입력(String input) {
        assertThat(Validator.isValidExpression(input)).isTrue();
    }
}