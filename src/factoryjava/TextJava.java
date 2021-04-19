package factoryjava;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

import abstractFactorys.ITextHighlight;

public class TextJava extends JFrame implements ITextHighlight{
    
    public TextJava(File file) throws IOException{
    	setHighlight(file);
    }
    
    public TextJava(){
    	setHighlight();
	}

	public void setHighlight(File file) throws IOException {
		// TODO Auto-generated method stub
		JPanel cp = new JPanel(new BorderLayout());

        RSyntaxTextArea textArea = new RSyntaxTextArea(60, 160);
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        textArea.setCodeFoldingEnabled(true);
        
        if (file.getAbsoluteFile() != null) {
        	FileReader reader = new FileReader(file.getAbsoluteFile());
        	BufferedReader br = new BufferedReader(reader);
        	textArea.read(br, null);
        	br.close();
        }
        
        RTextScrollPane sp = new RTextScrollPane(textArea);
        cp.add(sp);

        setContentPane(cp);
        setTitle("Text Editor Java");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        this.setVisible(true);
	}

	public void setHighlight(){
		// TODO Auto-generated method stub
		JPanel cp = new JPanel(new BorderLayout());

        RSyntaxTextArea textArea = new RSyntaxTextArea(60, 160);
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        textArea.setCodeFoldingEnabled(true);
        
        RTextScrollPane sp = new RTextScrollPane(textArea);
        cp.add(sp);

        setContentPane(cp);
        setTitle("Text Editor Java");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        this.setVisible(true);
	}
}
