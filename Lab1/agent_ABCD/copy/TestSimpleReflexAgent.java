package chapter2.agent_ABCD.copy; 

public class TestSimpleReflexAgent {
	public static void main(String[] args) {
		Environment env = new Environment(Environment.LocationState.CLEAN, Environment.LocationState.DIRTY);
		Agent agent = new Agent(new AgentProgram());
		env.addAgent(agent, Environment.LOCATION_A);
//		env.addAgent(agent, Environment.LOCATION_B);
		env.stepUntilDone(10);
	}
}
