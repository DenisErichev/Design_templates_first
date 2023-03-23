package Logger;

import Logger.Loggers.Ilogger;


public class Logger {
	private Ilogger ilogger;
	public Logger(Ilogger ilogger){
		this.ilogger = ilogger;
	}
	public Ilogger getLogger() {
		return ilogger;
	}
}
