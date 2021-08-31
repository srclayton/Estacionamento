package janela;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import principal.Cliente;
import principal.Gerenciador;
import principal.Veiculo;
import principal.Veiculo.Tamanho;


public class Janela extends JFrame implements MouseListener{
	
	private int numOperacao = 3; // quantidade de operação da janela, maximizar, fechar e minimizar;
	private static int alturaJanela = 728; // seto a altura e largura da janela;
	private static int larguraJanela = 1024;
	
	private JButton btCadastrarVeiculo = new JButton("Cadastrar novo veiculo");
	private JButton bt2 = new JButton("opcao 2");
	private JButton bt3 = new JButton("opcao 3");
	private JButton btCadastrar = new JButton("Cadastrar");
	private JButton btProcuraCliente = new JButton("Procurar Cliente");
	private JButton btProcuraVeiculo = new JButton("Procurar Veiculo");
	
	private JLabel labelMenu = new JLabel("Menu");
	private JLabel labelDadosPessoais = new JLabel("Dados pessoas");
	private JLabel labelDadosVeiculo = new JLabel("Dados do veículo");
	private JLabel lbNome = new JLabel("Digite o Nome:");
	private JLabel lbCpf = new JLabel("Digite o CPF:");
	private JLabel lbEmail = new JLabel("Email:");
	private JLabel lbNumTel = new JLabel("Telefone:");
	private JLabel lbClienteExiste = new JLabel("Digite o CPF do cliente cadastrado:");
	
	private JLabel lbModelo = new JLabel("Modelo:");
	private JLabel lbCor = new JLabel("Cor:");
	private JLabel lbPlaca = new JLabel("Placa:");
	private JLabel lbVeiculoExiste = new JLabel("Digite a placa do veiculo cadastrado:");
	private JLabel lbTamanho = new JLabel("Tamanho:");
	private JLabel lbAvarias = new JLabel("Avarias:");
	private JLabel lbProcuraCliente = new JLabel();
	private JLabel lbProcuraVeiculo = new JLabel();
	
	
	private JTextField tfNome = new JTextField(20);
	private JTextField tfCpf = new JTextField(20);
	private JTextField tfEmail = new JTextField(20);
	private JTextField tfNumTel = new JTextField(20);
	private JTextField tfClienteExistente = new JTextField(20);
	
	private JTextField tfCpfClienteExistente = new JTextField(20);
	private JCheckBox cbClienteExistente = new JCheckBox("Cliente cadastrado");
	private JCheckBox cbVeiculoExistente = new JCheckBox("Veiculo cadastrado");
	
	private JTextField tfModelo = new JTextField(20);
	private JTextField tfCor = new JTextField(20);
	private JTextField tfPlaca = new JTextField(20);
	private JTextField tfAvarias = new JTextField(20);
	private JTextField tfVeiculoExistente = new JTextField(20);
	
	private JComboBox cbTamanhoVeiculo = new JComboBox(new String[] { "Pequeno", "Medio", "Grande" });
	
	private static JPanel menu;
	private static JPanel cadastroVeiculo;
	
	private Gerenciador gerenciador = new Gerenciador();

