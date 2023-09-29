package chapter2.agent_ABCD.copy;

import java.util.HashMap;
import java.util.Map;

import chapter2.agent_AB.Environment.LocationState;

public class EnvironmentState {
	private Map<String, Environment.LocationState> state = new HashMap<String, Environment.LocationState>();
	private String agentLocation = null;
	private int sc;

	public EnvironmentState(Environment.LocationState locAState, Environment.LocationState locBState,
			Environment.LocationState locCState, Environment.LocationState locDState) {
		this.state.put(Environment.LOCATION_A, locAState);
		this.state.put(Environment.LOCATION_B, locBState);
		this.state.put(Environment.LOCATION_C, locBState);
		this.state.put(Environment.LOCATION_D, locBState);
	}

	public int getSc() {
		return sc;
	}

	public void setSc(int sc) {
		this.sc = sc;
	}

	
	public void setAgentLocation(String location) {
		this.agentLocation = location;
	}

	public String getAgentLocation() {
		return this.agentLocation;
	}

	public chapter2.agent_ABCD.copy.Environment.LocationState getLocationState(String location) {
		return this.state.get(location);
	}

	public void setLocationState(String location, chapter2.agent_ABCD.copy.Environment.LocationState locationState) {
		this.state.put(location, locationState);
	}

	public void display() {
		System.out.println("Environment state: \n\t" + this.state);
	}
	
}