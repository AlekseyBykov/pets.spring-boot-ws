package alekseybykov.portfolio.springboot.soap.client;

import alekseybykov.portfolio.springboot.soap.fixture.DataFixture;
import https.spring_boot_soap_alekseybykov_github.CreateDataRequest;
import https.spring_boot_soap_alekseybykov_github.CreateDataResponse;
import https.spring_boot_soap_alekseybykov_github.Data;
import https.spring_boot_soap_alekseybykov_github.DataServicePortType;
import https.spring_boot_soap_alekseybykov_github.GetDataRequest;
import https.spring_boot_soap_alekseybykov_github.GetDataResponse;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Aleksey Bykov
 * @since 24.06.2020
 */
public abstract class SoapClient {

	protected final BigInteger dataId = BigInteger.valueOf(1);
	protected String SOAP_WS_URL = "http://localhost:8080/soapws/dataservice?wsdl";

	protected DataServicePortType port;

	public SoapClient() {
		port = createDataServicePortType();
	}

	protected boolean sendCreateDataRequest() {
		CreateDataRequest request = new CreateDataRequest();
		request.setDataId(dataId);
		request.setData(DataFixture.getFixture());

		CreateDataResponse response = port.createData(request);
		return response.isResult();
	}

	protected List<Data> sendGetDataRequest() {
		GetDataRequest request = new GetDataRequest();
		request.setDataId(dataId);

		GetDataResponse response = port.getData(request);
		return response.getData();
	}

	protected abstract DataServicePortType createDataServicePortType();
}
