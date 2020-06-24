package alekseybykov.portfolio.springboot.soap.client;

import alekseybykov.portfolio.springboot.soap.callback.ClientSideUTPCallback;
import alekseybykov.portfolio.springboot.soap.ws.SoapWSService;
import https.spring_boot_soap_alekseybykov_github.DataServicePortType;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.common.ConfigurationConstants;
import org.apache.wss4j.dom.WSConstants;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Client for data exchange with secured WS.
 *
 * @author Aleksey Bykov
 * @since 24.06.2020
 */
public class AuthSoapClient extends SoapClient {

	@Override
	protected DataServicePortType createDataServicePortType() {
		SoapWSService service = null;
		try {
			service = new SoapWSService(new URL(SOAP_WS_URL));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		port = Objects.requireNonNull(service).getSoapWSPort();

		Client client = ClientProxy.getClient(port);
		Endpoint endpoint = client.getEndpoint();
		Map<String, Object> interceptorProperties = new HashMap<>();
		interceptorProperties.put(ConfigurationConstants.ACTION, ConfigurationConstants.USERNAME_TOKEN);
		interceptorProperties.put(ConfigurationConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
		interceptorProperties.put(ConfigurationConstants.PW_CALLBACK_CLASS, ClientSideUTPCallback.class.getName());
		interceptorProperties.put(ConfigurationConstants.USER, "some username");

		// For handling outgoing messages (requests).
		WSS4JOutInterceptor wssOuterInterceptor = new WSS4JOutInterceptor(interceptorProperties);
		endpoint.getOutInterceptors().add(wssOuterInterceptor);

		return port;
	}
}
