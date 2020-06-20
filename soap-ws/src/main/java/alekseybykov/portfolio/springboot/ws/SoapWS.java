package alekseybykov.portfolio.springboot.ws;

import org.apache.cxf.feature.Features;

import javax.jws.WebService;

import https.spring_boot_soap_alekseybykov_github.*;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Aleksey Bykov
 * @since 17.06.2020
 */
@Features(features = "org.apache.cxf.feature.LoggingFeature")
@WebService(endpointInterface = "https.spring_boot_soap_alekseybykov_github.DataServicePortType")
public class SoapWS implements DataServicePortType {

	private Map<BigInteger, Data> dataMap = new HashMap<>();

	/**
	 * Will be deserialized to GetDataRequest:
	 *
	 * <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:spr="https://spring-boot-soap.alekseybykov.github.io/">
	 *    <soapenv:Header/>
	 *    <soapenv:Body>
	 *       <spr:getDataRequest>
	 *          <dataId>1</dataId>
	 *       </spr:getDataRequest>
	 *    </soapenv:Body>
	 * </soapenv:Envelope>
	 *
	 * Will be serialized from GetDataResponse:
	 *
	 * <soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
	 *    <soap:Body>
	 *       <ns2:getDataResponse xmlns:ns2="https://spring-boot-soap.alekseybykov.github.io/">
	 *          <data>
	 *             <name>Name</name>
	 *             <description>Description</description>
	 *          </data>
	 *       </ns2:getDataResponse>
	 *    </soap:Body>
	 * </soap:Envelope>
	 *
	 */
	@Override
	public GetDataResponse getData(GetDataRequest request) {
		GetDataResponse response = new GetDataResponse();
		response.getData().add(dataMap.get(request.getDataId()));
		return response;
	}

	/**
	 * Will be deserialized to CreateDataRequest:
	 *
	 * <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:spr="https://spring-boot-soap.alekseybykov.github.io/">
	 *    <soapenv:Header/>
	 *    <soapenv:Body>
	 *       <spr:createDataRequest>
	 *          <dataId>1</dataId>
	 *          <data>
	 *             <name>Name</name>
	 *             <description>Description</description>
	 *          </data>
	 *       </spr:createDataRequest>
	 *    </soapenv:Body>
	 * </soapenv:Envelope>
	 *
	 * Will be serialized from CreateDataResponse:
	 *
	 * <soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
	 *    <soap:Body>
	 *       <ns2:createDataResponse xmlns:ns2="https://spring-boot-soap.alekseybykov.github.io/">
	 *          <result>true</result>
	 *       </ns2:createDataResponse>
	 *    </soap:Body>
	 * </soap:Envelope>
	 */
	@Override
	public CreateDataResponse createData(CreateDataRequest request) {
		dataMap.put(request.getDataId(), request.getData());
		CreateDataResponse response = new CreateDataResponse();
		response.setResult(true);
		return response;
	}
}