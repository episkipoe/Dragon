package com.episkipoe.dragon.lairs;

import java.util.ArrayList;
import java.util.List;

import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commands.CommandPage;

public class LairBuilder extends CommandPage {
	private static final long serialVersionUID = -6236471632114696733L;

	LairList lairs;
	public LairBuilder(LairList lairs) {
		this.lairs = lairs;
	}

	@Override
	public String getCommandName() { return "Add Lair"; }
	
	final protected void prepareCommands() {
		commandList =new ArrayList<Command>();
		List<Command> buildCommands = getLairBuildCommands();
		if(buildCommands != null) commandList.addAll(buildCommands); 	
	}
	
	final public List<Command> getLairBuildCommands() {
		List<Class<? extends Lair>> lairList = LairList.availableTypes();
		if(lairList == null) return null;
		List<Command> cmds = new ArrayList<Command>();
		for(Class<? extends Lair> type : lairList) {
			try {
				Lair l = type.newInstance();
				Command cmd = l.getBuildCommand(lairs);
				if(cmd==null) continue;
				cmds.add(cmd);
			} catch(Exception e) {
				System.out.println("Execption adding " + type.toString() + " : " + e.toString());
			}
		}
		return cmds;
	}


}
