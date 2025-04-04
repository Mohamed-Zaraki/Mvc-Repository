package MVCEX3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FileController {
	
	private ModelFile modelfile;
	private View view;
	
	public FileController(ModelFile modelfile, View view) {
		super();
		this.modelfile = modelfile;
		this.view = view;
	
	
	view.getBrowse().addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			int response = view.getFileChooser().showOpenDialog(view);
			
			if(response == JFileChooser.APPROVE_OPTION)
			{
				File File = view.getFileChooser().getSelectedFile();
				
				
				
				try(BufferedReader Reader = new BufferedReader(new FileReader(File.getAbsolutePath()))){
					String Line;
					List<String> Contenu = new ArrayList<>();
				while((Line = Reader.readLine())!=null)
				{
					Contenu.add(Line);
				}
				
				view.getTextarea().setText(String.join("\n", Contenu));
				
				
				}
				 catch (FileNotFoundException e1) {
					    JOptionPane.showMessageDialog(view, "Error: File not found!", "File Error", JOptionPane.ERROR_MESSAGE);
					} catch (IOException e1) {
					    JOptionPane.showMessageDialog(view, "Error: Unable to read file!", "Read Error", JOptionPane.ERROR_MESSAGE);
					} catch (Exception e2) {
					    e2.printStackTrace();
					}
				}
			
		}
		
		
		
	});
	
		view.getDelete().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				int response = view.getFileChooser().showOpenDialog(view);
				
				if(response == JFileChooser.APPROVE_OPTION)
				{
					File file = view.getFileChooser().getSelectedFile();
					
					int confirm=JOptionPane.showConfirmDialog(view, "you sure you want to delete this" , "Delete" , JOptionPane.YES_NO_OPTION);
					if(confirm == JOptionPane.YES_OPTION)
					{
					boolean success = modelfile.deleteFile(file.getAbsolutePath());
					
					if(success)
					{
						JOptionPane.showMessageDialog(view, "File removed Successfuly", "Removing File", JOptionPane.INFORMATION_MESSAGE);
						
					}
					else
					{
						JOptionPane.showMessageDialog(view, "File not removed ", "Removing File", JOptionPane.ERROR_MESSAGE);
					}
				}
				}
			}
			
			
		});
			
		view.getMove().addActionListener(e -> {
		
		    view.getFileChooser().setFileSelectionMode(JFileChooser.FILES_ONLY);
		    
		    int source =  view.getFileChooser().showOpenDialog(view);
		    if (source == JFileChooser.APPROVE_OPTION) {
		        File sourceFile =  view.getFileChooser().getSelectedFile();

		       
		        view.getFileChooser().setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		        int dest = view.getFileChooser().showSaveDialog(view);
		        if (dest == JFileChooser.APPROVE_OPTION) {
		        
		            File destinationFolder =  view.getFileChooser().getSelectedFile(); 
		            File destinationFile = new File(destinationFolder, sourceFile.getName()); 
		            
		            
		            if (modelfile.moveFile(sourceFile.getAbsolutePath(), destinationFile.getAbsolutePath())) {
		                JOptionPane.showMessageDialog(view, "File moved successfully!");

		                
		                view.getFileChooser().rescanCurrentDirectory(); 
		            } else {
		                JOptionPane.showMessageDialog(view, "Failed to move file.");
		            }
		        }
		    }
		});
	
	
	
	}
	
	
	
	
	

}
