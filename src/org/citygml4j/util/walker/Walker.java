package org.citygml4j.util.walker;

public interface Walker {
	public void reset();
	public boolean shouldWalk();	
	public void setShouldWalk(boolean shouldWalk);
	public boolean addToVisited(Object object);
	public boolean hasVisited(Object object);
}
