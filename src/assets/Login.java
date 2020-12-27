package assets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.MouseInputListener;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.sql.JDBCType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

public class Login extends JFrame {

    private JPanel panelLogin = new JPanel(), panelPrincipal = new JPanel();
    private CardLayout cardLayout = new CardLayout();

    private JLabel lblTitulo;
    private JLabel imagemFundoLogin;
    private JTextField usuario;
    private JTextField senha;
    private final Color COR_FUNDO = Color.decode("#f5ad69");
    private JButton btnLogar;
    private JButton btnCadastrar;
    public JButton btnVoltar;
    private JLabel lblCadastrar;
    private JLabel imagemLogo;

    public Login() {

        super("Card Layout");

        lblTitulo = new JLabel("Faça seu Login");
        lblTitulo.setBounds(70, 170, 260, 33);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 27));

        imagemLogo = new JLabel();
        ImageIcon logo = new ImageIcon(this.getClass().getResource("../imagens//logo3.png"));
        imagemLogo.setIcon(logo);
        imagemLogo.setBounds(30, 0, 300, 170);

        // define a imagem de fundo da tela login
        imagemFundoLogin = new JLabel("");
        ImageIcon fundoLogin = new ImageIcon(this.getClass().getResource("../imagens/hamburguer.jpg"));
        imagemFundoLogin.setIcon(fundoLogin);
        imagemFundoLogin.setBounds(340, 0, 940, 528);

        btnLogar = new JButton("Entrar");
        btnLogar.setBounds(125, 350, 75, 35);
        btnLogar.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(),
                BorderFactory.createEmptyBorder(8, 15, 8, 15)));
        btnLogar.setBackground(Color.decode("#eb8d3b"));
        btnLogar.setFont(new Font("Arial", Font.BOLD, 14));

        btnCadastrar = new JButton("Cadastre-se");
        btnCadastrar.setBounds(95, 400, 125, 35);
        btnCadastrar.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(),
                BorderFactory.createEmptyBorder(8, 15, 15, 15)));
        btnCadastrar.setBackground(COR_FUNDO);
        btnCadastrar.setFont(new Font("Arial", Font.BOLD, 14));

        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(0, 0, 50, 35);
        btnVoltar.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(),
                BorderFactory.createEmptyBorder(4, 3, 7, 3)));
        btnVoltar.setBackground(Color.decode("#a8302c"));
        btnVoltar.setFont(new Font("Arial", Font.BOLD, 14));

        // usuario
        usuario = estiloCampo("Username", 230);

        // senha
        senha = estiloCampo("Senha", 290);

        Cadastro cadastro = new Cadastro();
        cadastro.setVisible(true);

        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);

        acaoLogin acaoLogar = new acaoLogin();
        acaoCadastrar acaoCadastrar = new acaoCadastrar();
        acaoVoltar acaoVoltar = new acaoVoltar();

        btnLogar.addActionListener(acaoLogar);
        btnCadastrar.addActionListener(acaoCadastrar);
        btnVoltar.addActionListener(acaoVoltar);

        panelLogin.setLayout(null);
        panelLogin.setBackground(COR_FUNDO);
        panelLogin.add(lblTitulo);
        panelLogin.add(imagemFundoLogin);
        panelLogin.add(imagemLogo);
        panelLogin.add(btnLogar);
        panelLogin.add(usuario);
        panelLogin.add(senha);
        panelLogin.add(btnCadastrar);

        // add na tela cadastro
        cadastro.add(btnVoltar);

        panelPrincipal.setLayout(cardLayout);

        panelPrincipal.add(panelLogin, "panelLogin");
        panelPrincipal.add(cadastro, "cadastro");
        panelPrincipal.add(dashboard, "dashboard");

        this.setContentPane(panelPrincipal);

        cardLayout.show(panelPrincipal, "login");
    }

    private JTextField estiloCampo(String placeholder, int posicaoY) {

        // cria um textField temporario
        JTextField campo = new JTextField(placeholder);

        // define as dimensoes e posicoes
        campo.setBounds(70, posicaoY, 185, 35);

        // cor do fundo do campo
        campo.setBackground(Color.decode("#f5c495"));
        // borda e espçamento interno
        campo.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(),
                BorderFactory.createEmptyBorder(8, 15, 8, 15)));
        // estilo da fonte
        campo.setFont(new Font("Tahoma", Font.BOLD, 12));

        // focar nos campos
        campo.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (campo.getText().equals(placeholder)) {
                    campo.setText("");
                }
            }

            public void focusLost(FocusEvent e) {
                if (campo.getText().isEmpty()) {
                    campo.setText(placeholder);
                }
            }

        });

        return campo;
    }

    public class acaoLogin implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            if (usuario.getText().equals("nelson") && (senha.getText().equals("123"))) {
                JOptionPane.showMessageDialog(null, "Você foi logado", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                cardLayout.show(panelPrincipal, "dashboard");
            } else {
                JOptionPane.showMessageDialog(null, "Dados inválidos", "Alerta", JOptionPane.ERROR_MESSAGE);

            }

        }
    }

    public class acaoVoltar implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JButton voltar = (JButton) event.getSource();
            if (voltar.equals(btnVoltar))
                cardLayout.show(panelPrincipal, "login");

        }
    }

    public class acaoCadastrar implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JButton cadastrar = (JButton) event.getSource();
            if (cadastrar.equals(btnCadastrar))
                cardLayout.show(panelPrincipal, "cadastro");

        }
    }

    // gets e sets

    public JTextField getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(JTextField usuario) {
        this.usuario = usuario;
    }

    /**
     * @return JTextField return the senha
     */
    public JTextField getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(JTextField senha) {
        this.senha = senha;
    }
}