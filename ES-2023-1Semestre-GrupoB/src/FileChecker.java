
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileChecker {

	File file;
	String linha;
	Scanner scanner;

	public FileChecker(File file) throws FileNotFoundException {

		this.file = file;
		this.scanner = new Scanner(file);

	}

	public boolean checkRows(String row) {

		linha = scanner.nextLine();
		String[] colunas = linha.split(";");

		String coluna1 = colunas[0];
		String coluna2 = colunas[1];
		String coluna3 = colunas[2];
		String coluna4 = colunas[3];
		String coluna5 = colunas[4];
		String coluna6 = colunas[5];
		String coluna7 = colunas[6];
		String coluna8 = colunas[7];
		String coluna9 = colunas[8];
		String coluna10 = colunas[9];
		String coluna11 = colunas[10];

		if (coluna1.equals("Curso") && coluna2.equals("Unidade Curricular") && coluna3.equals("Turno")
				&& coluna4.equals("Turma") && coluna5.equals("Inscritos no turno") && coluna6.equals("Dia da semana")
				&& coluna7.equals("Hora início da aula") && coluna8.equals("Hora fim da aula")
				&& coluna9.equals("Data da aula") && coluna10.equals("Características da sala pedida para a aula")
				&& coluna11.equals("Sala atribuída à aula")) {
			return true;
		} else {

			return false;
		}
	}

}
