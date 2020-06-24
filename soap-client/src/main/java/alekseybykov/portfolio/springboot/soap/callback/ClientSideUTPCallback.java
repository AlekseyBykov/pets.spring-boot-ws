package alekseybykov.portfolio.springboot.soap.callback;

import org.apache.wss4j.common.ext.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;

/**
 * @author Aleksey Bykov
 * @since 24.06.2020
 */
public class ClientSideUTPCallback implements CallbackHandler {

	@Override
	public void handle(Callback[] callbacks) {
		for (Callback callback : callbacks) {
			WSPasswordCallback wsPasswordCallback = (WSPasswordCallback) callback;
			if ("some username".equals(wsPasswordCallback.getIdentifier())) {
				wsPasswordCallback.setPassword("some password");
				return;
			}
		}
	}
}
