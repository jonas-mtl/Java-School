package discordbot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Hauptklasse {

	public static void main(String[] args) {
		
		// Bot Variablen festlegen
		final String token = "MTA3MjUyNjkzMzgwMTMyNDYxNg.GwTkvG.edwkm8FHC56E1OSes2l3xozpoqIEOJRt_Vmpew";
		final String prefix = "js!";
		
		final String status = "mein Status";
		
		// Erstellt einen Java Discord API (JDA) "Bauplan"
		JDABuilder bauplan = JDABuilder.createDefault(token);
		
		// Erlaube dem Bot Nachrichten Inhalte zu lesen
		bauplan.enableIntents(GatewayIntent.MESSAGE_CONTENT);

		// Setze Status auf online
		bauplan.setStatus(OnlineStatus.ONLINE);
		
		// Statusnachricht anzeigen
		bauplan.setActivity(Activity.watching(status));
		
		
		// Nachrichtenempfänger aktivieren
		bauplan.addEventListeners(new NachrichtenReaktion(prefix));
		
		// Bot starten
		JDA bot = bauplan.build();

		
		System.out.println("--- Der Bot ist jetzt online! ---");
		System.out.println("Dein Prefix: " + prefix);
	}

}
