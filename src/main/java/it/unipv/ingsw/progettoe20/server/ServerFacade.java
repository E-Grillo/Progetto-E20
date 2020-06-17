package it.unipv.ingsw.progettoe20.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import it.unipv.ingsw.progettoe20.ErrorStrings;
import it.unipv.ingsw.progettoe20.server.cli.CommandLineInterface;
import it.unipv.ingsw.progettoe20.server.database.DatabaseFacade;
import it.unipv.ingsw.progettoe20.server.requestsHandling.RequestHandler;

//TODO JAVADOC
public class ServerFacade {
	private DatabaseFacade dbManager;
	private CommandLineInterface cli;

	public void init() {
		dbManager = DatabaseFacade.getInstance();
		cli = new CommandLineInterface();

		dbManager.initDatabase();
	}

	public void start() {
		cli.start();

		try {
			// Start server
			ServerSocket server = new ServerSocket(ServerConstants.PORT);
			while (true) {
				Socket socket = server.accept();
				PrintWriter socketWriter = new PrintWriter(socket.getOutputStream(), true);
				RequestHandler requestHandler = new RequestHandler(dbManager, socketWriter);
				ClientHandler clientHandler = new ClientHandler(socket, requestHandler,
						ServerConstants.HANDLER_THREAD_NAME);
				clientHandler.start();
			}
		} catch (IOException e) {
			Logger.log(ErrorStrings.SERVER_START_FAIL);
		}
	}
}
