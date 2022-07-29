package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import constants.Option;
import model.Body;
import model.Play;
import view.ViewPlay;

public class Controller implements ActionListener {

	private Play play;
	private ViewPlay view;

	public Controller() {
		play = new Play();
		view = new ViewPlay(this, play);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Option.valueOf(e.getActionCommand())) {
		case simulation:
			play.addSizeScreen(view.getSpace());
			doBodyWomen();
			doBodyMen();
			doCountYear();
			doKill();
			isBorn();
			setTextArea();
			break;
		case cancel:
			System.out.println("dlwk");
			break;
		default:
			break;
		}
	}

	private void setTextArea() {
		view.setTextAreaMen();
		view.setTextAreaTime();
		view.setTextAreaWomen();
		view.setSpaceTxt();
	}

	private void doCountYear() {
		for (int i = 0; i < view.getQuantityYear(); i++) {
			play.addYears(view.getQuantityYear());
		}
	}

	private void doBodyWomen() {
		Body body;
		for (int i = 0; i < view.getTxtQuantityWoman(); i++) {
			body = play.createBodyWomen(view.getQuantityYear());
			play.addBody(body);
		}
	}

	private void doBodyMen() {
		Body body;
		for (int i = 0; i < view.getTxtQuantityMen(); i++) {
			body = play.createBodyMen(view.getQuantityYear());
			play.addBody(body);
		}
	}

	private void doKill() {
		play.doKill();
	}

	private void isBorn() {
		play.isborn(view.getQuantityYear());
	}

}
