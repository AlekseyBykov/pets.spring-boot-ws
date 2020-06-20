package alekseybykov.portfolio.springboot.ws.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import alekseybykov.portfolio.springboot.ws.SoapWS;

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
		Endpoint endpoint = new EndpointImpl(bus, new SoapWS());

		// WSDL is accessed through the URL: http://localhost:8080/soapws/dataservice?wsdl
		endpoint.publish("/dataservice");
		return endpoint;
	}
}
