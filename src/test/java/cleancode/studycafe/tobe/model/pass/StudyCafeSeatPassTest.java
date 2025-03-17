package cleancode.studycafe.tobe.model.pass;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudyCafeSeatPassTest {

    @Test
    @DisplayName("패스 타입이 같다.")
    void passTypeIsSame() {
        //given
        StudyCafeSeatPass studyCafeSeatPass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 2, 100000, 0.1);

        //when
        boolean result = studyCafeSeatPass.isSamePassType(StudyCafePassType.WEEKLY);

        //then
        assertTrue(result);
    }

    @Test
    @DisplayName("패스 타입이 다르다.")
    void passTypeIsMotSame() {
        //given
        StudyCafeSeatPass studyCafeSeatPass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 2, 100000, 0.1);

        //when
        boolean result = studyCafeSeatPass.isSamePassType(StudyCafePassType.HOURLY);

        //then
        assertFalse(result);
    }

    @Test
    @DisplayName("할인된 가격 확인")
    void getDiscountPrice() {
        //given
        StudyCafeSeatPass studyCafeSeatPass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 2, 100000, 0.1);

        //when
        int result = studyCafeSeatPass.getDiscountPrice();

        //then
        assertEquals((int) (100000 * 0.1), result);
    }
}
