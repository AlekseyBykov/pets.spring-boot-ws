package alekseybykov.portfolio.springboot.mtom.ws.exchanger;

import alekseybykov.portfolio.springboot.mtom.ws.consts.IOConsts;
import alekseybykov.portfolio.springboot.mtom.ws.mapping.FileMapper;
import org.apache.commons.lang3.math.NumberUtils;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Aleksey Bykov
 * @since 28.06.2020
 */
public class FileExchangerImpl implements FileExchanger {

	private static final String EXCHANGE_FOLDER_PATH = System.getProperty("user.dir").concat("/exchanger/");

	@Override
	public void uploadFile(FileMapper fileMapper) {
		DataHandler dataHandler = fileMapper.getDataHandler();
		try (InputStream inputStream = dataHandler.getInputStream();
		        OutputStream outputStream = new FileOutputStream(new File(String.format("%s%s.%s",
			        EXCHANGE_FOLDER_PATH, fileMapper.getFileName(), fileMapper.getFileExt())))) {
			int readedBytes;
			byte[] buffer = new byte[IOConsts.BUFFER_SIZE.getName()];
			while ((readedBytes = inputStream.read(buffer)) != IOConsts.EOF.getName()) {
				outputStream.write(buffer, NumberUtils.INTEGER_ZERO, readedBytes);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	@Override
	public DataHandler downloadFile(String fileName) {
		DataHandler result = null;
		File file = new File(String.format("%s%s", EXCHANGE_FOLDER_PATH, fileName));
		if (file.isFile() && file.exists()) {
			result = new DataHandler(new FileDataSource(file));
		}
		return result;
	}
}
