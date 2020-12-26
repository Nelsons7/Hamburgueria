package main;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.LayoutQueue;

import java.awt.*;

import assets.Cadastro;
import assets.Dashboard;
import assets.Login;
import assets.Cadastro;
import assets.TrocarTela;

public class Principal {
    public static void main(String[] args) {

        JFrame janela = new JFrame("Hamburgueria");
        janela.setBounds(300, 100, 1080, 528);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelPrincipal = new JPanel();

        CardLayout layout = new CardLayout();
        panelPrincipal.setLayout(layout);
        panelPrincipal.setSize(1920, 1080);

        // telas

        Login login = new Login();

        Cadastro cadastro = new Cadastro();

        Dashboard dashboard = new Dashboard();

        JPanel panelRed = new JPanel();
        panelRed.setBackground(Color.RED);

        JPanel panelBlue = new JPanel();
        panelBlue.setBackground(Color.BLUE);

        // adicionar no painel principal
        panelPrincipal.add(panelRed, "vermelho");
        panelPrincipal.add(panelBlue, "azul");

        panelPrincipal.add(login, "login");
        panelPrincipal.add(cadastro, "cadastro");
        panelPrincipal.add(dashboard, "dashboard");

        layout.show(panelPrincipal, "cadastro");

        janela.setVisible(true);

        janela.add(panelPrincipal);

    }

}