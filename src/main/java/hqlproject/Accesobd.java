package hqlproject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.TypedQuery;
import java.util.List;

public class Accesobd {
    private SessionFactory sf;
    private Session sesion;
    private Transaction transaction;

    protected void setUp() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // por defecto: hibernate.cfg.xml
                .build();
        try {
            sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public void abrir() throws Exception {
        setUp();
        sesion = sf.openSession();
        transaction = sesion.beginTransaction();
    }

    public void cerrar() {
        try {
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        sf.close();
    }


    public List<ProfesorEntity> listarProfesores(){
        return sesion.createQuery("From ProfesorEntity ").getResultList();
    }

    public List listarProfesoresQuery(String namedQuery, String param, String valor) {
        TypedQuery lista = sesion.getNamedQuery(namedQuery).setParameter(param,valor);
        return lista.getResultList();
    }



    public Object guardar(Object obj) {
        return sesion.save(obj);
    }
}
