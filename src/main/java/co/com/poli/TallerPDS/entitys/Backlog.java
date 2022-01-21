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
@Table(name = "backlog")
public class Backlog extends EntityBase{
    @NotEmpty(message = "No debe ser vacio")
    @Column(name = "projectIdentifier")
    private String projectIdentifier;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProjectTask> projectTask;

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
