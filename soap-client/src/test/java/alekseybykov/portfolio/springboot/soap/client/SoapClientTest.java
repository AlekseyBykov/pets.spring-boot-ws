package alekseybykov.portfolio.springboot.soap.client;

import https.spring_boot_soap_alekseybykov_github.Data;
import org.junit.Test;

import java.net.MalformedURLException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Web service should be running for data exchange.
 *
 * @author Aleksey Bykov
 * @since 20.06.2020
 */
public class SoapClientTest {

	@Test
	public void test() throws MalformedURLException {
		SoapClient soapClient = new SoapClient();
		assertTrue(soapClient.sendCreateDataRequest());

		List<Data> dataList = soapClient.sendGetDataRequest();
		assertNotNull(dataList);

		assertEquals("some name", dataList.get(0).getName());
		assertEquals("some description", dataList.get(0).getDescription());
	}
}
