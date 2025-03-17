package cleancode.studycafe.tobe.model.pass;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudyCafeSeatPassesTest {

    private final List<StudyCafeSeatPass> testPassesList = List.of(
            StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 2, 4000, 0.0),
            StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 4, 6500, 0.0),
            StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 6, 9000, 0.0),
            StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 8, 11000, 0.0),
            StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 1, 60000, 0.0),
            StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 2, 100000, 0.1),
            StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 3, 130000, 0.1),
            StudyCafeSeatPass.of(StudyCafePassType.FIXED, 4, 250000, 0.1)
    );

    @Test
    @DisplayName("HOURLY 패스권만 필터링 한다.")
    void findPassByHOURLY() {
        //given
        StudyCafeSeatPasses studyCafeSeatPasses = StudyCafeSeatPasses.of(testPassesList);

        //when
        List<StudyCafeSeatPass> resultList = studyCafeSeatPasses.findPassBy(StudyCafePassType.HOURLY);

        //then
        assertEquals(4, resultList.size());
        assertTrue(resultList.stream().allMatch(pass -> pass.getPassType() == StudyCafePassType.HOURLY));
    }

    @Test
    @DisplayName("WEEKLY 패스권만 필터링 한다.")
    void findPassByWEEKLY() {
        //given
        StudyCafeSeatPasses studyCafeSeatPasses = StudyCafeSeatPasses.of(testPassesList);

        //when
        List<StudyCafeSeatPass> resultList = studyCafeSeatPasses.findPassBy(StudyCafePassType.WEEKLY);

        //then
        assertEquals(3, resultList.size());
        assertTrue(resultList.stream().allMatch(pass -> pass.getPassType() == StudyCafePassType.WEEKLY));
    }

    @Test
    @DisplayName("FIXED 패스권만 필터링 한다.")
    void findPassByFIXED() {
        //given
        StudyCafeSeatPasses studyCafeSeatPasses = StudyCafeSeatPasses.of(testPassesList);

        //when
        List<StudyCafeSeatPass> resultList = studyCafeSeatPasses.findPassBy(StudyCafePassType.FIXED);

        //then
        assertEquals(1, resultList.size());
        assertTrue(resultList.stream().allMatch(pass -> pass.getPassType() == StudyCafePassType.FIXED));
    }


}
