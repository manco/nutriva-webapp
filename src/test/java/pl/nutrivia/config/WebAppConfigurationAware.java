package pl.nutrivia.config;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
//@ActiveProfiles("test")
@WebAppConfiguration
@ContextConfiguration(classes = {
        ApplicationConfig.class,
//        EmbeddedDataSourceConfig.class,
//        JpaConfig.class,
  //      NoCsrfSecurityConfig.class,
        WebMvcConfig.class
})
public abstract class WebAppConfigurationAware {

    @Autowired private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void before() {
        mockMvc = webAppContextSetup(wac).build();
    }

    protected final MockMvc getMockMvc() {
        return mockMvc;
    }
}
