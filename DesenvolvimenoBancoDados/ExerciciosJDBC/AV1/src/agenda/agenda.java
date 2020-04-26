package agenda;
  
import agenda.gui.AgendaFrame;
  
public class agenda {
  
 public static void main(String[] args) {
  new agenda().iniciarTela();
  
 }
  
 private void iniciarTela(){
  AgendaFrame frame = new AgendaFrame();
  frame.setVisible(true);
 }
}