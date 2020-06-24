package alekseybykov.portfolio.springboot.ws.config;

import javax.xml.ws.Endpoint;

import alekseybykov.portfolio.springboot.ws.callback.ServiceSideUTPCallback;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;

import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.wss4j.common.ConfigurationConstants;
import org.apache.wss4j.dom.WSConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import alekseybykov.portfolio.springboot.ws.SoapWS;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aleksey Bykov
 * @since 17.06.2020
 */
@Configuration
public class SoapWSConfig {

	@Autowired
	private Bus bus;

	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(bus, new SoapWS());

		// WSDL is accessed through the URL: http://localhost:8080/soapws/dataservice?wsdl
		// Should be copied by URL and pass to the appropriate client folder.
		endpoint.publish("/dataservice");

		Map<String, Object> interceptorProperties = new HashMap<>();
		interceptorProperties.put(ConfigurationConstants.ACTION, ConfigurationConstants.USERNAME_TOKEN);
		interceptorProperties.put(ConfigurationConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
		interceptorProperties.put(ConfigurationConstants.PW_CALLBACK_CLASS, ServiceSideUTPCallback.class.getName());

		// For handling incoming messages (requests).
		WSS4JInInterceptor wssInnerInterceptor = new WSS4JInInterceptor(interceptorProperties);
		endpoint.getInInterceptors().add(wssInnerInterceptor);

		return endpoint;
	}
}
