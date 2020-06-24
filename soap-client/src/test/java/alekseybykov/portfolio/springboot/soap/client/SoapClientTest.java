package alekseybykov.portfolio.springboot.soap.client;

import javax.xml.ws.soap.SOAPFaultException;
import https.spring_boot_soap_alekseybykov_github.Data;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Web service should be running for data exchange.
 *
 * @author Aleksey Bykov
 * @since 20.06.2020
 */
public class SoapClientTest {

	private SoapClientFactory factory = new SoapClientFactory();

	@Test
	public void testDataExchangeWithAuthentication() {
		SoapClient soapClient = factory.getSoapClient("auth");
		assertTrue(soapClient.sendCreateDataRequest());

		List<Data> dataList = soapClient.sendGetDataRequest();
		assertNotNull(dataList);

		assertEquals("some name", dataList.get(0).getName());
		assertEquals("some description", dataList.get(0).getDescription());
	}

	@Test(expected = SOAPFaultException.class)
	public void testDataExchangeWithoutAuthentication() {
		SoapClient soapClient = factory.getSoapClient("no-auth");
		soapClient.sendCreateDataRequest();
	}
}
