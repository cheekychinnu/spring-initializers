package springinitializers;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.foo.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(initializers = { WrapperMainApplicationContextInitializer.class
		}, locations = { "classpath:application-context.xml" })
public abstract class BaseApplicationTest {
	
}
