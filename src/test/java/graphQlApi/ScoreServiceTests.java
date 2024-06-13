package graphQlApi;

import graphQlApi.Services.ScoreServiceInterface;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ScoreServiceTests {

    @Autowired
    private ScoreServiceInterface scoreService;
    @Test
    void verifyTestsWithExpectedCombinations() {
        assertEquals(4, scoreService.verify("3x15"));
        assertEquals(1, scoreService.verify("0x11"));
        assertEquals(2, scoreService.verify("6x3"));
        assertEquals(0, scoreService.verify("8x5"));
    }


}
