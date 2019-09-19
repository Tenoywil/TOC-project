package view;


import java.awt.event.*;
import domain.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;



public class VendingMachineView extends JFrame implements ActionListener{
	private static final long serialVersionUID = -1338887732519363404L;
	vendingMachine vm;
	
	Automata automata;
	States sState;
	protected JLabel label = new JLabel();
	protected ImageIcon icon;
	protected int clicked = 0;
	protected JTextPane displayAmt;
	protected JButton btncranWata = new JButton("Cran Wata");
	protected JButton btnDoritos = new JButton("Doritos");
	protected JButton btnPepsi = new JButton("Pepsi");
	protected JButton btnBigFoot = new JButton("Big Foot");
	protected JButton btnBagJuice = new JButton("Bag Juice");
	private final JPanel pnl_ControlPanel,pnl_DisplayPanel;
	private final JButton btnTen = new JButton("Ten");
	private final JButton btnFive = new JButton("Five");
	private final JButton btnTwenty = new JButton("Twenty");
	JLabel background=new JLabel(new ImageIcon(getClass().getResource("HomerVendingMachine.gif")));
	public VendingMachineView() {
		
		setVisible(true);
		setSize(535,425);
		setResizable(false);
		coinButtonsOff();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnTen.addActionListener(this);;
		btnFive.addActionListener(this);
		btnTwenty.addActionListener(this);
		btncranWata.addActionListener(this);
		btnDoritos.addActionListener(this);
		btnPepsi.addActionListener(this);
		btnBigFoot.addActionListener(this);
		 btnBagJuice.addActionListener(this);
		
		background.setLayout(null);
		background.setOpaque(false);
		setContentPane(background);
		JPanel pnl_ButtonPanel = new JPanel();
		pnl_ButtonPanel.setPreferredSize(new Dimension(10, 100));
		pnl_ButtonPanel.setOpaque(false);
		background.add(pnl_ButtonPanel, BorderLayout.SOUTH);
		pnl_ButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
		
		pnl_ControlPanel = new JPanel();
		pnl_ControlPanel.setBorder(new LineBorder(new Color(102, 0, 255), 2, true));
		pnl_ControlPanel.setMaximumSize(new Dimension(400, 32767));
		pnl_ControlPanel.setOpaque(false);
		pnl_ControlPanel.setPreferredSize(new Dimension(100, 75));
		pnl_ButtonPanel.add(pnl_ControlPanel);
		
		displayAmt = new JTextPane();
		displayAmt.setPreferredSize(new Dimension(10, 30));
		displayAmt.setEditable(false);
		displayAmt.setText("click on the desired item");
		displayAmt.setBounds(5, 190, 123, 71);
		
		btncranWata.setBounds(15, 360, 105, 25);
		btnDoritos.setBounds(115, 360, 105, 25);
		btnPepsi.setBounds(215, 360, 105, 25);
		btnBigFoot.setBounds(315, 360, 105, 25);
		btnBagJuice.setBounds(415, 360, 105, 25);
		
		btnFive.setBounds(10,280, 105, 25);
		btnTen.setBounds(10, 305, 105, 25);
		btnTwenty.setBounds(10, 330, 105, 25);
		
		background.add(displayAmt);
		background.add(btncranWata);
		background.add(btnDoritos);
		background.add(btnPepsi);
		background.add(btnBigFoot);
		background.add(btnBagJuice);
		background.add(btnTen);
		background.add(btnFive);
		background.add(btnTwenty);
		
		pnl_DisplayPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));
		pnl_DisplayPanel.setMaximumSize(new Dimension(700, 32767));
		pnl_DisplayPanel.setOpaque(false);
		background.add(pnl_DisplayPanel, BorderLayout.CENTER);

		
	}

	public void stateChange(States state)
	{
		if(state != null)
		{
			machState stateT = null;
			stateT = state.getStateT();
			JBackground arrowPanel = new JBackground(Toolkit.getDefaultToolkit().getImage(VendingMachineView.class.getResource("arrow.png")));
			arrowPanel.setPreferredSize(new Dimension(60, 20));
			arrowPanel.setOpaque(false);
			
			JTextArea txt = new JTextArea(state.toString());
			txt.setFont(new Font("Arial", Font.PLAIN, 12));
			txt.setLineWrap(true);
			txt.setBackground(Color.WHITE);
			txt.setOpaque(true);
			txt.setPreferredSize(new Dimension(100, 50));
			txt.setEditable(false);
			
			switch(stateT)
			{
			case Start:
			{
				txt.setBorder(new LineBorder(Color.green, 2, true));
				break;
			}
			case Normal:
			{
				txt.setBorder(new LineBorder(new Color(204, 102, 255), 2, true));
				break;
			}
			case Final:
			{
				txt.setBorder(new LineBorder(Color.RED, 2, true));
				break;
			}
			default:
			{
				txt.setBorder(new LineBorder(new Color(204, 102, 255), 2, true));
				break;
			}
			}
			int y=10;
			pnl_DisplayPanel.add(txt);
			{
			if(stateT != machState.Final)
				pnl_DisplayPanel.add(arrowPanel);
				pnl_DisplayPanel.revalidate();
				background.add(pnl_DisplayPanel);
				pnl_DisplayPanel.setBounds(150, 20, 300, 300);
				y= y + 100;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource().equals(btnBagJuice)) {
			coinButtonsOn();
			ItemButtonOff();
			displayAmt.setText("Bag Juice Selected");
			automata = new BagJuiceAuto();
			
			stateChange(automata.getsState());
		}
		if (arg0.getSource().equals(btnBigFoot)) {
			coinButtonsOn();
			ItemButtonOff();
			displayAmt.setText("Big Foot Selected");
			automata = new BigfootAuto();
			
			stateChange(automata.getsState());
		}
		if(arg0.getSource().equals(btnDoritos)) {
			coinButtonsOn();
			ItemButtonOff();
			displayAmt.setText("Doritos Selected");
			automata = new DoritosAuto();
			
			stateChange(automata.getsState());
		}
		if(arg0.getSource().equals(btnPepsi)) {
			coinButtonsOn();
		ItemButtonOff();
		displayAmt.setText("Pepsi Selected");
		automata = new PepsiAuto();
		
		stateChange(automata.getsState());
		}
		if(arg0.getSource().equals(btncranWata)) {
			coinButtonsOn();
			ItemButtonOff();
			displayAmt.setText("CranWata Selected");
			automata = new CranWataAuto();
			
			stateChange(automata.getsState());
		}
		if(arg0.getSource().equals(btnFive)) {
			sState = automata.CoinValue(CoinValue.Five);
			if(sState != null) {
				stateChange(sState);
				if(sState.getStateT().equals(machState.Final)) {
					coinButtonsOff();
				}
			}
			
		}
		if(arg0.getSource().equals(btnTen)) {
			sState = automata.CoinValue(CoinValue.Ten);
			if(sState != null) {
				stateChange(sState);
				if(sState.getStateT().equals(machState.Final)) {
					coinButtonsOff();
				}
		}
		if(arg0.getSource().equals(btnTwenty)) {
			sState = automata.CoinValue(CoinValue.Twenty);
			if(sState != null) {
				stateChange(sState);
				if(sState.getStateT().equals(machState.Final)) {
					coinButtonsOff();
				}
		}
			
		}
		}
	}
	public void coinButtonsOn(){
		 btnTen.setEnabled(true);
		 btnFive.setEnabled(true);
			btnTwenty.setEnabled(true);
		
	}
	public void coinButtonsOff(){
		 btnTen.setEnabled(false);
		 btnFive.setEnabled(false);
			btnTwenty.setEnabled(false);
		
	}
	public void ItemButtonOn() {
		btncranWata.setEnabled(true);
		btnDoritos.setEnabled(true);
		btnPepsi.setEnabled(true);
	btnBigFoot.setEnabled(true);
		 btnBagJuice.setEnabled(true);
	}
	public void ItemButtonOff() {
		btncranWata.setEnabled(false);
		btnDoritos.setEnabled(false);
		btnPepsi.setEnabled(false);
	btnBigFoot.setEnabled(false);
		 btnBagJuice.setEnabled(false);
	}
	
}
