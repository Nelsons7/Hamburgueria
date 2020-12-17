package assets;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.MouseInputAdapter;
import org.w3c.dom.events.MouseEvent;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

public class Login extends JPanel {

    private static final long serialVersionUID = 1L;
    protected static final int EXIT_ON_CLOSE = 0;
    private JLabel lblTitulo;
    private JLabel imagemFundoLogin;
    private JTextField usuario;
    private JTextField senha;
    private final Color COR_FUNDO = Color.decode("#f5ad69");
    private JButton btnLogar;
    private JLabel lblCadastrar;
    private JLabel imagemLogo;

    public Login() {
        setBackground(COR_FUNDO);
        setLayout(null);
        iniciarInterface();

    }

    private void iniciarInterface() {

        // titulo da tela de login
        lblTitulo = new JLabel("Faça seu Login");
        lblTitulo.setBounds(70, 170, 260, 33);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 27));

        // adicionar campos de usuario e senha

        // usuario
        usuario = estiloCampo("Username", 230);

        // senha
        senha = estiloCampo("Senha", 290);

        // cadastrar

        lblCadastrar = new JLabel("CADASTRA-SE");
        lblCadastrar.addMouseListener(new MouseInputAdapter() {
            public void mouseclicked(MouseEvent e) {
                JFrame cadastrar = new JFrame();
                cadastrar.setBackground(Color.BLACK);
                cadastrar.setBounds(300, 100, 1080, 528);
                cadastrar.setVisible(true);
                cadastrar.setDefaultCloseOperation(EXIT_ON_CLOSE);
            }
        });
        lblCadastrar.setBounds(115, 410, 150, 25);
        lblCadastrar.setBackground(Color.decode("#f5c495"));

        // enviar

        btnLogar = new JButton("Entrar");
        // btnLogar.addActionListener(new TrocarTela(Cadastro, "vermelho"));

        btnLogar.setBounds(125, 350, 75, 35);
        btnLogar.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(),
                BorderFactory.createEmptyBorder(8, 15, 8, 15)));
        btnLogar.setBackground(Color.decode("#eb8d3b"));
        btnLogar.setFont(new Font("Arial", Font.BOLD, 14));

        // imagem da logo

        imagemLogo = new JLabel();
        ImageIcon logo = new ImageIcon(this.getClass().getResource("../imagens//logo3.png"));
        imagemLogo.setIcon(logo);
        imagemLogo.setBounds(30, 0, 300, 170);

        // define a imagem de fundo da tela login
        imagemFundoLogin = new JLabel("");
        ImageIcon fundoLogin = new ImageIcon(this.getClass().getResource("../imagens/hamburguer.jpg"));
        imagemFundoLogin.setIcon(fundoLogin);
        imagemFundoLogin.setBounds(340, 0, 940, 528);

        // adcionar na tela
        add(lblCadastrar);
        add(btnLogar);
        add(lblTitulo);
        add(imagemLogo);
        add(imagemFundoLogin);
        add(usuario);
        add(senha);
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
        // cor da fonte
        // campo.setForeground(Color.decode("7e7e7e"));

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
}