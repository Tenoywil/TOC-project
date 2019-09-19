package main;

import java.awt.EventQueue;

import view.VendingMachineView;

public class driver {
	
public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		@Override
		public void run()
		{
			new VendingMachineView();
		}
	});
}
}
