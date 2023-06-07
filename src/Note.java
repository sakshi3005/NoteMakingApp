import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Note extends JFrame {
    private JTextArea textArea;
    private JButton addButton;
    private JButton removeButton;
    private JList<String> noteList;
    private DefaultListModel<String> listModel;
    private ArrayList<String> notes;

    public Note() {
        // Set up the JFrame
        setTitle("Note App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Create components
        textArea = new JTextArea();
        addButton = new JButton("Add");
        removeButton = new JButton("Remove");
        noteList = new JList<>();
        listModel = new DefaultListModel<>();
        notes = new ArrayList<>();

        // Set up the add button action listener
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNote();
            }
        });

        // Set up the remove button action listener
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeNote();
            }
        });

        // Set up the layout
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout( new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        
        panel.add(buttonPanel,BorderLayout.SOUTH);
        
        setLayout(new BorderLayout());
        add(panel,BorderLayout.WEST);
        add(new JScrollPane(noteList),BorderLayout.CENTER);
        
        noteList.setModel(listModel);
        
        
        
    }
    
     private void addNote() {
    	 String note=textArea.getText();
    	 notes.add(note);
    	 listModel.addElement( note);
    	 textArea.setText("");
     }
     
     private void removeNote() {
    	 int selectedIndex = noteList.getSelectedIndex();
    	 if(selectedIndex != -1) {
    		 notes.remove(selectedIndex);
    		 listModel.remove(selectedIndex);
    	 }
    	 
     }
    
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
                    Note note=new Note();
                    note.setVisible(true);
			}
    		
    	});
    }
}