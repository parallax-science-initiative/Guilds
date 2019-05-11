package parallaxscience.guilds;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import parallaxscience.guilds.alliance.AllianceCache;
import parallaxscience.guilds.commands.CommandAlliance;
import parallaxscience.guilds.commands.CommandGuild;
import parallaxscience.guilds.events.ChunkEvents;
import parallaxscience.guilds.events.GuildEvents;
import parallaxscience.guilds.guild.ChunkCache;
import parallaxscience.guilds.guild.GuildCache;

@Mod(modid = Guilds.MODID, name = Guilds.NAME, version = Guilds.VERSION, acceptedMinecraftVersions = Guilds.MC_VERSION, acceptableRemoteVersions = "*")
public class Guilds
{
    static final String MODID = "guilds";
    static final String NAME = "The Guilds Mod";
    static final String VERSION = "ALPHA 1.0";
    static final String MC_VERSION = "[1.12.2]";

    public static final int claimPerPlayer = 50;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new GuildEvents());
        MinecraftForge.EVENT_BUS.register(new ChunkEvents());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        GuildCache.initialize();
        AllianceCache.initialize();
        ChunkCache.initialize();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

    @Mod.EventHandler
    public void onServerStart(FMLServerStartingEvent event)
    {
        event.registerServerCommand(new CommandGuild());
        event.registerServerCommand(new CommandAlliance());
    }
}