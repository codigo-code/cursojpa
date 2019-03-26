package com.utn;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.utn.entity.EmpleadoEntity;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try {
    		// creo el bean para conectarme a la base de datos y pongo en contexto las clases que esten en entiy
    		EntityManagerFactory persistence = Persistence.createEntityManagerFactory("JPAUTN");
			
    		// me creo un objeto de la entidad
    		EmpleadoEntity emp = new EmpleadoEntity();
    		emp.setNombre("Flaco");
    		emp.setApellido("Spinetta");
    		emp.setCorreo("ElFlaco@spinetta.com.ar");
    		emp.setIdEmployee(1);
    		
    		// Me genero un administrador ( manager) que me permitira interactuar con la base de datos
    		EntityManager et = persistence.createEntityManager();
    		
    		// Abro la conexion con un begin ...
    		// el begin genera un tunel entre mi programa java y la base de datos
    		
    		// Obtenemos la transacion y la iniciamos
    		et.getTransaction().begin();
    		
    		// Persistimos el objeto ( recuerden que puede ir cualquier objeto ya que espera un objet)
    		et.persist(emp);
    		
    		// Guardamos en la tabla el objeto empleado para este ejemplo
    		et.getTransaction().commit();
    		
    		System.out.println("Objeto Guardado!");
		} catch (Exception e) {
			System.out.println("HUBO UN ERROR");
			System.out.println(e.getMessage());
			
		}
    }
}
