package com.episkipoe.dragon.player;

import java.util.ArrayList;
import java.util.List;

import android.view.View;

import com.episkipoe.dragon.Main;
import com.episkipoe.dragon.commands.Command;
import com.episkipoe.dragon.commands.CommandPage;
import com.episkipoe.dragon.lairs.LairList;

public class MainPage extends CommandPage {
	private static final long serialVersionUID = 4968437847063920393L;

	@Override
	public String getCommandName() { return "Main Menu"; }
	
	protected boolean hasBackButton() { return false; }
	
	private class ListNeighbors extends CommandPage {
		private static final long serialVersionUID = -916989669844708976L;
		
		protected void prepareCommands() {
			commandList =new ArrayList<Command>();
			List<LairList> kingdoms = Main.player.getNeighboringKingdoms();
			if(kingdoms==null) return;
			for(LairList ll : kingdoms) {
				commandList.add(ll);
			}
		}
		@Override
		public String getCommandName() { return "Visit another realm"; }
	}
	
	private class NewGameCommand extends Command {
		private static final long serialVersionUID = -512445016714745945L;

		public void onClick(View arg0) {
			try {
				Player.newGame(Main.player.getActivity());
				Main.player.popupNotify("The world has been reset");
			} catch (Exception e) {
				e.printStackTrace();
				Main.player.popupNotify("Could not start new game: ");
			}
		}

		@Override
		public String getCommandName() { return "New Game"; }
	}
	
	protected void prepareCommands() {
		commandList = new ArrayList<Command>();
		commandList.add(Main.player.getLairList());	
		commandList.add(new ListNeighbors());
		commandList.add(Main.player.getAgentDisplay());
		commandList.add(new NewGameCommand());
	}
}
