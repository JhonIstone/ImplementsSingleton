package factorycpp;

import java.io.File;
import java.io.IOException;

import abstractFactorys.IBuilder;

public class cppBuilder implements IBuilder{
	
    public cppBuilder(File file) throws IOException, InterruptedException {
        compile(file);
    }

    public void compile(File file) throws IOException, InterruptedException {
        // TODO Auto-generated method stub
    	String[] compile = {"g++", "-o", file.getAbsolutePath().replace(".cpp", ""), file.getAbsolutePath()};
    	
    	Process compilecpp = new ProcessBuilder(compile).start();
    	compilecpp.waitFor();
    }
}
