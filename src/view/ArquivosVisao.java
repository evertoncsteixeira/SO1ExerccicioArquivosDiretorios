package view;
import java.io.IOException;

import controller.ArquivosController;
import controller.IArquivosController;
public class ArquivosVisao {

	public static void main(String[] args) {
		IArquivosController arqCont = new ArquivosController();
		String dir = "C:\\SIGCR";
		String dirNovo = "C:\\Forma";
		String arq = "teste.txt";
		try {
			//arqCont.copiaArquivos(dir,arq,dirNovo);
			arqCont.lerDir(dir);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
