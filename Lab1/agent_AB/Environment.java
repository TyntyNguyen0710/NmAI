package chapter2.agent_AB;

public class Environment {
	public static final Action MOVE_LEFT = new DynamicAction("LEFT");
	public static final Action MOVE_UP = new DynamicAction("UP");
	public static final Action MOVE_DOWN = new DynamicAction("DOWN");
	public static final Action MOVE_RIGHT = new DynamicAction("RIGHT");
	public static final Action SUCK_DIRT = new DynamicAction("SUCK");
	public static final String LOCATION_A = "A";
	public static final String LOCATION_B = "B";
	public static final String LOCATION_C = "C";
	public static final String LOCATION_D = "D";

	public enum LocationState {
		CLEAN, DIRTY
	}

	private EnvironmentState envState;
	private boolean isDone = false;// all squares are CLEAN
	private Agent agent = null;

	public Environment(LocationState locAState, LocationState locBState) {
		envState = new EnvironmentState(locAState, locBState);
	}

	// add an agent into the enviroment
	public void addAgent(Agent agent, String location) {
		this.agent = agent;
		envState.setAgentLocation(location);
	}

	public EnvironmentState getCurrentState() {
		return this.envState;
	}

	public static Action getMoveLeft() {
		return MOVE_LEFT;
	}

	public static Action getMoveRight() {
		return MOVE_RIGHT;
	}

	public static Action getSuckDirt() {
		return SUCK_DIRT;
	}

	public static String getLocationA() {
		return LOCATION_A;
	}

	public static String getLocationB() {
		return LOCATION_B;
	}

	// get percept<AgentLocation, LocationState> at the current location where agent
	// is in.
	public Percept getPerceptSeenBy() {
		return new Percept(envState.getAgentLocation(), envState.getLocationState(envState.getAgentLocation()));// vi
																												// tri,
																												// do
																												// hay
																												// ban
	}

	public void step() {
		envState.display();
		String agentLocation = this.envState.getAgentLocation();
		Action anAction = agent.execute(getPerceptSeenBy());
		EnvironmentState es = executeAction(anAction);

		System.out.println("Agent Loc.: " + agentLocation + "\tAction: " + anAction);

		if ((es.getLocationState(LOCATION_A) == LocationState.CLEAN)
				&& (es.getLocationState(LOCATION_B) == LocationState.CLEAN))
			isDone = true;// if both squares are clean, then agent do not need to do any action
		es.display();
	}

	public void stepUntilDone() {
		int i = 0;

		while (!isDone) {
			System.out.println("step: " + i++);
			step();
		}
	}

	// Update enviroment state when agent do an action
	public EnvironmentState executeAction(Action action) {
		if (action.equals(SUCK_DIRT)) {
			envState.setLocationState(envState.getAgentLocation(), LocationState.CLEAN);
		} else if (action == MOVE_LEFT) {
			envState.setAgentLocation(LOCATION_B);
		} else {
			envState.setAgentLocation(LOCATION_A);
		}
		return envState;
	}
}
