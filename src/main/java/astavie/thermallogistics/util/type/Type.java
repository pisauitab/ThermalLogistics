package astavie.thermallogistics.util.type;

import astavie.thermallogistics.util.StackHandler;
import cofh.core.gui.GuiContainerCore;
import cofh.core.network.PacketBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public interface Type<I> {

	I getAsStack();

	I withAmount(int amount);

	String getDisplayName();

	void writePacket(PacketBase packet);

	@SideOnly(Side.CLIENT)
	default List<String> getTooltip(GuiContainerCore gui) {
		return StackHandler.getTooltip(gui, getAsStack());
	}

	@SideOnly(Side.CLIENT)
	default void render(GuiContainerCore gui, int x, int y) {
		StackHandler.render(gui, x, y, getAsStack(), null);
	}

}