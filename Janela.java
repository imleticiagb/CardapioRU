import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.io.FileWriter;
import java.io.IOException;


public class Janela extends JFrame implements ActionListener {

    //atributos

    private JButton btNovo, btInserir, btSair, btMostrar;
    private JLabel lbDia, lbProteina, lbVeg, lbSalada, lbArrozFeijao, lbVerdura, lbSuco;
    private JTextField tfProteina, tfVeg, tfSalada, tfVerdura, tfArrozFeijao, tfSuco;
    private JComboBox<String> cbDia;
    private JPanel pnBotoes, pnDados;
    private Cardapio cardapio;
    private List<Cardapio> cardapios = new ArrayList<>();
    private ListIterator<Cardapio> regCardapio;

    public Janela() {

        btNovo = new JButton("NOVO");
        btInserir = new JButton("INSERIR");
        btMostrar = new JButton("MOSTRAR");
        btSair = new JButton("SAIR");

        pnBotoes = new JPanel();
        pnBotoes.setLayout(new GridLayout(1, 4));
        pnDados = new JPanel();
        pnDados.setLayout(new GridLayout(7, 7));

        this.setLayout(new BorderLayout());
        this.add(pnBotoes, BorderLayout.NORTH);
        this.add(pnDados, BorderLayout.CENTER);

        pnBotoes.add(btNovo);
        pnBotoes.add(btInserir);
        pnBotoes.add(btMostrar);
        pnBotoes.add(btSair);

        lbDia = new JLabel("DIA");
        lbArrozFeijao = new JLabel("ACOMPANHAMENTO");
        lbProteina = new JLabel("PROTEÍNA");
        lbVeg = new JLabel("VEGETARIANO");
        lbSalada = new JLabel("SALADA");
        lbVerdura = new JLabel("VERDURA");
        lbSuco = new JLabel("SUCO");

        cbDia = new JComboBox<String>(new String[]{"Segunda", "Terça", "Quarta", "Quinta", "Sexta"});

        tfArrozFeijao = new JTextField(50);
        tfProteina = new JTextField(50);
        tfVeg = new JTextField(50);
        tfSalada = new JTextField(50);
        tfVerdura = new JTextField(50);
        tfSuco = new JTextField(50);

        pnDados.add(lbDia);
        pnDados.add(cbDia);
        pnDados.add(lbArrozFeijao);
        pnDados.add(tfArrozFeijao);
        pnDados.add(lbProteina);
        pnDados.add(tfProteina);
        pnDados.add(lbVeg);
        pnDados.add(tfVeg);
        pnDados.add(lbSalada);
        pnDados.add(tfSalada);
        pnDados.add(lbVerdura);
        pnDados.add(tfVerdura);
        pnDados.add(lbSuco);
        pnDados.add(tfSuco);

        btSair.addActionListener(this);
        btMostrar.addActionListener(this);
        btInserir.addActionListener(this);
        btNovo.addActionListener(this);

        this.setVisible(true);
        this.setSize(530, 200);
        this.setTitle("CARDÁPIO R.U - UFJ");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btSair)
            encerraApp();

        else if (e.getSource() == btNovo) {

            tfArrozFeijao.setText(" ");
            tfProteina.setText(" ");
            tfVeg.setText(" ");
            tfSalada.setText(" ");
            tfVerdura.setText(" ");
            tfSuco.setText(" ");
        } else if (e.getSource() == btInserir)
            InsereCardapio();

        else if (e.getSource() == btMostrar)
            mostraCardapio();

    }

    private void encerraApp() {

        String title = "Confirmação";
        String message = "Deseja realmente sair?";
        int retry = JOptionPane.showConfirmDialog(null, message, getTitle(), JOptionPane.YES_NO_OPTION);
        if (retry == 0) System.exit(0);
    }

    private void InsereCardapio() {

        cardapio = new Cardapio(cbDia.getSelectedItem().toString(), tfProteina.getText(), tfVeg.getText(), tfSalada.getText(), tfArrozFeijao.getText(), tfVerdura.getText(), tfSuco.getText());
        cardapios.add(cardapio);
        regCardapio = cardapios.listIterator();
        regCardapio.forEachRemaining(p -> regCardapio.next());
    }

    private void mostraCardapio() {

        for (Cardapio cardapio1 : cardapios) {
            try {
                FileWriter writer = new FileWriter(cardapio1.getDia() + ".txt");
                writer.write(cardapio1.toString() + "\n");
                writer.close();
                JOptionPane.showMessageDialog(null, "Cardápio salvo em um arquivo .txt");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar o cardápio");
            }
        }
    }
}