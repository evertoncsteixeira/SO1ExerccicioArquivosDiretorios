package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class ArquivosController implements IArquivosController {

	public ArquivosController() {
		super();
	}

	@Override
	public void copiaArquivos(String diretorio, String nomeArquivo, String novoDiretorio) throws IOException {
		File arq = new File(diretorio, nomeArquivo);
		File newArq = new File(novoDiretorio, nomeArquivo);
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			OutputStream os = new FileOutputStream(newArq);
			byte[] buffer = new byte[1024];
			int len = fluxo.read(buffer);
			while (len != -1) {
				os.write(buffer, 0, len);
				len = fluxo.read(buffer);
			}
			fluxo.close();
			os.close();
		} else {
			throw new IOException("Arquivo não encontrado");
		}
	}

	@Override
	public void lerDir(String path) throws IOException {
		File dir = new File(path);
		if (dir.exists() && dir.isDirectory()) {
			File[] files = dir.listFiles();
			int cont = 0;
			for (File f : files) {
				if (f.isFile()) {
					cont++;
					// System.out.println(arquivos[cont][1]);
				} else {

				}
			}
			String[][] arquivos = new String[cont][2];
			cont = 0;
			for (File f : files) {
				if (f.isFile()) {
					arquivos[cont][0] = Double.toString(f.length() / 1024);
					arquivos[cont][1] = f.getName();
					cont ++;
				} else {

				}
			}
			
			arquivos = classificaM(arquivos);
			for (int i = 0; i < cont; i++) {
				System.out.println("Arquivo : " + arquivos[i][1] + " tamanho " + arquivos[i][0] + " MB");
			}

		} else {
			throw new IOException("Diretorio inválido");
		}

	};

	public static String[][] classificaM(String[][] v) {
		int cont1, cont2;
		String aux, aux2;

		for (cont1 = 0; cont1 < v.length; cont1++) {
			for (cont2 = (cont1 + 1); cont2 < v.length; cont2++) {
				if (Double.parseDouble(v[cont1][0]) > Double.parseDouble(v[cont2][0])) {
					aux = v[cont1][0];
					v[cont1][0] = v[cont2][0];
					v[cont2][0] = aux;

					aux2 = v[cont1][1];
					v[cont1][1] = v[cont2][1];
					v[cont2][1] = aux2;
				}
			}
		}
		return v;
	}
}
