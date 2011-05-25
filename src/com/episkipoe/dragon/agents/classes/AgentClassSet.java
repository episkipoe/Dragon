package com.episkipoe.dragon.agents.classes;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AgentClassSet implements Serializable {
	private static final long serialVersionUID = 7184577241196208671L;
	
	public AgentClassSet() {
		resetAgentClasses();
	}
	public AgentClassSet(AgentClass s) {
		resetAgentClasses();
		add(s);
	}
	public AgentClassSet(Collection<AgentClass> sList) {
		resetAgentClasses();
		for(AgentClass s: sList) add(s);
	}
	
	public void resetAgentClasses() {
		classes = new HashMap<Class<? extends AgentClass>,AgentClass>();
	}
	
	private Map<Class<? extends AgentClass>, AgentClass> classes;
	public void add(AgentClass s) { classes.put(s.getClass(), s); }
	public AgentClass getAgentClass(Class<? extends AgentClass> s) { return classes.get(s); }
	public boolean hasAgentClass(Class<? extends AgentClass> s) { return classes.containsKey(s); }
	public int numAgentClasses() { return classes.size(); }
	
	public Collection<AgentClass> getAgentClasses () { return classes.values(); }	
}
