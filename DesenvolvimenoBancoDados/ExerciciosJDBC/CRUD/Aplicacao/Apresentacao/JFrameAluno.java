package Apresentacao;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameAluno extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Nome;
	private JTextField textField_Id;
	private JTextField textField_Cpf;
	private JTextField jTextFieldIdExclusao;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_CPF;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameAluno frame = new JFrameAluno();
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
	public JFrameAluno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Inserir Aluno", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Excluir Aluno", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Atualizar Aluno", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JButton btnNewButton_3 = new JButton("Listar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
	                //Registra JDBC driver
	                Class.forName("com.mysql.jdbc.Driver");
	                //Abrindo a conexão: ATENÇÃO OS DOIS PARÂMETROS VAZIOS(" ") SÃO USUÁRIO E SENHA, RESPECTIVAMENTE.
	                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/escola", "root", "root");
	                //Executa a query de seleção
	                java.sql.Statement st = conn.createStatement();
	                st.executeQuery("select * from aluno");
	                ResultSet rs = st.getResultSet();
	                //Lista os alunos no console
	                while (rs.next()) {
	                    System.out.print(rs.getString("Id") + ", ");
	                    System.out.print(rs.getString("Nome") + ", ");
	                    System.out.println(rs.getString("CPF"));
	                }
	            } catch (SQLException | ClassNotFoundException e) {
	                JOptionPane.showMessageDialog(rootPane, e);
	            }//Fim try

			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addGap(43)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(59, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
							.addComponent(btnNewButton_3)
							.addGap(77))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(21, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
							.addComponent(btnNewButton_3)
							.addGap(31))))
		);
		
		JLabel lblNewLabel_5 = new JLabel("Id Existente:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Novo Nome:\r\n\r\n");
		panel_2.add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		panel_2.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Novo CPF:");
		panel_2.add(lblNewLabel_7);
		
		textField_CPF = new JTextField();
		panel_2.add(textField_CPF);
		textField_CPF.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Atualizar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
	                //Registra JDBC driver
	                Class.forName("com.mysql.jdbc.Driver");

	                //Abrindo a conexão: ATENÇÃO OS DOIS PARÂMETROS VAZIOS(" ") SÃO USUÁRIO E SENHA, RESPECTIVAMENTE.
	                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/escola", "root","root ");

	                //Executa a query de atualização
	                java.sql.Statement st = conn.createStatement();
	                st.executeUpdate("UPDATE aluno SET nome='"
	                                                + this.jTextFieldNovoNome.getText() + "',cpf='"
	                                                + this.jTextFieldNovoCPF.getText()
	                                                + "' WHERE id='" + this.jTextFieldIdExistente.getText() + "'");
	                
	                JOptionPane.showMessageDialog(rootPane, "Aluno atualizado");
	                
	            } catch (SQLException | ClassNotFoundException e) {
	                JOptionPane.showMessageDialog(rootPane, e);
	            }//Fim try

			}
		});
		panel_2.add(btnNewButton_2);
		
		JLabel lblNewLabel_4 = new JLabel("ID a Excluir:");
		panel_1.add(lblNewLabel_4);
		
		jTextFieldIdExclusao = new JTextField();
		panel_1.add(jTextFieldIdExclusao);
		jTextFieldIdExclusao.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Excluir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
	                //Registra JDBC driver
	                Class.forName("com.mysql.jdbc.Driver");

	                //Abrindo a conexão: ATENÇÃO OS DOIS PARÂMETROS VAZIOS(" ") SÃO USUÁRIO E SENHA, RESPECTIVAMENTE.
	                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/escola", "root", "root");

	                //Executa a query de exclusão
	                java.sql.Statement st = conn.createStatement();
	                st.executeUpdate("DELETE FROM Aluno WHERE id='" + this.jTextFieldIdExclusao.getText() + "'");
	                
	                JOptionPane.showMessageDialog(rootPane, "Aluno excluído");
	                
	            } catch (SQLException | ClassNotFoundException e) {
	                JOptionPane.showMessageDialog(rootPane, e);
	            }//Fim try

			}
		});
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("ID:");
		panel.add(lblNewLabel);
		
		textField_Id = new JTextField();
		panel.add(textField_Id);
		textField_Id.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblNewLabel_1);
		
		textField_Nome = new JTextField();
		textField_Nome.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(textField_Nome);
		textField_Nome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CPF:");
		panel.add(lblNewLabel_2);
		
		textField_Cpf = new JTextField();
		panel.add(textField_Cpf);
		textField_Cpf.setColumns(10);
		
		JButton btnNewButton = new JButton("Inserir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
	                //Registra JDBC driver
	                Class.forName("com.mysql.jdbc.Driver");

	                //Abrindo a conexão: ATENÇÃO OS DOIS PARÂMETROS VAZIOS(" ") SÃO USUÁRIO E SENHA, RESPECTIVAMENTE.
	                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/escola", "root", "root");

	                //Executa a query de inserção
	                java.sql.Statement st = conn.createStatement();
	                st.executeUpdate("INSERT INTO aluno (id, nome, cpf) VALUES ("
	                                + this.textField_Id.getText() + ",'"
	                                + this.textField_Nome.getText() + "','"
	                                + this.textField_Cpf.getText() + "')");
	                
	                JOptionPane.showMessageDialog(rootPane, "Aluno inserido");
	                
	            } catch (SQLException | ClassNotFoundException e) {
	                JOptionPane.showMessageDialog(rootPane, e);
	            }//Fim try

			}
		});
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(btnNewButton);
		contentPane.setLayout(gl_contentPane);
	}
}
