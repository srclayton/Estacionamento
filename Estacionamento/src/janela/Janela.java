package janela;


import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import principal.Veiculo;
import principal.Veiculo.Tamanho;


public class Janela extends JFrame implements MouseListener{
	
	private int numOperacao = 3; // quantidade de operação da janela, maximizar, fechar e minimizar;
	private static int alturaJanela = 728; // seto a altura e largura da janela;
	private static int larguraJanela = 1024;
	
	private JButton btCadastrarVeiculo = new JButton("Cadastrar veiculo");
	private JButton bt2 = new JButton("opcao 2");
	private JButton bt3 = new JButton("opcao 3");
	private JButton btEnviaCadastroVeiculo = new JButton("Cadastrar");
	
	private JLabel labelMenu = new JLabel("MENU");
	private JLabel labelDadosPessoais = new JLabel("DADOS PESSOAIS");
	private JLabel labelDadosVeiculo = new JLabel("DADOS DO VEICULO");
	private JLabel lbNome = new JLabel("Digite o Nome:");
	private JLabel lbCpf = new JLabel("Digite o CPF:");
	private JLabel lbEmail = new JLabel("Email");
	private JLabel lbNumTel = new JLabel("Telefone");
	private JLabel lbModelo = new JLabel("Modelo:");
	private JLabel lbCor = new JLabel("Cor:");
	private JLabel lbPlaca = new JLabel("Placa:");
	private JLabel lbTamanho = new JLabel("Tamanho:");
	private JLabel lbAvarias = new JLabel("Avarias:");
	
	private JTextField tfNome = new JTextField(20);;
	private JTextField tfCpf = new JTextField(20);;
	private JTextField tfEmail = new JTextField(20);;
	private JTextField tfNumTel = new JTextField(20);;
	private JTextField tfModelo = new JTextField(20);
	private JTextField tfCor = new JTextField(20);
	private JTextField tfPlaca = new JTextField(20);
	private JTextField tfTamanho = new JTextField(20);
	private JTextField tfAvarias = new JTextField(20);
	
	private JComboBox cbTamanhoVeiculo = new JComboBox(new String[] { "Pequeno", "Medio", "Grande" });
	
	private static JPanel menu;
	private static JPanel cadastroVeiculo;

	public Janela() {
		criaMenu();
		updateTela();		
	}

	public static int getAlturaJanela() {
		return alturaJanela;
	}

	public static int getLarguraJanela() {
		return larguraJanela;
	}

	public void criaMenu() {
		menu =  new JPanel();
		menu.setLayout(null);
		labelMenu.setBounds(Janela.getLarguraJanela()/2 - labelMenu.getText().length()-50,0,100,100);
		btCadastrarVeiculo.setBounds(100,300,200,200);
		btCadastrarVeiculo.addMouseListener(this);
		bt2.setBounds(400,300,200,200);
		bt2.addMouseListener(this);
		bt3.setBounds(700,300,200,200);
		bt3.addMouseListener(this);
		labelMenu.setFont(new Font("Serif", Font.PLAIN, 50));
		labelMenu.setBounds(Janela.getLarguraJanela()/2 - 70,100,500,100);
		menu.add(labelMenu);
		menu.add(btCadastrarVeiculo);
		menu.add(bt2);
		menu.add(bt3);
		add(menu);
	}

	public void encerraMenu() {
		remove(menu);
		menu.removeAll();
		menu.validate();
		menu.repaint();
		menu = null;
		updateTela();
	}
	
	public void updateTela() {
		setTitle("Estacionamento"); // TÍTULO DA JANELA
		setDefaultCloseOperation(numOperacao); // OPERAÇÕES DA JANELA, MAXIMIZAR, MINIMIZAR E FECHA;
		setSize(larguraJanela,alturaJanela); // DEFINE O TAMANHO DA JANELA;
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	public void excluiPanel(JPanel panel) {
		remove(panel);
		panel.removeAll();
		panel.validate();
		panel.repaint();
		panel = null;
		updateTela();
	}
	public void cadastrarVeiculoCliente() {
		cadastroVeiculo = new JPanel();
		cadastroVeiculo.setLayout(null);

		cadastroVeiculo.add(lbNome);
		cadastroVeiculo.add(lbCpf);
		cadastroVeiculo.add(tfNome);
		cadastroVeiculo.add(lbEmail);
		cadastroVeiculo.add(lbNumTel);
		cadastroVeiculo.add(tfCpf);
		cadastroVeiculo.add(tfEmail);
		cadastroVeiculo.add(tfNumTel);
		cadastroVeiculo.add(lbModelo);
		cadastroVeiculo.add(lbCor);
		cadastroVeiculo.add(lbPlaca);
		cadastroVeiculo.add(lbTamanho);
		cadastroVeiculo.add(lbAvarias);
		cadastroVeiculo.add(tfModelo);
		cadastroVeiculo.add(tfCor);
		cadastroVeiculo.add(tfPlaca);
		cadastroVeiculo.add(tfTamanho);
		cadastroVeiculo.add(tfAvarias);
		cadastroVeiculo.add(labelDadosPessoais);
		cadastroVeiculo.add(labelDadosVeiculo);
		cadastroVeiculo.add(btEnviaCadastroVeiculo);
		cadastroVeiculo.add(cbTamanhoVeiculo);
		
		labelDadosPessoais.setFont(new Font("Serif", Font.PLAIN, 20));
		labelDadosPessoais.setBounds(Janela.getLarguraJanela()/2 - 70,50,500,20);
		
		labelDadosVeiculo.setFont(new Font("Serif", Font.PLAIN, 20));
		labelDadosVeiculo.setBounds(Janela.getLarguraJanela()/2 - 70,250,500,20);
		
		//DADOS PESSOAIS//
		lbNome.setBounds(200,100,100,20);
		tfNome.setBounds(285,100,200,20);
		
		lbCpf.setBounds(500,100,100,20);
		tfCpf.setBounds(585,100,200,20);

		lbEmail.setBounds(200,130,100,20);
		tfEmail.setBounds(285,130,200,20);
		
		lbNumTel.setBounds(500,130,100,20);
		tfNumTel.setBounds(585,130,200,20);
		
		//DADOS DO VEICULO//
		lbModelo.setBounds(200, 300,100,20);
		tfModelo.setBounds(285,300,200,20);
		
		lbCor.setBounds(500, 300,200,20);
		tfCor.setBounds(585,300,200,20);
		
		lbPlaca.setBounds(200, 330,100,20);
		tfPlaca.setBounds(285,330,100,20);
		
		lbTamanho.setBounds(500, 330,200,20);
		cbTamanhoVeiculo.setBounds(585,330,200,20);
		cbTamanhoVeiculo.setSelectedIndex(0);
		//tfTamanho.setBounds(585,330,200,20);
		
		lbAvarias.setBounds(200, 360,100,20);
		tfAvarias.setBounds(285,360,500,20);
		
		//BOTOES//
		btEnviaCadastroVeiculo.setBounds(Janela.getLarguraJanela()/2 - 30, 400,100,50);
		btEnviaCadastroVeiculo.addMouseListener(this);
		
		add(cadastroVeiculo);
		updateTela();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == btCadastrarVeiculo) {
			btCadastrarVeiculo.removeMouseListener(this);
			encerraMenu();
			cadastrarVeiculoCliente();
		} else if(e.getSource() == btEnviaCadastroVeiculo) {
			//criar classe q gerencia a criação dos objetos
			Veiculo veiculo = new Veiculo(tfModelo.getText(), tfPlaca.getText(), 
					tfCor.getText(), Tamanho.MEDIO, tfAvarias.getText());
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
	
}
