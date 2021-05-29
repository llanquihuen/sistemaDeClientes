package servicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import modelo.CategoriaEnum;
import modelo.Cliente;

public class ArchivoServicio extends Exportador{

	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
	}
	public void cargarDatos(String fileName,ClienteServicio listaDeClientes) {
		Scanner sc = new Scanner(System.in);
		File direc = new File(fileName);
		File arch = new File(fileName + "/DBClientes.csv");
		String data="";
		
		//	Verificacion y Lectura de Archivo
		if (!direc.exists() == true) {
			System.out.println("No se encuentra'" + direc + "'.");
		} else {
			if (arch.exists() == true) {
				try {
					FileReader fileR = new FileReader(arch);
					BufferedReader br = new BufferedReader(fileR);
					data = br.readLine(); 
						while (data != null) {
							System.out.println(data);
						String [] miArray1 = data.split("\\,");
						data = br.readLine();
						listaDeClientes.agregarCliente(new Cliente(miArray1[0],miArray1[1],miArray1[2],miArray1[3],(miArray1[4].equals("Activo")?CategoriaEnum.ACTIVO:miArray1[4].equals("Inactivo")?CategoriaEnum.INACTIVO:CategoriaEnum.ACTIVO)));
						}
					br.close();
					
					System.out.println("Datos cargados correctamente en la lista");
				} catch (IOException e) {
					System.out.println("Error al crear archivo --" + e.getMessage() + "--");
				}
			
				
			} else {
				System.out.println("No se encuentra el archivo");
			}

			

		}
	}
	

}
