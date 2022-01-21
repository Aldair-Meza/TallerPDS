package co.com.poli.TallerPDS.entitys;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "project")
public class Project extends EntityBase {

    @Column(name = "project_name", unique = true)
    @NotEmpty(message = "El campo no puede estar vacio")
    private String projectName;
    @Column(name = "project_identifier", unique = true, updatable = false)
    @Length(min = 5, max = 7)
    @NotEmpty(message = "El campo no puede estar vacio")
    private String projectIdentifier;

    @Column(name = "description")
    private String description;

    @Column(name = "startDate")
    protected Date startDate;

    @Column(name = "endDate")
    protected Date endDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "backlog_id")
    @JsonIgnoreProperties(value = { "project" }, allowSetters = true)
    protected Backlog backlog;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Project project = (Project) o;
        return Objects.equals(projectName, project.projectName) && Objects.equals(projectIdentifier, project.projectIdentifier) && Objects.equals(description, project.description) && Objects.equals(startDate, project.startDate) && Objects.equals(endDate, project.endDate) && Objects.equals(backlog, project.backlog);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), projectName, projectIdentifier, description, startDate, endDate, backlog);
    }

}
