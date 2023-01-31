package hqlproject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Departamentos")
@NamedQueries({
        @NamedQuery(name = "listaDepartamentos", query = "select d from DepartamentoEntity d "),
        @NamedQuery(name = "listaAlumnosApellido1", query = "select d from DepartamentoEntity d where d.nombre=:nombre")
})

public class DepartamentoEntity implements Serializable {
    //region Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDep")
    private int idDep;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name= "idDep")
    private List<ProfesorEntity> profesores;
    //endregion

    //region Constructor
    public DepartamentoEntity(){
        this.nombre = "";
    }

    public DepartamentoEntity(String nombre) {
        this.nombre = nombre;
    }
    //endregion

    //region Getter y Setters
    public int getIdDep() {
        return idDep;
    }

    public void setIdDep(int idDep) {
        this.idDep = idDep;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //endregion





}
