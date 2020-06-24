package alekseybykov.portfolio.springboot.ws.callback;

import org.apache.wss4j.common.ext.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Aleksey Bykov
 * @since 24.06.2020
 */
public class ServiceSideUTPCallback implements CallbackHandler {

	private Map<String, String> credentials = new HashMap<>();

	public ServiceSideUTPCallback() {
		credentials.put("some username", "some password");
	}

	@Override
	public void handle(Callback[] callbacks) {
		for (Callback callback : callbacks) {
			WSPasswordCallback wsPasswordCallback = (WSPasswordCallback) callback;
			String password = credentials.get(wsPasswordCallback.getIdentifier());
			wsPasswordCallback.setPassword(password);
			return;
		}
	}
}
