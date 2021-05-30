package servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import modelo.Cliente;
import utilidades.Utilidad;

public class ExportadorCsv extends Exportador{

	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingresa la ruta en donde desea exportar el archivo clientes.csv:");
		String ruta = sc.nextLine();
		File direc = new File(ruta);
		File arch = new File(ruta+"/"+fileName+".csv");
		
		String stringLista="";
		for (Cliente cliente : listaClientes) {
			stringLista+=cliente.getRunCliente()+","+cliente.getNombreCliente()
			+","+cliente.getApellidoCliente()+","+cliente.getAniosCliente()
			+","+(cliente.getNombreCategoria().toString().substring(0, 1).toUpperCase())
			+(cliente.getNombreCategoria().toString().substring(1).toLowerCase()+"\n");
		}
		//System.out.println(stringLista);
		
		if (direc.exists() == true) {
			System.out.println("Continua en directorio '" + direc + "' existente.");
		} else {
			direc.mkdir();
		
			if (direc.exists()) {
				System.out.println("Se ha creado el directorio '" + direc + "'.");
			} else {
				System.out.println("Directorio no pudo ser creado");
			}
		}
			if (arch.exists() == false) {
				try {
					arch.createNewFile();
					FileWriter fileW = new FileWriter(arch);
					BufferedWriter bw = new BufferedWriter(fileW);

					bw.write(stringLista);
					bw.close();
				} catch (IOException e) {
					System.out.println("Error al crear archivo --" + e.getMessage() + "--");
				}
				if (arch.exists() == true) {
					System.out.println("El archivo " + ruta + "/"+fileName+".csv ha sido creado!");
					Utilidad.clear(1);

				}

			} else {
				System.out.println("Archivo ya existe, no se sobreescribira!");
			}

		

	
	}

}
