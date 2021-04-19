package factorycpp;

import java.io.File;
import java.io.IOException;

import abstractFactorys.IFactory;

public class factoryCpp implements IFactory{
    private static factoryCpp instanceCpp  = null;

    private factoryCpp(){}

    public static factoryCpp getInstance(){
        if (instanceCpp == null){
            instanceCpp = new factoryCpp();
        }
        return instanceCpp;
    }

    @Override
    public void build(File file) throws InterruptedException, IOException {
        // TODO Auto-generated method stub
        new cppBuilder(file);	
    }

    @Override
    public void highlighter(File file) throws IOException {
        // TODO Auto-generated method stub
        new TextCpp(file);
    }

    @Override
    public void highlighter() {
        // TODO Auto-generated method stub
        new TextCpp();
    }    
}
