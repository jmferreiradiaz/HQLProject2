package hqlproject;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Alumnnos")
@NamedQueries({
        @NamedQuery(name="listaAlumnos", query="from AlumnosEntity "),
        @NamedQuery(name="listaAlumnosApellido1", query="from AlumnosEntity where ape1=:ape1"),
        @NamedQuery(name="listaAlumnosApellido2", query="from AlumnosEntity where ape2=:ape2"),
        @NamedQuery(name="listaAlumnosNombre", query="from AlumnosEntity where nombre=:nombre"),
})
public class AlumnosEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAlum")
    private int idAlum;

    @Column(name = "ape1")
    private String ape1;

    @Column(name = "ape2")
    private String ape2;

    @Column(name = "nombre")
    private String nombre;

    public AlumnosEntity() {
        this.ape1 = "";
        this.ape2 = "";
        this.nombre = "";
    }

    public AlumnosEntity(String ape1, String ape2, String nombre) {
        this.ape1 = ape1;
        this.ape2 = ape2;
        this.nombre = nombre;
    }

    public int getIdAlum() {
        return idAlum;
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
