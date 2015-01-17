package pl.nutrivia.config;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
       EmbeddedDataSourceConfig.class,
       JpaConfig.class,
})
@Transactional
@TestExecutionListeners(listeners = TransactionalTestExecutionListener.class)
public interface DbTestWithRollback {

}
