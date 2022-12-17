package menu.utls;

import menu.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    private static final Validator validator = new Validator();

    @ParameterizedTest
    @ValueSource(strings = {"토,제임스", "제임스본드,포코",
            "토미", "토미,제임스,포코,제이슨,포미,라이언"})
    @DisplayName("이름이 2글자 미만이거나 4글자 초과인 경우 에러처리," +
            " 인원 수가 2명 미만이거나 5명 초과인 경우 에러처리")
    void validateCoachNames(String input) {
        assertThatThrownBy(() -> validator.validateCoachNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INCORRECT_COACH_NAMES);
    }

}