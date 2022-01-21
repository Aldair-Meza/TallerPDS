package co.com.poli.TallerPDS.entitys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "project")
public class Backlog {
    @NotEmpty(message = "No debe ser vacio")
    @Column(name = "projectIdentifier")
    protected String projectIdentifier;

    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL)
    @NotEmpty(message = "El campo no puede estar vacio")
    @JoinColumn(name = "project_id")
    protected Project project;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    protected List<ProjectTask> projectTask;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Backlog backlog = (Backlog) o;
        return Objects.equals(projectIdentifier, backlog.projectIdentifier) && Objects.equals(project, backlog.project) && Objects.equals(projectTask, backlog.projectTask);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectIdentifier, project, projectTask);
    }
}
