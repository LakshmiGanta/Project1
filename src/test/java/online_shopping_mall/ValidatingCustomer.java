package online_shopping_mall;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.app.exception.BusinessException;
import com.app.search.service.LoginService;
import com.app.search.service.impl.LoginServiceImpl;

public class ValidatingCustomer {
	
	LoginService loginService = new LoginServiceImpl() ;
	@Test
	public void test() throws BusinessException{		
		assertNotNull(loginService.validateCustomer("paru.com", "123"));		
	}
	
	@Test
	public void test1() throws BusinessException{		
		assertNotNull(loginService.validateCustomer("paru", "123"));
	}

}
