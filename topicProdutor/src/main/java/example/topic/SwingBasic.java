package example.topic;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
			

		
		add(table);	
		setVisible(true);
		
	}
	@Override
	public void setVisible(final boolean visible) {
	
	  if (visible) {
	     
	  }
	
	  if (!visible || !isVisible()) {
	      super.setVisible(visible);
	  }
	  
	  if (visible) {
	      int state = super.getExtendedState();
	      state &= ~JFrame.ICONIFIED;
	      super.setExtendedState(state);
	      super.setAlwaysOnTop(false);
	      
	      super.setResizable(Boolean.TRUE);
	  }
	}

	
}
