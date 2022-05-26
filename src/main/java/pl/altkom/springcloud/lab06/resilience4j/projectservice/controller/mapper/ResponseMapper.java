package pl.altkom.springcloud.lab06.resilience4j.projectservice.controller.mapper;

import java.util.List;
import java.util.stream.Collectors;

import pl.altkom.springcloud.lab06.resilience4j.projectservice.controller.model.Employee;
import pl.altkom.springcloud.lab06.resilience4j.projectservice.repository.model.Project;

public class ResponseMapper {
    public static List<pl.altkom.springcloud.lab06.resilience4j.projectservice.controller.model.Project> map(final List<Project> projects,
            final List<Employee> employees) {
        return projects.stream()
                .map(project -> map(project,
                        employees.stream().filter(d -> d.getProjectId().equals(project.getId())).collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    public static pl.altkom.springcloud.lab06.resilience4j.projectservice.controller.model.Project map(final Project project,
            final List<Employee> employees) {
        return pl.altkom.springcloud.lab06.resilience4j.projectservice.controller.model.Project.builder()
                .id(project.getId())
                .name(project.getName())
                .employees(employees)
                .build();
    }
}
