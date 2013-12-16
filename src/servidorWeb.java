import java.net.ServerSocket;
import java.net.Socket;

public class servidorWeb {
	int puerto = 90;

	final int ERROR = 0;
	final int WARNING = 1;
	final int DEBUG = 2;

	// funcion para centralizar los mensajes de depuracion

	void depura(String mensaje) {
		depura(mensaje, DEBUG);
	}

	void depura(String mensaje, int gravedad) {
		System.out.println("Mensaje: " + mensaje);
	}

	// punto de entrada a nuestro programa
	public static void main(String[] array) {
		servidorWeb instancia = new servidorWeb(array);
		instancia.arranca();
	}

	// constructor que interpreta los parameros pasados
	servidorWeb(String[] param) {
		procesaParametros();
	}

	// parsearemos el fichero de entrada y estableceremos las variables de clase
	boolean procesaParametros() {
		return true;
	}

	boolean arranca() {
		depura("Arrancamos nuestro servidor", DEBUG);

		try {
			ServerSocket s = new ServerSocket(puerto);

			depura("Quedamos a la espera de conexion");

			while (true) // bucle infinito .... ya veremos como hacerlo de otro
							// modo
			{
				Socket entrante = s.accept();
				peticionWeb pCliente = new peticionWeb(entrante);
				pCliente.start();
				//TODO
			}

		} catch (Exception e) {
			depura("Error en servidor\n" + e.toString());
		}

		return true;
	}

}
