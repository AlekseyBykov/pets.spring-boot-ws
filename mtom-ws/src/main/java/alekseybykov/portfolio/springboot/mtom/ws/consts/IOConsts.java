package alekseybykov.portfolio.springboot.mtom.ws.consts;

/**
 * @author Aleksey Bykov
 * @since 28.06.2020
 */
public enum IOConsts {
	EOF(-1),
	BUFFER_SIZE(8 * 1024);

	private int name;

	IOConsts(int name) {
		this.name = name;
	}

	public int getName() {
		return name;
	}
}
