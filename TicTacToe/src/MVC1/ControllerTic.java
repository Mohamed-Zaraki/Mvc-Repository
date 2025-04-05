package MVC1;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.JOptionPane;

public class ControllerTic {

	private ModelTic model;
	private View view;
	int i , j;
	public ControllerTic(ModelTic model, View view) {
		super();
		this.model = model;
		this.view = view;
		
		
		for(int i = 0; i < 3; i++) {
		    for(int j = 0; j < 3; j++) {
		        final int row = i;
		        final int col = j;
		        view.getPanel()[i][j].addMouseListener(new MouseAdapter() {
		            @Override
		            public void mouseClicked(MouseEvent e) {
		                if(e.getSource() == view.getPanel()[row][col]) {
		                    boolean Move = model.Move(row, col);
		                   
		                    if(Move) {
		                        view.getLabel()[row][col].setText(String.valueOf(model.getPlayer()));
		                        boolean Win = model.checkWin();
		                        if(ModelTic.i < 9)
			                    {
		                        if(Win) {
		                            JOptionPane.showMessageDialog(view, "Player" + model.getPlayer() +" Wins!");
		                           
		                        } else {
		                            model.Switchplayer();
		                        }
		                    }
		                    else
		                    {
		                    	JOptionPane.showMessageDialog(view, "Draw!");
		                    	ModelTic.i=0;
		                    }
		                    } else {
		                        JOptionPane.showMessageDialog(view, "Actually it's not Empty choose another!");
		                    }
		                }
		            }
		        });
		    }
		}
		view.getButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				model.resetGame();
				SetBoard();
				JOptionPane.showMessageDialog(view, "Game has been reset!");
			}
			
		});
	}
	
	
	private void SetBoard()
	{
		for(int i = 0 ; i < 3 ; i++)
			for(int j = 0 ; j < 3 ; j++)
			{
				view.getLabel()[i][j].setText("");
			}
	}
	
}
