package alekseybykov.portfolio.springboot.soap.fixture;

import https.spring_boot_soap_alekseybykov_github.Data;

/**
 * @author Aleksey Bykov
 * @since 19.06.2020
 */
public class DataFixture {
	public static Data getFixture() {
		Data data = new Data();
		data.setName("some name");
		data.setDescription("some description");
		return data;
	}
}
