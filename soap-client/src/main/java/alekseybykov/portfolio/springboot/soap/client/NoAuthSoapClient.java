package alekseybykov.portfolio.springboot.soap.client;

import alekseybykov.portfolio.springboot.soap.ws.SoapWSService;
import https.spring_boot_soap_alekseybykov_github.DataServicePortType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

/**
 * Client for sending SOAP requests without authentication.
 *
 * @author Aleksey Bykov
 * @since 19.06.2020
 */
public class NoAuthSoapClient extends SoapClient {

	@Override
	protected DataServicePortType createDataServicePortType() {
		SoapWSService service = null;
		try {
			service = new SoapWSService(new URL(SOAP_WS_URL));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return Objects.requireNonNull(service).getSoapWSPort();
	}
}
