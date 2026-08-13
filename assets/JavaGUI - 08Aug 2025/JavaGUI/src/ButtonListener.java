import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    JButton jButton;

    public void start(){
        JFrame jFrame = new JFrame("ActionListener Implementation");
        jButton = new JButton("Open Dialog");
        jButton.addActionListener(this);
        jFrame.add(jButton);
        jFrame.setBounds(20,80,400,400);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jButton){
            DialogMessage dlgMsg = new DialogMessage();
        }
    }
    static class DialogMessage extends JDialog implements ActionListener{

        DialogMessage(){
            JPanel jPanel = new JPanel();

            jPanel.add(new JLabel("This should be JTextfield text"));
            this.add(jPanel);
            JPanel btnPnl = new JPanel();
            JButton btnOK = new JButton("OK");
            btnOK.addActionListener(this);
            btnPnl.add(btnOK);
            this.add(btnPnl, BorderLayout.SOUTH);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            pack();
            setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            dispose();
        }
    }
}
