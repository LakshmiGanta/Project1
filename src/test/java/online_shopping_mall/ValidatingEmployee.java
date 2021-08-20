package online_shopping_mall;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.app.exception.BusinessException;
import com.app.search.service.LoginService;
import com.app.search.service.impl.LoginServiceImpl;

 public class ValidatingEmployee {
	 LoginService loginService = new LoginServiceImpl() ;

	@Test
	 public void test() throws BusinessException {
		//fail("Not yet implemented");
		assertNotNull(loginService.validateEmployee("ram.com","1234" ));
	}

}
