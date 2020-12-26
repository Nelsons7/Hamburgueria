package assets;

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
import javax.swing.event.MouseInputAdapter;
import org.w3c.dom.events.MouseEvent;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

public class Cadastro extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    protected static final int EXIT_ON_CLOSE = 0;
    private JLabel lblTitulo;
    private JLabel imagemFundoLogin;
    private JTextField usuario;
    private JTextField novaSenha;
    private JTextField confirmaSenha;
    private JTextField email;
    private final Color COR_FUNDO = Color.decode("#f5ad69");
    private JButton btnSalvar;
    private JLabel lblCadastrar;
    private JLabel imagemLogo;

    public Cadastro() {
        setBackground(COR_FUNDO);
        setLayout(null);
        iniciarInterface();

    }

    private void iniciarInterface() {

        lblTitulo = new JLabel("Novo cadastro");
        lblTitulo.setBounds(70, 170, 260, 33);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 27));

        // adicionar campos de usuario e senha

        // usuario
        usuario = estiloCampo("Usuário", 230);
        // email
        email = estiloCampo("email", 280);
        // senha
        novaSenha = estiloCampo("TESTEEEE", 330);
        // confirma senha
        confirmaSenha = estiloCampo("Username", 380);

        // adicionar botao

        btnSalvar = new JButton("Cadastrar");
        btnSalvar.addActionListener(this);

        btnSalvar.setBounds(110, 430, 100, 35);
        btnSalvar.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(),
                BorderFactory.createEmptyBorder(8, 15, 8, 15)));
        btnSalvar.setBackground(Color.decode("#eb8d3b"));
        btnSalvar.setFont(new Font("Arial", Font.BOLD, 14));

        // imagem da logo

        imagemLogo = new JLabel();
        ImageIcon logo = new ImageIcon(this.getClass().getResource("../imagens/logo3.png"));
        imagemLogo.setIcon(logo);
        imagemLogo.setBounds(30, 0, 300, 170);

        // define a imagem de fundo da tela login
        imagemFundoLogin = new JLabel("");
        ImageIcon fundoLogin = new ImageIcon(this.getClass().getResource("../imagens/hamburguer.jpg"));
        imagemFundoLogin.setIcon(fundoLogin);
        imagemFundoLogin.setBounds(340, 0, 940, 528);

        // adcionar na tela

        add(imagemLogo);
        add(imagemFundoLogin);
        add(usuario);
        add(email);
        add(novaSenha);
        add(confirmaSenha);
        add(lblTitulo);
        add(btnSalvar);
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

    // acao do botao salvar
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btnSalvar) {

            if (novaSenha.getText().equals(getConfirmaSenha().getText()) && !getUsuario().getText().equals("")
                    && !getEmail().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Você foi cadastrado com sucesso", "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Preencha todos os dados!", "Alerta", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

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
     * @return JTextField return the novaSenha
     */
    public JTextField getNovaSenha() {
        return novaSenha;
    }

    /**
     * @param novaSenha the novaSenha to set
     */
    public void setNovaSenha(JTextField novaSenha) {
        this.novaSenha = novaSenha;
    }

    /**
     * @return JTextField return the confirmaSenha
     */
    public JTextField getConfirmaSenha() {
        return confirmaSenha;
    }

    /**
     * @param confirmaSenha the confirmaSenha to set
     */
    public void setConfirmaSenha(JTextField confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

    /**
     * @return JTextField return the email
     */
    public JTextField getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(JTextField email) {
        this.email = email;
    }

}