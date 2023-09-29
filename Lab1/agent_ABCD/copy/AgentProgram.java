package chapter2.agent_ABCD.copy;

import java.util.Random;

public class AgentProgram {

	public Action execute(Percept p) {// location, status
		Random rd = new Random();
		int rdindex = rd.nextInt(4);
		if (p.getLocationState() == Environment.LocationState.DIRTY) {
			return Environment.SUCK_DIRT;
		} else {
			if (rdindex == 0) {
				return Environment.MOVE_LEFT;
			} else if (rdindex == 1) {
				return Environment.MOVE_RIGHT;
			} else if (rdindex == 2) {
				return Environment.MOVE_UP;
			} else if (rdindex == 3) {
				return Environment.MOVE_DOWN;
//			} else if (rdindex == 0) {
//				return Environment.MOVE_LEFT;
			}
		}
		return null;

	}
}