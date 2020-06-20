package alekseybykov.portfolio.springboot.soap.client;

import alekseybykov.portfolio.springboot.soap.fixture.DataFixture;
import alekseybykov.portfolio.springboot.soap.ws.SoapWSService;
import https.spring_boot_soap_alekseybykov_github.CreateDataRequest;
import https.spring_boot_soap_alekseybykov_github.CreateDataResponse;
import https.spring_boot_soap_alekseybykov_github.Data;
import https.spring_boot_soap_alekseybykov_github.DataServicePortType;
import https.spring_boot_soap_alekseybykov_github.GetDataRequest;
import https.spring_boot_soap_alekseybykov_github.GetDataResponse;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * @author Aleksey Bykov
 * @since 19.06.2020
 */
public class SoapClient {

	private final BigInteger dataId = BigInteger.valueOf(1);
	private DataServicePortType port;

	public SoapClient() throws MalformedURLException {
		SoapWSService service = new SoapWSService(new URL("http://localhost:8080/soapws/dataservice"));
		port = service.getSoapWSPort();
	}

	public boolean sendCreateDataRequest() {
		CreateDataRequest request = new CreateDataRequest();
		request.setDataId(dataId);
		request.setData(DataFixture.getFixture());

		CreateDataResponse response = port.createData(request);
		return response.isResult();
	}

	public List<Data> sendGetDataRequest() {
		GetDataRequest request = new GetDataRequest();
		request.setDataId(dataId);

		GetDataResponse response = port.getData(request);
		return response.getData();
	}
}
