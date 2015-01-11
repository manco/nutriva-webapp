package pl.nutrivia.home;

import org.junit.Test;
import org.springframework.test.web.servlet.ResultActions;
import pl.nutrivia.config.WebAppConfigurationAware;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


public class HomeControllerTest extends WebAppConfigurationAware {

    @Test
    public void shouldReturnJson() throws Exception {
        //given

        //when
        final ResultActions resultActions = getMockMvc().perform(get("/"));

        //then
        resultActions.andExpect(content().string("{\"name\":\"jakiś name\",\"vitamines\":{\"B1 - [Tiamina]\":54.3},\"minerals\":{\"Fe - [Żelazo]\":22.1}}"));

    }
}