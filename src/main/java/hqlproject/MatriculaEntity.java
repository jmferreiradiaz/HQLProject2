package hqlproject;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Matriculas")
@NamedQueries({
        @NamedQuery(name="listaAlumnos", query="from AlumnosEntity "),
        @NamedQuery(name="listaAlumnosApellido1", query="from AlumnosEntity where ape1=:ape1"),
        @NamedQuery(name="listaAlumnosApellido2", query="from AlumnosEntity where ape2=:ape2"),
        @NamedQuery(name="listaAlumnosNombre", query="from AlumnosEntity where nombre=:nombre"),
})
public class MatriculaEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMat")
    private int idMat;



    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "idAsig")
    private AsignaturaEntity asignatura;
}
