import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class MainTest {
    Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
    }
    @Test
    void chooseCave() {
        assertTrue(main.chooseCave(), "Game Complete");
    }
    @AfterEach
    void tearDown() {
    }


}