package co.com.poli.TallerPDS.entitys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "projectTask")
public class ProjectTask extends EntityBase{
    @NotEmpty(message = "No debe ser vacio")
    @Column(name = "name")
    protected String name;

    @NotEmpty(message = "No debe ser vacio")
    @Column(name = "summary")
    protected String summary;

    @Column(name = "acceptanceCriteria")
    protected String acceptanceCriteria;

    @Column(name = "status")
    protected String StatusTaskstatus;
    @Column(name = "priority")
    @Range(min = 1, max = 5, message = "El campo priority debe estar en un rango de 1 - 5")
    protected int priority;

    @Positive(message = "Las horas deben estar en el rango de 1-8")
    @Range(min = 1, max = 8, message = "Las horas deben estar en el rango de 1-8")
    @Column(name = "hours")
    protected Double hours;
    @Column(name = "startDate")
    protected Date startDate;

    @Column(name = "endDate")
    protected Date endDate;
    @Column(name = "projectIdentifier")
    protected String projectIdentifier;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Backlog_id")
    private Backlog backlog;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectTask that = (ProjectTask) o;
        return priority == that.priority && Objects.equals(name, that.name) && Objects.equals(summary, that.summary) && Objects.equals(acceptanceCriteria, that.acceptanceCriteria) && Objects.equals(StatusTaskstatus, that.StatusTaskstatus) && Objects.equals(hours, that.hours) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(projectIdentifier, that.projectIdentifier) && Objects.equals(backlog, that.backlog);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, summary, acceptanceCriteria, StatusTaskstatus, priority, hours, startDate, endDate, projectIdentifier, backlog);
    }
}



