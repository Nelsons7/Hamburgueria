package assets;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

// import jdk.javadoc.internal.doclets.formats.html.markup.Table;

import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dashboard extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    protected static final int EXIT_ON_CLOSE = 0;
    private JLabel lblTitulo;
    private JTextField usuario;
    private JTextField novaSenha;
    private JTextField confirmaSenha;
    private JTextField email;
    private JTable tabela;
    private final Color COR_FUNDO = Color.decode("#e6cfa5");
    private final Color COR_TABELA = Color.decode("#deb783");
    private JButton btnPedir;
    private JLabel imagemLogo;
    private final String colunas[] = { "Categoria:", "Nome", "Conteudo:", "Preço:" };
    private final String dados[][] = { { "Hamburguer", "goku", "Pão, ovo, hamburguer", "R$10,00" },
            { "Hamburguer", "vedita", "Pão, hambúrguer,Cheddar", "R$12,50" },
            { "Hamburguer", "picolo", "Pão, hamburguer 180g, alface, tomate", "R$15,00" },
            { "Hamburguer", "gohan", "Pão, ovo, hamburguer,salsicha,bacon e cheddar", "R$18,00" },
            { "Hamburguer", "naruto", "Pão, ovo, hamburguer,alface,muçarela", "R$13,00" },
            { "Hamburguer", "chapolin", "Pão, calabresa,bacon,catupiry, hamburguer", "R$20,00" } };

    public Dashboard() {
        setBackground(COR_FUNDO);
        setLayout(null);
        iniciarInterface();

    }

    private void iniciarInterface() {

        tabela = new JTable(dados, colunas);
        tabela.setBounds(70, 170, 920, 300);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(400);
        tabela.setBackground(COR_TABELA);
        tabela.setPreferredScrollableViewportSize(new Dimension(400, 100));
        tabela.setFillsViewportHeight(true);
        add(tabela);

        // adicionando a tabela em uma barra de rolagem, ficará envolta , pela mesma
        // JScrollPane scrollPane = new JScrollPane(tabela);

        // adicionando ao JFrame "Formulário" a JTable "Tabela"
        // add(scrollPane);

        lblTitulo = new JLabel("Cardápio do Dia");
        lblTitulo.setBounds(405, 50, 400, 75);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 50));

        // adicionar botao

        btnPedir = new JButton("Pedir");
        btnPedir.addActionListener(this);

        btnPedir.setBounds(110, 430, 100, 35);
        btnPedir.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(),
                BorderFactory.createEmptyBorder(8, 15, 8, 15)));
        btnPedir.setBackground(Color.decode("#eb8d3b"));
        btnPedir.setFont(new Font("Arial", Font.BOLD, 14));

        // imagem da logo

        imagemLogo = new JLabel();
        ImageIcon logo = new ImageIcon(this.getClass().getResource("../imagens/logo3.png"));
        imagemLogo.setIcon(logo);
        imagemLogo.setBounds(30, 0, 300, 170);

        // adcionar na tela
        add(lblTitulo);
        add(imagemLogo);
        // add(tabela);
    }

    private void setLocationRelativeTo(Object object) {
    }

    // acao do botao pedir
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btnPedir) {
            if (getNovaSenha().equals(novaSenha) == (getConfirmaSenha().equals(confirmaSenha))
                    && (getUsuario().equals(usuario) && (getEmail().equals(email)))) {
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