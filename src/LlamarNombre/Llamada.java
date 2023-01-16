package LlamarNombre;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;


public class Llamada {

	public static void main(String[] args) throws IOException {

		File directorio = new File("C:\\Users\\sergi\\eclipse-workspace\\2.CrearNombreEntrega\\bin");

		ProcessBuilder pb = new ProcessBuilder("java", "CrearNombre.Nombre");
		File fInp = new File("nombre.txt");
		File fOut = new File("leerNombre.txt");
		

		pb.directory(directorio);

		pb.redirectOutput(fOut);
		pb.redirectInput(fInp);
		pb.start();

		

		Process p = pb.start();

//		nombre = nombre + "\n";
//		OutputStream os = p.getOutputStream();
//		os.write(nombre.getBytes());
//		os.flush();
//		os.close();

		// COMPROBACION DE ERROR - 0 bien - 1 mal
		int salida = -1;
		try {
			salida = p.waitFor();
			System.out.println("Valor de Salida: " + salida);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (salida == 0) {
			try {

				InputStream is = p.getInputStream();

				int c;
				while ((c = is.read()) != -1)
					System.out.print((char) c);
				is.close();
				System.exit(0);

			} catch (Exception e) {
				System.exit(-1);
				e.printStackTrace();
			}
		}
//		sc.close();
	}

}
