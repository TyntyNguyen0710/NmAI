package chapter2.agent_ABCD.copy;

import chapter2.agent_AB.Environment.LocationState;

public class Percept {
	private String agentLocation;
	private chapter2.agent_ABCD.copy.Environment.LocationState state;

	public Percept(String agentLocation, chapter2.agent_ABCD.copy.Environment.LocationState locationState) {
		this.agentLocation = agentLocation;
		this.state = locationState;
	}

	public chapter2.agent_ABCD.copy.Environment.LocationState getLocationState() {
		return this.state;
	}

	public String getAgentLocation() {
		return this.agentLocation;
	}
}