package alekseybykov.portfolio.springboot.mtom.ws.mapping;

import javax.activation.DataHandler;

/**
 * @author Aleksey Bykov
 * @since 28.06.2020
 */
public class FileMapper {

	private String fileName;
	private String fileExt;

	private DataHandler dataHandler;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileExt() {
		return fileExt;
	}

	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}

	public DataHandler getDataHandler() {
		return dataHandler;
	}

	public void setDataHandler(DataHandler dataHandler) {
		this.dataHandler = dataHandler;
	}
}
