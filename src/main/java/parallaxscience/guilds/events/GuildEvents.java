package parallaxscience.guilds.events;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import parallaxscience.guilds.guild.GuildCache;
import parallaxscience.guilds.guild.Guild;
import java.util.UUID;

/**
 * EventHandler class for guild events
 * @author Tristan Jay
 */
public class GuildEvents {

    /**
     * Called whenever someone sends a message in the chat
     * Adds a colored guild header to the message if the player is in a guild
     * @param event ServerChatEvent
     * @see ServerChatEvent
     */
    @SubscribeEvent
    @SuppressWarnings("unused")
    public void onServerChat(ServerChatEvent event)
    {
        UUID playerID = event.getPlayer().getUniqueID();
        Guild guild = GuildCache.getPlayerGuild(playerID);
        if(guild != null)
        {
            //FIX THIS
            ITextComponent textComponent = new TextComponentString("<" + guild.getGuildName() + ">").appendSibling(event.getComponent());
            textComponent.setStyle(guild.getColor());
            event.setComponent(textComponent);
        }
    }
}
