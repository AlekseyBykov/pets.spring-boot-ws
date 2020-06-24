package alekseybykov.portfolio.springboot.soap.client;

/**
 * @author Aleksey Bykov
 * @since 24.06.2020
 */
public class SoapClientFactory {
	public SoapClient getSoapClient(String soapClientType) {
		if ("auth".equals(soapClientType)) {
			return new AuthSoapClient();
		}
		if ("no-auth".equals(soapClientType)) {
			return new NoAuthSoapClient();
		}
		return null;
	}
}
