package hqlproject;


import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {
    private static Accesobd instancia;

    public static void main(String[] args) throws Exception {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        instancia = new Accesobd();
        instancia.abrir();
        menu();
        instancia.cerrar();
    }

    /***
     * Método que lanza el menú y devuelve la opción seleccionada
     * @return
     */
    public static void menu() throws Exception {
        // En opc guardaremos la opción seleccionada por el usuario
        int opc;
        Scanner sc = new Scanner(System.in);

        // Imprimimos el menú con las diversas opciones
        System.out.println("1. Insertar Profesor");
        System.out.println("2. Listar Profesores");
        System.out.println("3. Listar Profesores Query ");
        System.out.println("9. Salir");

        // Leemos la opción de teclado
        opc = sc.nextInt();

        switch (opc){
            case 1:
                insertarObjeto(new ProfesorEntity("López", "Delgado", "Abraham"));
                break;
            case 3:
                insertarObjeto(new DepartamentoEntity("Informatica"));
                break;
            case 4:
                listarProfesores();
                break;
            case 5:
                listarProfesoresCondicion("listaProfesoresNombre","nombre","Paco");
            case 9:
                System.exit(0);
                break;
        }
    }

    public static void insertarObjeto(Object obj) throws Exception {
        instancia.abrir();
        instancia.guardar(obj);
        instancia.cerrar();
    }

    private static void asociarDepProf() throws Exception {
        DepartamentoEntity dep = new DepartamentoEntity();
        ProfesorEntity prof = new ProfesorEntity();
        instancia.abrir();
        prof = (ProfesorEntity)  instancia.leer(prof, 2);
        dep = (DepartamentoEntity) instancia.leer(dep, 1);
        prof.setDepartamento(dep);
        instancia.guardar(prof);
        instancia.cerrar();
    }

    //private static void

    public static void listarProfesores() throws Exception {
        instancia.abrir();
        List<ProfesorEntity> profesores = instancia.listarProfesores();
        for (ProfesorEntity profesor : profesores) {
            System.out.println(profesor.getNombre()+"   "+profesor.getApe1()+"   "+profesor.getApe2());
        }
        instancia.cerrar();
    }

    public static void idDepartamentosPorNombre(String namedQuery, String param, String valor) throws Exception {
        instancia.abrir();
        List<DepartamentoEntity> departamentos = instancia.listarQuery(namedQuery,param,valor);
        for (DepartamentoEntity departamento: departamentos) {
            System.out.println(departamento.getNombre());
        }
        instancia.cerrar();

    }

    public static void listarProfesoresCondicion(String namedQuery, String param, String valor) throws Exception {
        instancia.abrir();
        List<ProfesorEntity> nombres = instancia.listarQuery(namedQuery,param,valor);
        for (ProfesorEntity nombre: nombres) {
            System.out.println(nombre.getNombre());
        }
        instancia.cerrar();

    }
}
