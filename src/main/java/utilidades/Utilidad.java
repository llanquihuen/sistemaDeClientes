package utilidades;

import java.io.IOException;

public class Utilidad {
	//Limpiar pantalla
	public static void clear(int x){
		for (int i = 0; i < x; i++) {
			System.out.println("\n");
		}
	}
	
	//Esperar Enter
    public static void pause() {
    	try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    //Esperar 3 segundos
	public static void tiempo() {
		int i=3;
		while (i>0) {
			System.out.println(i);
			i--;
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}