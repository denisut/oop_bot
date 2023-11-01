package bot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @Test
    void helpTest() {
        String expResult, actResult;

        Main example = new Main();
        example.setCommand("/help");

        expResult = "Бот для парсинга статистики с YouTube и VK \nДоступные команды: \n/YouTube \n/vk \n/exit";
        actResult = output.toString().trim();
        assertEquals(expResult, actResult);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
