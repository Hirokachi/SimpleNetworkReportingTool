/*
 * This class contains the information for the GUI to run
 * on this program.
 */
package snrt;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextArea;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
/**
 *
 * @author Alex Gaskill
 */
public class GUIClass extends JPanel
                implements ActionListener{
    
    protected JButton getProcess, nextComputer; 
    protected JTextArea processes;
    protected JPanel panelForText;
    
    /**
    * Needs nothing
    */
    public GUIClass() {
        
        processes = new JTextArea("Default text", 10, 10);
        getProcess = new JButton("Go Get Processes!");
        getProcess.setVerticalTextPosition(AbstractButton.CENTER);
        getProcess.setActionCommand("goGetIt");
        
        //Listen for actions on button getProcess.
        getProcess.addActionListener(this);
 
        getProcess.setToolTipText("Click this button to get processes on this"
                + " computer.");
 
        //Add Components to this container, using the default FlowLayout.
        add(getProcess);
        add(processes);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        ProcessComponent pID = new ProcessComponent();
        
        if ("goGetIt".equals(e.getActionCommand())){
            processes.setText(pID.getProcesses());
            System.out.print(processes.getText());
            //processes.setOpaque(true);
            //System.out.print(pID.getProcesses());
            //processes.setVisible(true);
        }
        else {
            processes.setText("Could not find any processes!");
        }
    }
 
    /**
     * Create the GUI and show it.  For thread safety, 
     * this method should be invoked from the 
     * event-dispatching thread.
     */
    public void createAndShowGUI() {

        //Create and set up the window.
        JFrame frame = new JFrame("Simple Network Reporter Tool - SNRT");
        processes = new JTextArea();
        //processes.setVerticalTextPosition();
        //processes.setHorizontalTextPosition();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /*
        *  Add the text field to the panel that will house the text field then
        *  to the window.
        */
        //this.add(processes);
        //System.out.print(processes.isVisible());
 
        //Create and set up the content pane.
        JComponent newContentPane = new GUIClass();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        
        
    }
} 