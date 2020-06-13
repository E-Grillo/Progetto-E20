package it.unipv.ingsw.progettoe20.client.ExitColumn.View;

import javax.swing.*;
import java.awt.*;

/**
 * GUI principale del client ExitColumn
 * uso librerie grafiche per layout
 * le pic sono contenute tutte nella resources del progetto.
 */
public class ExitColumnGUI extends javax.swing.JFrame {

    /**
     * Costruttore Exit column gui.
     */
    public ExitColumnGUI() {
        initComponents();
    }


    private void initComponents() {

        this.setTitle("Parking Exit Column");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/ParkingPic.png")));

        pannello = new javax.swing.JPanel(); //pannello principale
        buttonTicket = new javax.swing.JButton(); //bottone inserisci ticket
        jTextField1 = new javax.swing.JTextField(); //campo per inserire il ticket
        jLabel1 = new javax.swing.JLabel(); //pic biglietto
        jLabel2 = new javax.swing.JLabel(); //testo e pic colonnina uscita


        //impostazioni del frame
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 500));
        setResizable(false); //impedire ridimensionamento

        //impostazioni pannello
        pannello.setBackground(new java.awt.Color(20, 10, 40));
        pannello.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        //impostazioni bottone
        buttonTicket.setBackground(new java.awt.Color(255, 255, 255));
        buttonTicket.setFont(new java.awt.Font("Tahoma", 0, 18));
        buttonTicket.setText("INSERT");

        pannello.add(buttonTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 230, 58));

        //impostazioni campo ticket
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18));
        jTextField1.setText("Ticket ID");

        pannello.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 270, 50));

        //impostazioni label ticket logo
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TicketPic.png")));
        pannello.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 180, 110));

        //impostazioni labelo exit column e logo
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ParkingPic.png")));
        jLabel2.setText("EXIT COLUMN");
        pannello.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        //impostazioni di layout
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(pannello, javax.swing.GroupLayout.PREFERRED_SIZE, 901, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(pannello, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }



    /**
     * Metodo per richiamare il pannello errore di connessione.
     */
    public void errorConnection() {
        UIManager.put("OptionPane.background", Color.black);
        UIManager.put("OptionPane.messageForeground", Color.WHITE);
        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 18));
        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
        UIManager.getLookAndFeelDefaults().put("Panel.background", Color.black);
        JOptionPane.showMessageDialog(null, "An error occurred: connection to server failed", "Error", 1, new javax.swing.ImageIcon(getClass().getResource("/ErrorPic2.png")));

    }

    /**
     * metodo errori generici.
     */
    public void errorGeneric() {
        UIManager.put("OptionPane.background", Color.black);
        UIManager.put("OptionPane.messageForeground", Color.WHITE);
        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 18));
        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
        UIManager.getLookAndFeelDefaults().put("Panel.background", Color.black);
        JOptionPane.showMessageDialog(null, "Generic Error occurred!", "Error", 1, new javax.swing.ImageIcon(getClass().getResource("/GenericError.png")));

    }


    // Dichiarazione varibili
    private javax.swing.JButton buttonTicket;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel pannello;
    private JPanel panelCheckFalse = new PanelCheckFalse();
    private JPanel panelCheckNoID = new PanelCheckNoID();
    private JPanel panelCheckTrue = new PanelCheckTrue();


    //Getter componenti per listener

    /**
     * Getter bottone buttonTicket.
     *
     * @return il buttonTicket
     */
    public JButton getButtonTicket() {
        return buttonTicket;
    }

    /**
     * Getter text field 1.
     *
     * @return il text field 1
     */
    public JTextField getjTextField1() {
        return jTextField1;
    }

    /**
     * Getter pannello.
     *
     * @return pannello
     */
    public JPanel getPannello() {
        return pannello;
    }

    /**
     * Getter pannello checkFalse.
     *
     * @return il pannello checkFalse
     */
    public JPanel getPanelCheckFalse() {
        return panelCheckFalse;
    }

    /**
     * Getter pannello checkNoId.
     *
     * @return il pannello checkNoId
     */
    public JPanel getPanelCheckNoID() {
        return panelCheckNoID;
    }

    /**
     * Getter pannello checkTrue.
     *
     * @return il pannello checkTrue
     */
    public JPanel getPanelCheckTrue() {
        return panelCheckTrue;
    }
}


