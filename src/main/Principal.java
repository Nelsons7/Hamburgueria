package main;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.LayoutQueue;

import java.awt.*;

import assets.Cadastro;
import assets.Login;
import assets.TrocarTela;

public class Principal {
    public static void main(String[] args) {

        JFrame janela = new JFrame("Hamburgueria");
        janela.setBounds(300, 100, 1080, 528);

        JPanel panelPrincipal = new JPanel();
        CardLayout layout = new CardLayout();
        panelPrincipal.setLayout(layout);
        panelPrincipal.setSize(1920, 1080);

        Login login = new Login();

        JPanel panelRed = new JPanel();
        panelRed.setBackground(Color.RED);

        JPanel panelBlue = new JPanel();
        panelBlue.setBackground(Color.BLUE);

        JButton btnEnviar = new JButton("ENVIAR");
        btnEnviar.setBounds(50, 450, 200, 30);
        login.add(btnEnviar);
        btnEnviar.addActionListener(new TrocarTela(panelPrincipal, "login"));

        JPanel panelLogin = new JPanel();
        panelLogin.add(login);

        // adicionar no painel principal
        panelPrincipal.add(panelRed, "vemelho");
        panelPrincipal.add(panelBlue, "azul");
        panelPrincipal.add(panelLogin, "login");

        layout.show(panelPrincipal, "azul");

        // panelPrincipal.add(panelBlue);

        janela.add(login);
        // janela.add(cadastro);
        janela.setVisible(true);

        janela.add(panelPrincipal);

    }
}