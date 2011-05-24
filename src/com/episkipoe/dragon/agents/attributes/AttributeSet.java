package com.episkipoe.dragon.agents.attributes;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.episkipoe.dragon.agents.Agent;

public class AttributeSet {
	public AttributeSet() {
		resetAttributes();
	}
	public AttributeSet(Attribute a) {
		resetAttributes();
		add(a);
	}
	public AttributeSet(Collection<Attribute> aList) {
		resetAttributes();
		for(Attribute a: aList) add(a);
	}
	
	public void levelUp(Agent agent) {
		for(Attribute a : getAttributes()) a.levelUp(agent);
	}
	
	public void resetAttributes() {
		Attributes = new HashMap<Class<? extends Attribute>,Attribute>();
	}
	
	private Map<Class<? extends Attribute>, Attribute> Attributes;
	public void add(Attribute a) { Attributes.put(a.getClass(), a); }
	public Attribute getAttribute(Class<? extends Attribute> a) { return Attributes.get(a); }
	public boolean hasAttribute(Class<? extends Attribute> a) { return Attributes.containsKey(a); }
	public int getAttributeLevel(Class<? extends Attribute> a) {
		if(!hasAttribute(a)) return 0;
		return getAttribute(a).level;
	}
	public int numAttributes() { return Attributes.size(); }
	public int totalAttribute() { 
		int total=0;
		for(Attribute a : getAttributes()) total += a.level;
		return total;
	}
	public double averageAttribute() {
		if(numAttributes() <=0) return 0.0;
		double total=0;
		for(Attribute a : getAttributes()) total += a.level;
		total/=numAttributes();
		return total;
	}
	
	//TODO:  items that modify Attributes
	public int totalModifiers() { return 0; }

	public Collection<Attribute> getAttributes () { return Attributes.values(); }	
}
