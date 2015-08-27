package example.topic;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SwingBasic extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2603040007677913811L;
	JPanel row = new JPanel();
	String[] columnNames = {"Descrição",
            "Valor",
            "Lotes",
            "Tipo de operação"};

	JButton botaoCancelar = new  JButton("Cancelar assinatura");
	JTable table = new JTable(new DefaultTableModel(columnNames,0));
	
	GridLayout experimentLayout = new GridLayout(0,1);
	DefaultTableModel model ;
	public SwingBasic() {
		
		
		 model = (DefaultTableModel) table.getModel();
		 
	}
	public void start(Operacao operacao) {
		
	
		
		
		 model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[] {operacao.getDescricao(), operacao.getValorLote(), operacao.getQuantidadeLotes(),operacao.getTipoOperacao().getDescricao() });
			setSize(800, 800);
			 JScrollBar hbar = new JScrollBar(
		                JScrollBar.HORIZONTAL, 30, 20, 0, 300);

		
		table.add(hbar);
		add(table);	
		setVisible(true);
		
	}
	@Override
	public void setVisible(final boolean visible) {
	  // make sure that frame is marked as not disposed if it is asked to be visible
	  if (visible) {
	     
	  }
	  // let's handle visibility...
	  if (!visible || !isVisible()) { // have to check this condition simply because super.setVisible(true) invokes toFront if frame was already visible
	      super.setVisible(visible);
	  }
	  // ...and bring frame to the front.. in a strange and weird way
	  if (visible) {
	      int state = super.getExtendedState();
	      state &= ~JFrame.ICONIFIED;
	      super.setExtendedState(state);
	      
	      super.setAlwaysOnTop(false);
	      
	      super.setResizable(Boolean.TRUE);
	  }
	}

	
}
