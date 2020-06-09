package it.unipv.ingsw.progettoe20.server.switchCommands;

import it.unipv.ingsw.progettoe20.Protocol;
import it.unipv.ingsw.progettoe20.server.Logger;
import it.unipv.ingsw.progettoe20.server.database.DatabaseFacade;

import java.io.PrintWriter;

public class CommandPayCheck extends Command{
    public CommandPayCheck(DatabaseFacade dbFacade, PrintWriter out) {
        super(dbFacade, out);
    }

    @Override
    public boolean handleRequest(String s) {
        try {
            if (dbFacade.getTicketById(s).obliterationCheck()) {
                out.println(Protocol.RESPONSE_PAID_TRUE);
            } else {
                out.println(Protocol.RESPONSE_PAID_FALSE);
            }
        } catch (IllegalArgumentException i) {
            Logger.log(i.getMessage());
            out.println(Protocol.RESPONSE_ERROR + Protocol.SEPARATOR + i.getMessage());
        }
        return false;
    }
}
