package it.unipv.ingsw.progettoe20.client.ExitColumn.Model;
/*
  Questa classe rappresenta la colonna di uscita dal parcheggio, si occupa di controllare
  che il ticket sia valido per l'uscita verficandone l'obliterazione e il tempo intercorso,
  in caso positivo permette l'uscita del veicolo
  in caso negativo richiede di recarsi alla colonnina di obliterazione
*/

import it.unipv.ingsw.progettoe20.Protocol;
import it.unipv.ingsw.progettoe20.client.ClientConstants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ExitColumn {

    private Socket clientSocket;
    private Boolean isConnected;
    private BufferedReader in;
    private PrintWriter out;
    private String inputType;

    /**
     * Costruttore del client Exit column
     */

    public ExitColumn(String inputType) {
        try {
            this.inputType = inputType; //gli viene passato dal tester (args[0])
            clientSocket = new Socket(ClientConstants.HOST, ClientConstants.PORT);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            isConnected = true;
            checkInputType(); //verifica se viene utilizzata GUI o cli
        } catch (IOException i) {
            isConnected = false;
        }
    }

    /**
     * Metodo che verifica la metodologia di input (GUI o cli)
     */
    public void checkInputType() {
        if (inputType.equals("cli")) {
            String insertText = "";
            Scanner scanner = new Scanner(System.in);
            while (true) {

                System.out.println("Hai scelto la modlità command line input, inserisci il TicketID o exit per terminare.");
                insertText = scanner.next();
                if (insertText.equals("exit")) break; //Viene chiamata l'uscita
                checkObliteration(insertText);
            }
            System.out.println("Hai terminato l'esecuzione");
            System.exit(0);

        } else System.out.println("GUI avviata");

    }


    /**
     * Metodo che richiede la conferma di corretta obliterazione
     *
     * @param id
     * @return Response Enum con i vari esiti del check
     */
    public ResponseEnum checkObliteration(String id) {
        System.out.println("perform request...");

        if (checkId(id)) {
            try {
                out.println(Protocol.REQUEST_PAYMENT_CHECK+ Protocol.SEPARATOR + id);
                String answer = in.readLine();
                System.out.println(answer);
                if (answer.equals(Protocol.RESPONSE_PAID_TRUE)) {
                    deleteTicket(id);       //commentarlo in caso di test per prevenire cancellazione record
                    return ResponseEnum.CONFIRMED_EXIT;
                } else return ResponseEnum.NO_PAID;
            } catch (IOException i) {
                return ResponseEnum.ERROR_GENERIC;
            } catch (NullPointerException n) {
                isConnected = false;
                return ResponseEnum.ERROR_GENERIC;
            }
        } else return ResponseEnum.NO_ID_FOUND;

    }

    /**
     * Metodo che elimina il Ticket
     *
     * @param id
     * @return true se il ticket (a cui è associato l'id) è stato eliminato,false in caso contrario
     */
    public Boolean deleteTicket(String id) {
        try {
            out.println(Protocol.REQUEST_DELETE_ID + Protocol.SEPARATOR + id);
            String answer = in.readLine();
            System.out.println(answer);
            return answer.equals(Protocol.RESPONSE_OK);
        } catch (IOException i) {
            return false;
        } catch (NullPointerException n) {
            isConnected = false;
            return false;
        }

    }

    /**
     * metodo che cerca l'id nel database
     *
     * @param id
     * @return true se l'id é presente nel database, false se invece non lo è
     */
    public boolean checkId(String id) {
        try {
            out.println(Protocol.REQUEST_CHECK_ID + Protocol.SEPARATOR + id);
            String answer = in.readLine();
            System.out.println(answer);
            return answer.equals(Protocol.RESPONSE_ID_FOUND);
        } catch (IOException i) {
            return false;
        } catch (NullPointerException n) {
            isConnected = false;
            return false;
        }
    }

    /**
     * metodo per chiudere il clientSocket
     */
    public void closeSocket() {
        try {
            clientSocket.close();
        } catch (IOException i) {
            System.out.println("Socket Error");
        } catch (NullPointerException n) {
            isConnected = false;
        }
    }

    //getter per avvisare stato connessione con il Server
    public Boolean getIsConnected() {
        return isConnected;
    }
}
