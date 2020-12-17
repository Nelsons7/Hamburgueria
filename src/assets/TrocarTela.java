package assets;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class TrocarTela implements ActionListener {

    private JPanel panel;
    private String telaDesitno;

    public TrocarTela(JPanel panel, String telaDestino) {
        this.panel = panel;
        this.telaDesitno = telaDestino;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        CardLayout layout = (CardLayout) panel.getLayout();
        layout.show(panel, telaDesitno);
    }

}