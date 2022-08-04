import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Entity.ClienteRegistrato;

/**
 * 
 */

/**
 * @author laksh
 *
 */
public class ClienteRegistratoTest {

	private ClienteRegistrato clienteTest;
	
	@Before
	public void setUp() throws Exception {
		clienteTest = new ClienteRegistrato("prova", "prova", "admin", "admin", "prova");
	}

	/**
	 * @throws java.lang.Exception
	 */

	@Test
	public void getNomeTest() {
		 assertEquals("prova",clienteTest.getNome());
	}
	
	@Test
	public void getCognomeTest() {
		 assertEquals("prova",clienteTest.getCognome());
	}
	
	@Test
	public void getUsernameTest() {
		 assertEquals("admin",clienteTest.getUsername());
	}
	
	@Test
	public void getPasswordTest() {
		 assertEquals("admin",clienteTest.getPassword());
	}
	
	@Test
	public void getEmailTest() {
		 assertEquals("prova",clienteTest.getEmail());
	}
	
	

}
