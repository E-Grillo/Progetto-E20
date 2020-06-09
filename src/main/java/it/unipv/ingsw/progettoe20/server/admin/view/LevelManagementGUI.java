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

import it.unipv.ingsw.progettoe20.server.admin.controller.LevelListener;

/*
 * classe per la gestione dei livelli del parcheggio.
 * Si possono aggiungere o togliere livelli nella struttura
 * [Quando si aggiunge un livello, è inizialmente vuoto]
 */

public class LevelManagementGUI extends AbstractGUI {

	private JLabel title, inserthereLevel, insertherePLots;
	private JPanel panel, panel1, panel2;
	private JTextField levelname, parkinglots;
	private JComboBox<String> combo;
	private JButton confirm, home;

	public LevelManagementGUI() {
		super();
	}

	public JTextField getLevelname() {
		return levelname;
	}

	public JComboBox<String> getCombo() {
		return combo;
	}

	public JButton getConfirm() {
		return confirm;
	}

	public JButton getHome() {
		return home;
	}

	public JTextField getParkingLots() {
		return parkinglots;
	}

	@Override
	public void initComponents() {
		panel = new JPanel();
		panel1 = new JPanel();
		panel2 = new JPanel();
		title = new JLabel("LEVEL MANAGEMENT");
		inserthereLevel = new JLabel("Level name:  ");
		insertherePLots = new JLabel("Parking lots:");
		levelname = new JTextField(10);
		parkinglots = new JTextField(10);
		confirm = new JButton("Confirm");
		home = new JButton("Home");

		String[] items = { "Add level", "Remove level" };
		combo = new JComboBox<>(items);

		// frame settings
		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 400);
		setLocationRelativeTo(null);
		setTitle("LEVEL MANAGEMENT GUI");

		// panel settings
		panel.setBackground(new Color(30, 30, 30));
		panel.setLayout(null);

		// panel1 settings
		panel1.setBackground(new Color(30, 30, 30));
		panel1.setLayout(new FlowLayout());

		// panel2 settings
		panel2.setBackground(new Color(30, 30, 30));
		panel2.setLayout(new FlowLayout());

		// title settings
		title.setFont(new Font(Font.MONOSPACED, 3, 30));
		title.setForeground(new Color(196, 10, 255));

		// inserthere settings
		inserthereLevel.setFont(new Font(Font.MONOSPACED, 1, 16));
		inserthereLevel.setForeground(new Color(196, 10, 255));
		inserthereLevel.setAlignmentX(LEFT_ALIGNMENT);

		// inserthere2 settings
		insertherePLots.setFont(new Font(Font.MONOSPACED, 1, 16));
		insertherePLots.setForeground(new Color(196, 10, 255));
		insertherePLots.setAlignmentX(LEFT_ALIGNMENT);

		// confirm settings
		confirm.setFont(new Font(Font.MONOSPACED, 1, 20));
		confirm.setBackground(new Color(222, 177, 255));

		// home settings
		home.setFont(new Font(Font.MONOSPACED, 0, 10));
		home.setBackground(new Color(222, 177, 255));

		// levelname settings
		levelname.setFont(new Font(Font.MONOSPACED, 0, 12));
		levelname.setAlignmentX(RIGHT_ALIGNMENT);
		levelname.setForeground(new Color(196, 10, 255));

		// parkinglots settings
		parkinglots.setFont(new Font(Font.MONOSPACED, 0, 12));
		parkinglots.setAlignmentX(RIGHT_ALIGNMENT);
		parkinglots.setForeground(new Color(196, 10, 255));

		// combobox settings
		combo.setFont(new Font(Font.MONOSPACED, 0, 16));

		// locations settings
		title.setBounds(275, 10, 500, 40);
		home.setBounds(25, 20, 100, 20);
		combo.setBounds(130, 100, 300, 30);
		panel1.setBounds(140, 150, 300, 30);
		panel2.setBounds(140, 200, 300, 30);
		confirm.setBounds(190, 250, 200, 40);

		panel.add(title);
		panel.add(combo);
		panel.add(panel1);
		panel.add(panel2);
		panel.add(confirm);
		panel.add(home);

		panel1.add(inserthereLevel);
		panel1.add(levelname);

		panel2.add(insertherePLots);
		panel2.add(parkinglots);

	}

	@Override
	public void initListener() {
		listener = new LevelListener(this);
		confirm.addActionListener(listener);
		home.addActionListener(listener);

	}
}
