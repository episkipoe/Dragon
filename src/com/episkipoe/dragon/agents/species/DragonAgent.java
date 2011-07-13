package com.episkipoe.dragon.agents.species;

import com.episkipoe.dragon.agents.Agent;
import com.episkipoe.dragon.agents.skills.FearSkill;
import com.episkipoe.dragon.agents.skills.Skill;
import com.episkipoe.dragon.agents.skills.SneakSkill;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commerce.Cost;
import com.episkipoe.dragon.rooms.HireCommand;
import com.episkipoe.dragon.rooms.Room;
import com.episkipoe.dragon.treasure.MineSkill;
import com.episkipoe.dragon.treasure.TreasureList;
import com.episkipoe.dragon.treasure.gems.GoldTreasure;

public class DragonAgent extends Agent {
	public DragonAgent() { }
	public DragonAgent(int level) {
		super(level);
	}

	private static final long serialVersionUID = 9210869451727458206L;

	@Override
	public String getType() { return "Dragon"; } 
	
	public boolean can(Class<? extends Skill> type) {
		if (type == FearSkill.class) { return true; }
		if (type == SneakSkill.class) { return false; }
		return super.can(type);
	}

	//TODO  FireBreath at level 10
	public void postLevelUp() {
		int lvl = getLevel();
		if(lvl<5) {
			getSkillSet().awardXP(MineSkill.class, 2);
		} else {
			getSkillSet().awardXP(FearSkill.class, 2);
		}
			
	}
	public void postCreate() { }
	
	@Override
	public Command getHireCommand(Room room, int level) {
		TreasureList tl = new TreasureList();
		tl.add(new GoldTreasure(level*100));
		DragonAgent agent = new DragonAgent(level); 
		Cost cost = new Cost(tl);
		return new HireCommand(room, agent, cost);
	}
}
