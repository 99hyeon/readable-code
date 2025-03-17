package cleancode.studycafe.tobe.io;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputHandlerTest {

    @Test
    @DisplayName("스터디 패스권 입력을 사용자가 올바르게 입력한 경우")
    void getPassTypeSelectingUserActionValidInput() {
        //given
        String userInput = "1\n";
        InputStream input = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(input);
        InputHandler inputHandler = new InputHandler();

        //when
        StudyCafePassType resultType = inputHandler.getPassTypeSelectingUserAction();

        //then
        assertEquals(StudyCafePassType.HOURLY, resultType);
    }

    @Test
    @DisplayName("사용자가 스터디 패스권 입력을 잘못한 경우")
    void getPassTypeSelectingUserActionInValidInput() {
        //given
        String userInput = "invalid\n";
        InputStream input = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(input);
        InputHandler inputHandler = new InputHandler();

        //when  //then
        assertThatThrownBy(inputHandler::getPassTypeSelectingUserAction)
                .hasMessage("잘못된 입력입니다.");
    }
}
