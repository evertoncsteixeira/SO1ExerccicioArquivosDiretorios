package controller;
import java.io.File;
import java.io.IOException;
public interface IArquivosController {
	public void copiaArquivos(String diretorio, String nomeArquivo, String
			novoDiretorio) throws IOException;
	public void lerDir(String path) throws IOException;
}
