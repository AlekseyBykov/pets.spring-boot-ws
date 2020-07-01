package alekseybykov.portfolio.springboot.mtom.ws.exchanger;

import alekseybykov.portfolio.springboot.mtom.ws.mapping.FileMapper;

import javax.activation.DataHandler;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Aleksey Bykov
 * @since 28.06.2020
 */
@WebService
public interface FileExchanger {

	void uploadFile(@WebParam(name = "file") FileMapper fileMapper);

	DataHandler downloadFile(@WebParam(name = "file") String fileName);
}
