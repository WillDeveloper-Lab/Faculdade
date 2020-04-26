package agenda.gui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import agenda.io.AgendaIO;
import agenda.utils.AgendaUtils;
import agenda.utils.PeriodicidadeEnum;
import agenda.vo.Evento;

import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class CadastroEventoPanel extends JPanel {
	private JTextField tfDescEvento;
	private JTextField tdDataEvento;
	private JTextField tfEncaminharEmail;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private ListaEventosPanel listaEventos;
	private AbstractButton chckbxAlarme;
	private AbstractButton rdbUmaVez;
	private AbstractButton rdbSemanal;
	private JTextField btnSalvar;
	private JTextField btnLimpar;

	/**
	 * Create the panel.
	 */
	public CadastroEventoPanel(ListaEventosPanel listaEventos) {
		  this.listaEventos = listaEventos;

		setLayout(null);
		
		
		JLabel lblDescEvento = new JLabel("Descri\u00E7\u00E3o do Evento");
		lblDescEvento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescEvento.setBounds(23, 21, 138, 14);
		add(lblDescEvento);
		
		tfDescEvento = new JTextField();
		tfDescEvento.setBounds(23, 46, 518, 20);
		add(tfDescEvento);
		tfDescEvento.setColumns(10);
		
		JLabel lblDataEvento = new JLabel("Data do Evento");
		lblDataEvento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataEvento.setBounds(23, 77, 128, 14);
		add(lblDataEvento);
		
		tdDataEvento = new JTextField();
		tdDataEvento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tdDataEvento.setBounds(148, 77, 138, 20);
		add(tdDataEvento);
		tdDataEvento.setColumns(10);
		
		JLabel lblEncaminharEmail = new JLabel("Encaminahr E-mail");
		lblEncaminharEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEncaminharEmail.setBounds(23, 102, 119, 14);
		add(lblEncaminharEmail);
		
		tfEncaminharEmail = new JTextField();
		tfEncaminharEmail.setBounds(148, 102, 234, 20);
		add(tfEncaminharEmail);
		tfEncaminharEmail.setColumns(10);
		
		JLabel lblPeriodicidadeEvento = new JLabel("Periocidade do Evento");
		lblPeriodicidadeEvento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPeriodicidadeEvento.setBounds(23, 138, 159, 14);
		add(lblPeriodicidadeEvento);
		
		JRadioButton rdbUmavez = new JRadioButton("Uma vez");
		buttonGroup.add(rdbUmavez);
		rdbUmavez.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbUmavez.setBounds(203, 136, 83, 23);
		add(rdbUmavez);
		
		JRadioButton rdbSemanal = new JRadioButton("Semanal");
		buttonGroup.add(rdbSemanal);
		rdbSemanal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbSemanal.setBounds(299, 136, 83, 23);
		add(rdbSemanal);
		
		JRadioButton rdbMensal = new JRadioButton("Mensal");
		buttonGroup.add(rdbMensal);
		rdbMensal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbMensal.setBounds(401, 136, 111, 23);
		add(rdbMensal);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setBounds(174, 177, 89, 25);
		add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(322, 179, 89, 23);
		add(btnLimpar);
		
		JCheckBox chckbxAlarme = new JCheckBox("Alarme");
		chckbxAlarme.setBounds(23, 180, 99, 23);
		add(chckbxAlarme);

	}
	private void chamaCadastroEvento(){
		  AgendaIO io = new AgendaIO();
		  Evento evento = new Evento();
		   
		  Object[] novaLinha = new Object[5];
		   
		  evento.setDataEvento(AgendaUtils.getDateFromString(tdDataEvento.getText()));
		  evento.setDescEvento(tfDescEvento.getText());
		  evento.setAlarme(chckbxAlarme.isSelected() ? 1 : 0);
		  evento.setEmailEncaminhar(tfEncaminharEmail.getText());
		   
		  novaLinha[0] = tdDataEvento.getText();
		  novaLinha[1] = tfDescEvento.getText();
		  novaLinha[4] = chckbxAlarme.isSelected() ? "LIGADO" : "DESLIGADO";
		  novaLinha[3] = tfEncaminharEmail.getText();
		     
		  if(rdbUmaVez.isSelected()){
		   evento.setPeriodicidade(PeriodicidadeEnum.UNICO);
		   novaLinha[2] = PeriodicidadeEnum.UNICO;
		  }
		  else if(rdbSemanal.isSelected()){
		   evento.setPeriodicidade(PeriodicidadeEnum.SEMANAL);
		   novaLinha[2] = PeriodicidadeEnum.SEMANAL;
		  }
		  else {
		   evento.setPeriodicidade(PeriodicidadeEnum.MENSAL);
		   novaLinha[2] = PeriodicidadeEnum.MENSAL;
		  }
		   
		  try {
		   io.gravarEvento(evento);             
		  }catch(Exception ex){
		   JOptionPane.showMessageDialog(null, "ERRO", ex.getMessage(), 
		   JOptionPane.ERROR_MESSAGE);
		  }
		  listaEventos.addNewRow(novaLinha);
		  limparCampos();
		  
		  btnSalvar.addActionListener(new ActionListener() {
			  @Override
			  public void actionPerformed(ActionEvent arg0) {
			   chamaCadastroEvento();
			  }
			 });
			    
			 btnLimpar.addActionListener(new ActionListener() {
			  @Override
			  public void actionPerformed(ActionEvent arg0) {
			   limparCampos();                       
			  }
			 });
			 
		}
	private void limparCampos(){
		tdDataEvento.setText("");
		  tfDescEvento.setText("");
		  chckbxAlarme.setSelected(false);
		  tfEncaminharEmail.setText("");
		  rdbUmaVez.setSelected(true);
		}
}
