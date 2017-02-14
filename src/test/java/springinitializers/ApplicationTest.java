package springinitializers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.foo.SubSetApplicationContextInitializer;
import com.foo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(initializers = { SubSetApplicationContextInitializer.class }, inheritInitializers = true)
public class ApplicationTest extends BaseApplicationTest {

	/*
	 * By default the initializers of the derived class gets called and then the base class's initializers are called.
	 * To override this behaviour, BOTH the initializer should implement Ordered interface and define an order
	 * Whichever one wants to run later should be given higher order
	 * 
	 * You can also try @Order annotation for the same.
	 * 
	 * Lets say one initializer is from third party lib, and it doesn't implement or annotated with Order,
	 * then this wouldn't work.
	 * 
	 * So have a wrapper over the third party initializer and annotate it with @Order.
	 * Refer : /springinitializers/src/main/java/com/foo/WrapperMainApplicationContextInitializer.java
	 */
	@Resource
	private User user;

	@Test
	public void test() {
		assertNotNull(user);
		assertEquals("chinnu", user.getName());
		assertEquals("overridden hobby is expected","running", user.getHobby()); 
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
