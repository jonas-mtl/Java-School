package discordbot;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class NachrichtenReaktion extends ListenerAdapter {
	
	private String prefix;

	NachrichtenReaktion( String erhaltenerPrefix) {
		prefix = erhaltenerPrefix;
	}
	
	// Funktion, welche "onMessageReceived" ausgeführt wird
	public void onMessageReceived ( MessageReceivedEvent ereignis )
	{
		if(ereignis.isFromGuild()) 
		{
			System.out.println("Nachricht erhalten!");
			
			if (ereignis.getMessage().getContentStripped().startsWith(prefix + "hallo"))
			{
				ereignis.getChannel().sendMessage("Hallo" + ereignis.getAuthor().getAsMention() + ", ich bin jonas.").queue();
			}
		}
		
	}

}
