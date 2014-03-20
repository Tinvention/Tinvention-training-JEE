package net.tinvention.training.ejb.stateless;

import javax.naming.NamingException;

import net.tinvention.training.InContainerUtil;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EchoBeanTest {

	private static final String MSG = "msg";
	private Echo echo;

	@Before
	public void init() throws NamingException {
		echo = (Echo) InContainerUtil.getEJBContainer().getContext()
				.lookup(Echo.class.getName());
	}

	@Test
	public void testEchoMsg() {

		Assert.assertTrue(echo.echoMsg(MSG).indexOf(MSG) > 0);
	}

}
