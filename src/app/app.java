package app;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Scanner;

import Ui.MenuUi;
import abstractFactorys.IFactory;

public class app {  
    public static void createProducts(IFactory factory){
		
	}      
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, MalformedURLException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
        int op = 1;

        do {
            File currentDir = new File("./src/plugins");
            String[] plugins = currentDir.list();
            int i;
            URL[] jars = new URL[plugins.length];
            for (i = 0; i < plugins.length; i++) {
                System.out.println(i + 1 + " - " + plugins[i].split("\\.")[0]);
                jars[i] = (new File("./src/plugins" + plugins[i])).toURL();
            }
            URLClassLoader ulc = new URLClassLoader(jars);
            System.out.println(i + 1 + " - Plugin refresh");
            System.out.println("Escolha sua opcao ou 0 para sair: ");
            Scanner sc = new Scanner(System.in);
            op = sc.nextInt();

            if (op != 0 && op != i + 1){
                String factoryName = plugins[op - 1].split("\\.")[0];
                Class metaClasse = Class.forName(factoryName.toLowerCase() + "." + factoryName, true, ulc);
                Method instancedFactory = metaClasse.getDeclaredMethod("getInstance");
                Object factory = (IFactory) instancedFactory.invoke(metaClasse);
				new MenuUi((IFactory) factory);
            }
        } while (op != 0);
    }
}
