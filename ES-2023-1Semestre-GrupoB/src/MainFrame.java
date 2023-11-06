import java.awt.EventQueue;
import java.io.FileOutputStream;
import java.net.URL;
import java.io.InputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;
import java.awt.Desktop;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private final JTextField sucesso = new JTextField();
	private final JTextField erro= new JTextField();
	private File file_path;
	private JTextField textField;
	private String URL;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("Bem Vindo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLocal = new JButton("Carregar do pc");
		btnLocal.setBounds(20, 162, 140, 63);
		contentPane.add(btnLocal);
		//Ação do botão Load from PC
		btnLocal.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			JFileChooser localfile = new JFileChooser();
			FileNameExtensionFilter filtro = new FileNameExtensionFilter("CSV files","csv");
			localfile.setFileFilter(filtro);
			localfile.setCurrentDirectory(null);
			
			int resultado = localfile.showOpenDialog(null);
			escolha(resultado,localfile);						
			}
		}
		);
		
		JButton btnDisplay = new JButton("Display do Horário");
		btnDisplay.setBounds(381, 162, 119, 71);
		contentPane.add(btnDisplay);
		
		JLabel lblNewLabel = new JLabel("Carregar através de um URL do GITHUB :");
		lblNewLabel.setBounds(20, 10, 510, 27);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(20, 44, 458, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnOK = new JButton("OK");
		btnOK.setBounds(476, 43, 85, 21);
		contentPane.add(btnOK);
		btnOK.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				getURL();
				checkURL();
				
				try {
					download(URL);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		sucesso.setColumns(10);
	}
	
	public void escolha(int resultado, JFileChooser localfile) {
		
		if(resultado == JFileChooser.APPROVE_OPTION) {
			
			sucesso.setText("Ficheiro carregado com sucesso");
			sucesso.setBounds(53, 313, 269, 36);
			contentPane.add(sucesso);
			file_path =new File(localfile.getSelectedFile().getAbsolutePath());
			System.out.println(file_path);
		}else if(resultado == JFileChooser.CANCEL_OPTION) {
			
			erro.setText("Ficheiro não carregado, tente novamente");
			erro.setBounds(53, 313, 269, 36);
			contentPane.add(erro);
			return;	
		}
	}
		
		
		
		public void getURL() {
			 URL = textField.getText();
			System.out.println(URL);
			
		}
		
		public void checkURL() {
			
			
			
		}
		
		 public void download(String texto) throws IOException {
			URL url= new URL(texto);
			 InputStream inputStream = url.openStream();
			 // FALTA FAZER O DOWLOAD
			 File lol = new File(URL);
			 Desktop desk = Desktop.getDesktop();
			 desk.open(lol);
			 System.out.println(lol.getAbsolutePath());
			 System.out.println();
		 }
	
	
	}

