package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import constants.Option;
import controller.Controller;
import model.Play;

public class ViewPlay extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextArea txt;
	private JTextArea txtTwo;
	private JTextArea timeTxt;
	private JTextArea spacetxt;
	private JTextArea ageTxt;
	private Timer time;
	private JPanel initialPanel;
	private JPanelGraphics graphics;
	private static final String URL_IMAGE = "/img/logo.png";


	public ViewPlay(Controller click, Play play) {
		setSize(1105, 700);
		setIconImage(new ImageIcon(getClass().getResource(URL_IMAGE)).getImage());

		initialPanel = panelGraphics(play);
		add(initialPanel);
		
		graphics = new JPanelGraphics(play);
		add(graphics);

		panels(click, play);

		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void panels(Controller click, Play play) {
		setLayout(new GridBagLayout());
		panelWoman();
		screen(click);
		repaint();
	}

	private void panelWoman() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 0));
		panel.setBackground(Color.BLACK);
		setLayout(null);
		panel.setBounds(0, 0, 889, 60);

		JLabel tex = new JLabel("CANTIDAD DE MUJERES", SwingConstants.CENTER);
		tex.setFont(new Font("", 1, 13));
		tex.setForeground(Color.WHITE);
		panel.add(tex);

		txt = new JTextArea(1, 12);
		txt.setBackground(Color.decode("#A0F7F1"));
		txt.setFont(new Font("", 1, 20));
		panel.add(txt);

		JLabel texTwo = new JLabel("CANTIDAD DE HOMBRES", SwingConstants.CENTER);
		texTwo.setFont(new Font("", 1, 13));
		texTwo.setForeground(Color.WHITE);
		panel.add(texTwo, BorderLayout.CENTER);

		txtTwo = new JTextArea(1, 12);
		txtTwo.setBackground(Color.decode("#A0F7F1"));
		txtTwo.setFont(new Font("", 1, 20));
		panel.add(txtTwo);

		JLabel time = new JLabel("TIEMPO EN AÑOS", SwingConstants.CENTER);
		time.setFont(new Font("", 1, 13));
		time.setForeground(Color.WHITE);
		panel.add(time);

		timeTxt = new JTextArea(1, 12);
		timeTxt.setBackground(Color.WHITE);
		timeTxt.setFont(new Font("", 1, 20));
		panel.add(timeTxt);

		
		JLabel size = new JLabel("TAMAÑO DEL ESPACIO", SwingConstants.CENTER);
		size.setFont(new Font("", 1, 13));
		size.setForeground(Color.WHITE);
		panel.add(size);

		spacetxt = new JTextArea(1, 12);
		spacetxt.setBackground(Color.WHITE);
		spacetxt.setFont(new Font("", 1, 20));
		panel.add(spacetxt);
		
		add(panel);
		setVisible(true);
	}

	public void screen(Controller click) {
		JPanel pn = new JPanel();
		pn.setLayout(new GridLayout(1, 1));
		pn.setBounds(889, 0, 200, 60);
		JButton button = new JButton();
		setLayout(null);
		button.setForeground(Color.BLACK);
		button.setBackground(Color.PINK);
		button.setFocusable(false);
		button.setBorderPainted(false);
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button.setText("ACEPTAR");
		button.setBackground(Color.decode("#55F5EA"));

		button.addActionListener(click);
		button.setActionCommand(Option.simulation.toString());
		pn.add(button);
		
		JButton button2 = new JButton();
		setLayout(null);
		button2.setForeground(Color.BLACK);
		button2.setFocusable(false);
		button2.setBorderPainted(false);
		button2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button2.setText("RESTART");
		button2.setBackground(Color.red);
		
		button2.addActionListener(click);
		button2.setActionCommand(Option.cancel.toString());
		pn.add(button2);
		add(pn);
	}
	
	public void screenRstar(Controller click) {
		
	}

	public JPanel panelGraphics(Play play) {
		JPanel newPanel = new JPanel();
		newPanel.setLayout(new GridLayout(2, 2));
		newPanel.setBackground(Color.decode("#55F5EA"));
		newPanel.setBounds(10, 70, 1070, 50);

		JLabel label = new JLabel();
		label.setFont(new Font("Franklin Gothic Demi Cond", ABORT, 17));
		JLabel years = new JLabel();
		years.setFont(new Font("Franklin Gothic Demi Cond", ABORT, 17));
		JLabel days = new JLabel();
		days.setFont(new Font("Franklin Gothic Demi Cond", ABORT, 17));
		JLabel born = new JLabel();
		born.setFont(new Font("Franklin Gothic Demi Cond", ABORT, 17));
		JLabel die = new JLabel();
		die.setFont(new Font("Franklin Gothic Demi Cond", ABORT, 17));
		JLabel dieMen = new JLabel();
		dieMen.setFont(new Font("Franklin Gothic Demi Cond", ABORT, 17));
		JLabel space = new JLabel();
		space.setFont(new Font("Franklin Gothic Demi Cond", ABORT, 17));

		time = new Timer(1, (ActionEvent e) -> {
			label.setText("Poblacion: " + play.getSize());
			years.setText("Intervalo de tiempo: " + play.getQuantityYears() + " años");
			days.setText("Intervalo de tiempo: " + play.getQuantityDay() + " dias");
			born.setText("Nacimientos: " + play.quantityBorn());
			die.setText("Muertes de mujeres: " + play.quantityKillWomen());
			dieMen.setText("Muertes de hombres: " + play.quantityKillMen());
			space.setText("Tamaño del espacio: " + play.getScreen());

		});
		time.start();

		newPanel.add(label);
		newPanel.add(years);
		newPanel.add(days);
		newPanel.add(born);
		newPanel.add(die);
		newPanel.add(dieMen);
		newPanel.add(space);

		newPanel.setVisible(true);
		add(newPanel);
		return newPanel;
	}

	public void addPanel(JPanel paneel) {
		remove(initialPanel);
		this.initialPanel = paneel;
		add(initialPanel);
		repaint();
		initialPanel.updateUI();
		revalidate();
	}

	public void setTextAreaMen() {
		txt.setText(" ");
	}
	
	public void setTextAreaWomen() {
		txtTwo.setText(" ");
	}
	
	public void setTextAreaTime() {
		timeTxt.setText(" ");
	}
	
	public int getTxtQuantityWoman() {
		return Integer.parseInt(txt.getText());
	}

	public int getTxtQuantityMen() {
		return Integer.parseInt(txtTwo.getText());
	}
	
	public void setSpaceTxt() {
		spacetxt.setText(" ");
	}
	
	public int getSpace() {
		return Integer.parseInt(spacetxt.getText());
	}

	public int getQuantityYear() {
		return Integer.parseInt(timeTxt.getText());
	}

	public int getAgeTxt() {
		return Integer.parseInt(ageTxt.getText());
	}

}
