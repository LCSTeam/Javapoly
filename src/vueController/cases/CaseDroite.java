package vueController.cases;

import java.awt.Graphics;
import java.awt.Graphics2D;

@SuppressWarnings("serial")
public class CaseDroite extends CaseGauche{

	public CaseDroite(int i) {
		super(i);
	}

	@Override
	public void paintComponent(Graphics g) {
        Graphics2D gx = (Graphics2D) g;
        gx.rotate(Math.PI, getWidth() / 2,getHeight() / 2);
        super.paintComponent(g);
    }
}
