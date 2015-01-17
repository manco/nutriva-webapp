package pl.nutrivia.config;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@ContextConfiguration(classes = WebMvcConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@TestExecutionListeners(mergeMode= TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS)
public abstract class WebAppConfigurationAware {

    @Autowired
    private WebApplicationContext webApplicationContext;

    public MockMvc createMockMvc() {
        return webAppContextSetup(webApplicationContext).build();
    }
}
