package tests;
import static org.junit.Assert.*;

import org.junit.Test;


public class CommunicationWithTheRouter {

	@Test
	public void test() {
		
		SSHConnection testConnection = new SSHConnection();
        // This aims to test if the communiction with the router is error less.
		assertEquals(0,testConnection.grantAccess(1500));
		
		
	}

}
