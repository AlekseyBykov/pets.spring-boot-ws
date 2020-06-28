package alekseybykov.portfolio.springboot.mtom.ws.config;
import javax.xml.ws.Endpoint;
import javax.xml.ws.soap.SOAPBinding;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import alekseybykov.portfolio.springboot.mtom.ws.exchanger.FileExchangerImpl;

/**
 * @author Aleksey Bykov
 * @since 28.06.2020
 */
@Configuration
public class MtomWSConfig {

	@Autowired
	private Bus bus;

	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(bus, new FileExchangerImpl());
		endpoint.publish("/exchanger");
		((SOAPBinding) endpoint.getBinding()).setMTOMEnabled(true);
		return endpoint;
	}
}
