package net.kupoapo.skymagic.procedures;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.io.BufferedWriter;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ConfigOnLoadProcedure {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		execute();
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		File file_config = new File("");
		com.google.gson.JsonObject file_json = new com.google.gson.JsonObject();
		file_config = new File("config", File.separator + "sky_magic.json");
		if (!file_config.exists()) {
			try {
				file_config.getParentFile().mkdirs();
				file_config.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			try {
				FileWriter file_configwriter = new FileWriter(file_config);
				BufferedWriter file_configbw = new BufferedWriter(file_configwriter);
				{
					file_configbw.write("{ \"test\": \"test\" }");
				}
				file_configbw.close();
				file_configwriter.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
	}
}
