package main;

public class MonitorFunctions {
	ApiHandler api = new ApiHandler();
	
	public int getLastEventType() {
		try{
			EventTrace[] traces = api.getTraces();

			if(traces.length < 1) {
				return -1;
			}
			return traces[traces.length - (1 + (traces.length >= 2? 1: 0))].eventLogType;
		} catch (Exception e) {
			return -1;
		}

	}
}