	public Janela() {
		criaMenu();
		updateTela();
		
		//action listener para o check box cliente já possui cadastro
		ActionListener cbClienteExistenteListener = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		        clienteExistenteActionPerformed();
		      }
		};
		cbClienteExistente.addActionListener(cbClienteExistenteListener);
		
		//action listener para o check box veiculo já é cadastrado
		ActionListener cbVeiculoExistenteListener = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		        veiculoExistenteActionPerformed();
		      }
		};
		cbVeiculoExistente.addActionListener(cbVeiculoExistenteListener);
		
		//action listener para botao de procurar cliente
		ActionListener btProcuraClienteListener = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		        procuraClienteExistente();
		      }
		};
		
		btProcuraCliente.addActionListener(btProcuraClienteListener);
		
		
		ActionListener btProcuraVeiculoListener = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		        procuraVeiculoExistente();
		      }
		};
		
		btProcuraVeiculo.addActionListener(btProcuraVeiculoListener);
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
		cadastroVeiculo.add(tfAvarias);
		cadastroVeiculo.add(labelDadosPessoais);
		cadastroVeiculo.add(labelDadosVeiculo);
		cadastroVeiculo.add(btCadastrar);
		cadastroVeiculo.add(cbTamanhoVeiculo);
		cadastroVeiculo.add(cbClienteExistente);
		cadastroVeiculo.add(cbVeiculoExistente);
		
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
		
		cbClienteExistente.setBounds(450,160,200,20);
		lbClienteExiste.setBounds(350,180,200,20);
		tfClienteExistente.setBounds(580,180,200,20);
		btProcuraCliente.setBounds(350,200,200,20);
		lbProcuraCliente.setBounds(580,200,200,20);
		
		//tfCpfClienteExistente.setBounds(200,130,100,20);
		
		//DADOS DO VEICULO//
		lbModelo.setBounds(200, 300,100,20);
		tfModelo.setBounds(285,300,200,20);
		
		lbCor.setBounds(500, 300,200,20);
		tfCor.setBounds(585,300,200,20);
		
		lbPlaca.setBounds(200, 330,100,20);
		tfPlaca.setBounds(285,330,100,20);
		
		lbTamanho.setBounds(500,330,200,20);
		cbTamanhoVeiculo.setBounds(585,330,200,20);
		cbTamanhoVeiculo.setSelectedIndex(0);
		
		lbAvarias.setBounds(200,360,100,20);
		tfAvarias.setBounds(285,360,500,20);
		
		cbVeiculoExistente.setBounds(450,390,500,20);
		lbVeiculoExiste.setBounds(350,420,500,20);
		tfVeiculoExistente.setBounds(580,420,200,20);
		btProcuraVeiculo.setBounds(350,440,200,20);
		lbProcuraVeiculo.setBounds(580,440,200,20);
		
		//BOTOES//
		btCadastrar.setBounds(Janela.getLarguraJanela()/2 - 30, 490,100,50);
		btCadastrar.addMouseListener(this);
		
		add(cadastroVeiculo);
		updateTela();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == btCadastrarVeiculo) {
			btCadastrarVeiculo.removeMouseListener(this);
			encerraMenu();
			cadastrarVeiculoCliente();
		} else if(e.getSource() == btCadastrar) {
			cadastraNovaOcupacao();
		}
	}
	
	public void clienteExistenteActionPerformed() {
		boolean esconderCamposCliente = !cbClienteExistente.isSelected();
		tfNome.setEditable(esconderCamposCliente);
		tfCpf.setEditable(esconderCamposCliente);
		tfNumTel.setEditable(esconderCamposCliente);
		tfEmail.setEditable(esconderCamposCliente);
		
		//Se o checkbox estiver selecionado, adiciono os labels para procurar o cpf do cliente
		if(!esconderCamposCliente) {
			cadastroVeiculo.add(lbClienteExiste);
			cadastroVeiculo.add(tfClienteExistente);
			cadastroVeiculo.add(btProcuraCliente);
			
		} else {
			cadastroVeiculo.remove(lbClienteExiste);
			cadastroVeiculo.remove(tfClienteExistente);
			cadastroVeiculo.remove(btProcuraCliente);
			cadastroVeiculo.remove(lbProcuraCliente);
		}
		cadastroVeiculo.updateUI();
	}
	
	public void veiculoExistenteActionPerformed() {
		boolean esconderCamposVeiculo = !cbVeiculoExistente.isSelected();
		cbTamanhoVeiculo.setEditable(esconderCamposVeiculo);
		tfAvarias.setEditable(esconderCamposVeiculo);
		tfPlaca.setEditable(esconderCamposVeiculo);
		tfModelo.setEditable(esconderCamposVeiculo);
		tfAvarias.setEditable(esconderCamposVeiculo);
		tfCor.setEditable(esconderCamposVeiculo);
		if(!esconderCamposVeiculo) {
			cadastroVeiculo.add(lbVeiculoExiste);
			cadastroVeiculo.add(tfVeiculoExistente);
			cadastroVeiculo.add(btProcuraVeiculo);
		} else {
			cadastroVeiculo.remove(lbVeiculoExiste);
			cadastroVeiculo.remove(tfVeiculoExistente);
			cadastroVeiculo.remove(btProcuraVeiculo);
			cadastroVeiculo.remove(lbProcuraVeiculo);
		}
		cadastroVeiculo.updateUI();
	}
	
	public void procuraClienteExistente() {
		gerenciador.cadastraNovoCliente("", "123", "", "");
		Cliente cliente = gerenciador.getCliente(tfClienteExistente.getText());
		String confirmacao;
		if(cliente != null) {
			confirmacao = "Cliente achado";
		} else {
			confirmacao = "Cliente não cadastrado";
		}
		lbProcuraCliente.setText(confirmacao);
		cadastroVeiculo.add(lbProcuraCliente);
		cadastroVeiculo.updateUI();
	}
	
	public void procuraVeiculoExistente() {
		Veiculo veiculo = gerenciador.getVeiculo(tfVeiculoExistente.getText());
		String confirmacao;
		if(veiculo != null) {
			confirmacao = "Veiculo achado";
		} else {
			confirmacao = "Veiculo não cadastrado";
		}
		lbProcuraVeiculo.setText(confirmacao);
		cadastroVeiculo.add(lbProcuraVeiculo);
		cadastroVeiculo.updateUI();
	}
	
	public void cadastraNovaOcupacao() {
		Cliente cliente;
		if(cbClienteExistente.isSelected())
			cliente = gerenciador.cadastraNovoCliente(tfNome.getText(), tfCpf.getText(), tfNumTel.getText(),
					tfEmail.getText());
		else 
			cliente = gerenciador.getCliente(tfCpfClienteExistente.getText());
		
		tfNome.setEditable(false);
		Veiculo veiculo = gerenciador.cadastraNovoVeiculo(tfModelo.getText(), tfPlaca.getText(), tfCor.getText(),
				cbTamanhoVeiculo.getSelectedItem().toString(), tfAvarias.getText());
		gerenciador.novaOcupacao(cliente, veiculo);

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
