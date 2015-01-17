package pl.nutrivia.home;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import pl.nutrivia.config.WebAppConfigurationAware;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

public class HomeControllerTest extends WebAppConfigurationAware {

    @Test
    public void shouldReturnJson() throws Exception {
        //given

        final MockMvc mockMvc = createMockMvc();

        //when
        final ResultActions resultActions = mockMvc.perform(get("/"));

        //then
        resultActions.andExpect(content().string(Matchers.containsString("\"calories\":" + 13*4)));

    }
}