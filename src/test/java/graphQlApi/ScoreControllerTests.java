package graphQlApi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@AutoConfigureMockMvc
@SpringBootTest
public class ScoreControllerTests {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void verifyMutationTest() throws Exception {
        String query = "{ \"query\": \"mutation { verify(score: \\\"3x15\\\") { combinations } }\" }";

        mockMvc.perform(post("/graphql")
                        .contentType("application/json")
                        .content(query))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.verify.combinations").value(4));
    }
}
