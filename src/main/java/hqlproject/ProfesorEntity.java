package hqlproject;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Profesores")
@NamedQueries({
        @NamedQuery(name="listaProfesores", query="select p from ProfesorEntity p"),
        @NamedQuery(name="listaProfesoresApellido1", query="select p from ProfesorEntity p where p.ape1=:ape1"),
        @NamedQuery(name="listaProfesoresApellido2", query="select p from ProfesorEntity p where p.ape2=:ape2"),
        @NamedQuery(name="listaProfesoresNombre", query="select p from ProfesorEntity p where p.nombre=:nombre"),
})
public class ProfesorEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProf")
    private int idProf;

    @Column(name = "ape1")
    private String ape1;

    @Column(name = "ape2")
    private String ape2;

    @Column(name = "nombre")
    private String nombre;

    public ProfesorEntity() {
        this.ape1 = "";
        this.ape2 = "";
        this.nombre = "";
    }

    public ProfesorEntity(String ape1, String ape2, String nombre) {
        this.ape1 = ape1;
        this.ape2 = ape2;
        this.nombre = nombre;
    }

    public int getIdProf() {
        return idProf;
    }

    public String getApe1() {
        return ape1;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public String getApe2() {
        return ape2;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
