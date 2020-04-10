package net.litetech.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;

import net.litetech.LiteTechVariables;
import net.litetech.LiteTechElements;

@LiteTechElements.ModElement.Tag
public class TimerProcedure extends LiteTechElements.ModElement {
	public TimerProcedure(LiteTechElements instance) {
		super(instance, 6);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		LiteTechVariables.time = (double) ((LiteTechVariables.time) + 1);
		if (((LiteTechVariables.time) >= 60)) {
			LiteTechVariables.time = (double) 0;
		}
		LiteTechVariables.crusher_timer = (double) ((LiteTechVariables.crusher_timer) + 1);
		if (((LiteTechVariables.crusher_timer) >= 10)) {
			LiteTechVariables.crusher_timer = (double) 0;
		}
	}

	@SubscribeEvent
	public void onWorldTick(TickEvent.WorldTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			World world = event.world;
			java.util.HashMap<String, Object> dependencies = new java.util.HashMap<>();
			dependencies.put("world", world);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
