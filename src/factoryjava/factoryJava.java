package factoryjava;

import java.io.File;
import java.io.IOException;

import abstractFactorys.IFactory;

public class factoryJava implements IFactory{
    private static factoryJava instanceJava  = null;

    private factoryJava(){}

    public static factoryJava getInstance(){
        if (instanceJava == null){
            instanceJava = new factoryJava();
        }
        return instanceJava;
    }

    public void build(File file) throws InterruptedException, IOException {
        // TODO Auto-generated method stub
        new javacBuilder(file);	
    }

    public void highlighter(File file) throws IOException {
        // TODO Auto-generated method stub
        new TextJava(file);
    }

    public void highlighter() {
        // TODO Auto-generated method stub
        new TextJava();
    }
    
}
