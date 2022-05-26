package pl.altkom.springcloud.lab06.resilience4j.projectservice.controller.model;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Project {

    private Long id;

    private String name;

    private List<Employee> employees;
}
