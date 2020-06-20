
package https.spring_boot_soap_alekseybykov_github;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the https.spring_boot_soap_alekseybykov_github package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CreateDataRequest_QNAME = new QName("https://spring-boot-soap.alekseybykov.github.io/", "createDataRequest");
    private final static QName _CreateDataResponse_QNAME = new QName("https://spring-boot-soap.alekseybykov.github.io/", "createDataResponse");
    private final static QName _GetDataRequest_QNAME = new QName("https://spring-boot-soap.alekseybykov.github.io/", "getDataRequest");
    private final static QName _GetDataResponse_QNAME = new QName("https://spring-boot-soap.alekseybykov.github.io/", "getDataResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: https.spring_boot_soap_alekseybykov_github
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateDataRequest }
     * 
     */
    public CreateDataRequest createCreateDataRequest() {
        return new CreateDataRequest();
    }

    /**
     * Create an instance of {@link CreateDataResponse }
     * 
     */
    public CreateDataResponse createCreateDataResponse() {
        return new CreateDataResponse();
    }

    /**
     * Create an instance of {@link GetDataRequest }
     * 
     */
    public GetDataRequest createGetDataRequest() {
        return new GetDataRequest();
    }

    /**
     * Create an instance of {@link GetDataResponse }
     * 
     */
    public GetDataResponse createGetDataResponse() {
        return new GetDataResponse();
    }

    /**
     * Create an instance of {@link Data }
     * 
     */
    public Data createData() {
        return new Data();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateDataRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateDataRequest }{@code >}
     */
    @XmlElementDecl(namespace = "https://spring-boot-soap.alekseybykov.github.io/", name = "createDataRequest")
    public JAXBElement<CreateDataRequest> createCreateDataRequest(CreateDataRequest value) {
        return new JAXBElement<CreateDataRequest>(_CreateDataRequest_QNAME, CreateDataRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateDataResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateDataResponse }{@code >}
     */
    @XmlElementDecl(namespace = "https://spring-boot-soap.alekseybykov.github.io/", name = "createDataResponse")
    public JAXBElement<CreateDataResponse> createCreateDataResponse(CreateDataResponse value) {
        return new JAXBElement<CreateDataResponse>(_CreateDataResponse_QNAME, CreateDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetDataRequest }{@code >}
     */
    @XmlElementDecl(namespace = "https://spring-boot-soap.alekseybykov.github.io/", name = "getDataRequest")
    public JAXBElement<GetDataRequest> createGetDataRequest(GetDataRequest value) {
        return new JAXBElement<GetDataRequest>(_GetDataRequest_QNAME, GetDataRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetDataResponse }{@code >}
     */
    @XmlElementDecl(namespace = "https://spring-boot-soap.alekseybykov.github.io/", name = "getDataResponse")
    public JAXBElement<GetDataResponse> createGetDataResponse(GetDataResponse value) {
        return new JAXBElement<GetDataResponse>(_GetDataResponse_QNAME, GetDataResponse.class, null, value);
    }

}
