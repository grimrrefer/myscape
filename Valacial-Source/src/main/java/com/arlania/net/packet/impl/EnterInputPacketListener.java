package com.arlania.net.packet.impl;

import com.arlania.net.packet.Packet;
import com.arlania.net.packet.PacketListener;
import com.arlania.util.Misc;
import com.arlania.world.entity.impl.player.Player;

/**
 * This packet manages the input taken from chat box interfaces that allow input,
 * such as withdraw x, bank x, enter name of friend, etc.
 * 
 * @author Gabriel Hannason
 */

public class EnterInputPacketListener implements PacketListener {


	@Override
	public void handleMessage(Player player, Packet packet) {
		if (player.requiresPin())
			return;
		switch (packet.getOpcode()) {
		case ENTER_SYNTAX_OPCODE:
			String name = Misc.readString(packet.getBuffer());
			System.err.println("EnterInputPacketListener " + name);
			if(name == null)
				return;
			if(player.getInputHandling() != null)
				player.getInputHandling().handleSyntax(player, name);
			player.setInputHandling(null);
			break;
			case ENTER_AMOUNT_OPCODE:
			int amount = packet.readInt();
			if(amount <= 0)
				return;
			if(player.getInputHandling() != null)
				player.getInputHandling().handleAmount(player, amount);
			player.setInputHandling(null);
			break;
		}
	}

	public static final int ENTER_AMOUNT_OPCODE = 208, ENTER_SYNTAX_OPCODE = 60;
}