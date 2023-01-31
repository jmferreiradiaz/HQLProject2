package hqlproject;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Asignaturas")
@NamedQueries({
        @NamedQuery(name="listaAsignaturas", query="select a from AsignaturaEntity a"),
        @NamedQuery(name="listaAsignaturasNombre", query="select a from AsignaturaEntity a where a.nombre=:nombre"),
        @NamedQuery(name="listaAsignaturasCurso", query="select a from AsignaturaEntity a where a.curso=:curso"),
        @NamedQuery(name="listaAsignaturasHoras", query="select a from AsignaturaEntity a where a.horas=:horas"),
})
public class AsignaturaEntity implements Serializable {
    //region Entidades
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAsig")
    private int idAsig;

    @Column(name = "curso")
    private int curso;

    @Column(name = "horas")
    private int horas;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "idProf")
    private ProfesorEntity profesor;
    //endregion

    //region Constructores

    public AsignaturaEntity() {
        this.curso = 0;
        this.horas = 0;
        this.nombre = "";
        this.profesor = new ProfesorEntity();
    }

    public AsignaturaEntity(int curso, int horas, String nombre, ProfesorEntity profesor) {
        this.curso = curso;
        this.horas = horas;
        this.nombre = nombre;
        this.profesor = profesor;
    }
    //endregion

    //region propiedades

    public int getIdAsig() {
        return idAsig;
    }

    public int getCurso() {
        return curso;
    }

    public void setIdAsig(int idAsig) {
        this.idAsig = idAsig;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ProfesorEntity getProfesor() {
        return profesor;
    }

    public void setProfesor(ProfesorEntity profesor) {
        this.profesor = profesor;
    }

    //endregion



}
