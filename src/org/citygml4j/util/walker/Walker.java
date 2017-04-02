package org.citygml4j.util.walker;

public class Walker {
	protected boolean shouldWalk = true;
	
	public Walker() {
	}
	
	public void reset() {		
		shouldWalk = true;
	}
	
	public boolean shouldWalk() {
		return shouldWalk;
	}
	
	public void setShouldWalk(boolean shouldWalk) {
		this.shouldWalk = shouldWalk;
	}
	
}
