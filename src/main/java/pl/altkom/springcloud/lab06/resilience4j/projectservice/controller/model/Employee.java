package pl.altkom.springcloud.lab06.resilience4j.projectservice.controller.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Employee {
    private Long id;

    private String firstName;
    private String lastName;
    private String city;
    private Long projectId;
}