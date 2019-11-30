package Layout;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GravaArquivo {
	
	public static void gravaRegistro (String nomeArq, String registro) {
		BufferedWriter saida = null;
		try {
		
			saida = new BufferedWriter(new FileWriter(nomeArq, true));
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}

		try {
				saida.append(registro + "\n");
			    saida.close();

		} catch (IOException e) {
			System.err.printf("Erro ao gravar arquivo: %s.\n", e.getMessage());
		}
	}
	
	

	public static void main(String[] args) {
		
		String nomeArq = "Momentos";
		String header = "";
		String corpo = "";
		String trailer = "";
		int contRegDados = 0;

		Date dataDeHoje = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");  
		
		header += "00";
		header += "Momentos";
		header += formatter.format(dataDeHoje);
		header += String.format("%-128s", "Vinicius Ruiz");

		gravaRegistro(nomeArq, header);
		
		corpo += "02";
		corpo += String.format("%-256s", "/memoryline/arquivodeimagem24112019175600.png");
		corpo += "IMAGE";
		corpo += String.format("%-1024s", "Adorei esse dia =))");
		contRegDados++;
		gravaRegistro(nomeArq,corpo);
		corpo = "";

		corpo += "02";
		corpo += String.format("%-256s", "/memoryline/arquivodetexto24112019175600.txt");
		corpo += "TEXT ";
		corpo += String.format("%-1024s", "Meus pensamentos...");
		contRegDados++;
		gravaRegistro(nomeArq,corpo);
		corpo = "";
		
		corpo += "02";
		corpo += String.format("%-256s", "/memoryline/arquivodevideo24112019175600.mp4");
		corpo += "VIDEO";
		corpo += String.format("%-1024s", "Adorei esse video =))");
		contRegDados++;
		gravaRegistro(nomeArq,corpo);
		corpo = "";
		
		trailer += "01";
		trailer += String.format("%012d", contRegDados);
		
		gravaRegistro(nomeArq,trailer);
	}

}
