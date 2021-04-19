package Ui;

import javax.swing.BoxLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import abstractFactorys.IFactory;

public class MenuUi extends JFrame implements ActionListener{
    private JButton[] butoes;
    private IFactory myfactory;

    public MenuUi(IFactory factory) {
        this.myfactory = factory;
        this.setTitle("Operações");
        this.setLayout(null);

        Class metaClasse = factory.getClass();
        Method methods[] = metaClasse.getDeclaredMethods();

        int i = 0;
        int yLocation = 10;
        this.butoes = new JButton[methods.length];
        this.setSize(220, methods.length * 43);

        for (Method method : methods) {
            if (!Modifier.isStatic(method.getModifiers())){
                this.butoes[i] = new JButton(method.getName().toUpperCase() + 
                '(' + method.getParameterCount() + " files)");
                this.butoes[i].setBounds(13, yLocation, 180, 25);
                this.add(this.butoes[i]);
                this.butoes[i].addActionListener(this);
                i++;
                yLocation += 40;
                ;
            }
        }
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("BUILD(1 files)")){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try {
                    myfactory.build(file);
                } catch (InterruptedException | IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }
            
        if(e.getActionCommand().equalsIgnoreCase("HIGHLIGHTER(1 files)")){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try {
                    myfactory.highlighter(file);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }
        if(e.getActionCommand().equalsIgnoreCase("HIGHLIGHTER(0 files)"))
            myfactory.highlighter();
    }
}
