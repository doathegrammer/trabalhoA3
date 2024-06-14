import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class visual {

    private int totalDoacoes = 0;
    private int dinheiroDoacao = 0;
    private int insumosDoacao = 0;
    private int roupasDoacao = 0;
    private int brinquedosDoacao = 0;
    private int remediosDoacao = 0;
    private final String nomeArquivo = "doacoes.txt";
    private String nomeUsuario;

    public visual() {

        carregarDoacoes();

        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setSize(854, 480);
        jFrame.setTitle("Doação para crianças em vulnerabilidade");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2, 10, 10));

        JLabel nomeCampo = new JLabel("Digite seu nome:");
        JTextField nomeTexto = new JTextField();

        JLabel tabelas = new JLabel("Tipo de doação:");
        String[] tiposDoacao = {"Dinheiro", "Insumos", "Roupas", "Brinquedos", "Remédios"};
        JComboBox<String> selecionaDoacao = new JComboBox<>(tiposDoacao);

        JLabel quantidadeDoada = new JLabel("Quantidade:");
        JTextField quantidadeValor = new JTextField();

        JLabel dataDoacao = new JLabel("Data (Utilize o formato DD/MM/AAAA):");
        JTextField inserirData = new JTextField();

        JButton botaoEnviar = new JButton("Enviar doação");
        botaoEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nomeUsuario = nomeTexto.getText();
                String tipo = (String) selecionaDoacao.getSelectedItem();
                int quantidade = Integer.parseInt(quantidadeValor.getText());
                String data = inserirData.getText();

                adicionarDoacao(quantidade, tipo);

                JOptionPane.showMessageDialog(jFrame, "Muito obrigado pela contribuição, " + nomeUsuario + "! Sua doação foi de:\n" +
                        "Tipo: " + tipo + "\n" +
                        "Quantidade: " + quantidade + "\n" +
                        "Data: " + data);

                salvarDoacoes(tipo, data, quantidade);
            }
        });

        JButton botaoTotal = new JButton("Total de doações");
        botaoTotal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder mensagem = new StringBuilder("Número de doações:\n");
                mensagem.append("Dinheiro: ").append(dinheiroDoacao).append("\n");
                mensagem.append("Insumos: ").append(insumosDoacao).append("\n");
                mensagem.append("Roupas: ").append(roupasDoacao).append("\n");
                mensagem.append("Brinquedos: ").append(brinquedosDoacao).append("\n");
                mensagem.append("Remédios: ").append(remediosDoacao).append("\n");

                JOptionPane.showMessageDialog(jFrame, mensagem.toString());
            }
        });

        panel.add(nomeCampo);
        panel.add(nomeTexto);
        panel.add(tabelas);
        panel.add(selecionaDoacao);
        panel.add(quantidadeDoada);
        panel.add(quantidadeValor);
        panel.add(dataDoacao);
        panel.add(inserirData);
        panel.add(new JLabel()); // pular linha
        panel.add(botaoEnviar);
        panel.add(new JLabel()); // pular linha
        panel.add(botaoTotal);

        jFrame.add(panel);
        jFrame.setVisible(true);
    }

    public void adicionarDoacao(int quantidade, String tipo) {
        switch (tipo) {
            case "Dinheiro":
                dinheiroDoacao += quantidade;
                break;
            case "Insumos":
                insumosDoacao += quantidade;
                break;
            case "Roupas":
                roupasDoacao += quantidade;
                break;
            case "Brinquedos":
                brinquedosDoacao += quantidade;
                break;
            case "Remédios":
                remediosDoacao += quantidade;
                break;
            default:
                break;
        }

        totalDoacoes += quantidade;
    }

    private void salvarDoacoes(String tipo, String data, int quantidade) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo, true))) {
            writer.println(nomeUsuario + "," + tipo + "," + data + "," + quantidade);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void carregarDoacoes() {
        try (Scanner scanner = new Scanner(new File(nomeArquivo))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] partes = line.split(",");
                if (partes.length == 4) {
                    String nome = partes[0];
                    String tipo = partes[1];
                    String data = partes[2];
                    int quantidade = Integer.parseInt(partes[3]);
                    adicionarDoacao(quantidade, tipo);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Sem Doações");
        }
    }

    public static void main(String[] args) {
        new visual();
    }
}




