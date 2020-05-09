package util;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.com.urbano.util.JPAUtil;

public class JPAUtilTest {
	@Test
	public void getEntityManager() {
		EntityManager sessao = JPAUtil.getEntityManager();
		sessao.close();
	}
}
