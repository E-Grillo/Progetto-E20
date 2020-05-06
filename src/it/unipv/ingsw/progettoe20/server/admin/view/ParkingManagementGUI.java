package it.unipv.ingsw.progettoe20.server.admin.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import it.unipv.ingsw.progettoe20.server.admin.controller.ParkingListener;

/*
 * Classe per la gestione del parcheggi.
 * Si può modificare il numero di parcheggi disponibili nella struttura.
 */
public class ParkingManagementGUI extends JFrame {

	private JComboBox<String> combo;
	private JTextField field;
	private JLabel title, inserthere;
	private JPanel panel, panel2;
	private JButton confirm, home;
	private ParkingListener listener;

	public ParkingManagementGUI() {

		panel = new JPanel();
		panel2 = new JPanel();
		title = new JLabel("PARKING MANAGEMENT");
		inserthere = new JLabel("Insert here:  ");
		field = new JTextField(10);
		confirm = new JButton("Confirm");
		home = new JButton("Home");

		String[] items = { "Add parkings", "Remove parkings" };
		combo = new JComboBox<>(items);

		// frame settings
		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(600, 400);
		setLocation(340, 240);
		setTitle("PARKING MANAGEMENT GUI");

		// panel settings
		panel.setBackground(new Color(30, 30, 30));
		panel.setLayout(null);

		// panel2 settings
		panel2.setBackground(new Color(30, 30, 30));
		panel2.setLayout(new FlowLayout());

		// title settings
		title.setFont(new Font(Font.MONOSPACED, 3, 30));
		title.setForeground(new Color(196, 10, 255));

		// inserthere settings
		inserthere.setFont(new Font(Font.MONOSPACED, 1, 16));
		inserthere.setForeground(new Color(196, 10, 255));
		inserthere.setAlignmentX(LEFT_ALIGNMENT);

		// connfirm settings
		confirm.setFont(new Font(Font.MONOSPACED, 1, 20));
		confirm.setBackground(new Color(222, 177, 255));

		// goback settings
		home.setFont(new Font(Font.MONOSPACED, 0, 10));
		home.setBackground(new Color(222, 177, 255));

		// textfield settings
		field.setFont(new Font(Font.MONOSPACED, 0, 24));
		field.setAlignmentX(RIGHT_ALIGNMENT);
		field.setForeground(new Color(196, 10, 255));

		// combobox settings
		combo.setFont(new Font(Font.MONOSPACED, 0, 16));

		// locations settings
		title.setBounds(250, 10, 500, 40);
		confirm.setBounds(190, 230, 200, 40);
		panel2.setBounds(140, 180, 300, 30);
		combo.setBounds(140, 130, 300, 30);
		home.setBounds(25, 20, 100, 20);

		panel.add(title);
		panel.add(combo);
		panel.add(panel2);
		panel.add(confirm);
		panel.add(home);

		panel2.add(inserthere);
		panel2.add(field);

		// listener settings
		listener = new ParkingListener(this);
		confirm.addActionListener(listener);
		home.addActionListener(listener);
	}

	public JComboBox<String> getCombo() {
		return combo;
	}

	public JButton getHome() {
		return home;
	}

	public JTextField getField() {
		return field;
	}

	public JButton getConfirm() {
		return confirm;
	}

}
