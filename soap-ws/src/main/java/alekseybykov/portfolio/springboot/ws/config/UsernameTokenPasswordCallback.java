package alekseybykov.portfolio.springboot.ws.config;

import org.apache.wss4j.common.ext.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Aleksey Bykov
 * @since 23.06.2020
 */
public class UsernameTokenPasswordCallback implements CallbackHandler {

	private Map<String, String> credentials = new HashMap<>();

	public UsernameTokenPasswordCallback() {
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
