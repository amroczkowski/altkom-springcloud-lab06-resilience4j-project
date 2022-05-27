package pl.altkom.springcloud.lab06.resilience4j.projectservice.client;

import java.util.List;

import org.springframework.stereotype.Component;

import pl.altkom.springcloud.lab06.resilience4j.projectservice.client.model.Employee;

@Component
public class EmployeeClientFallback implements EmployeeClient {

    @Override
    public List<Employee> getProjectEmployees(final Long projectId) {
        throw new IllegalStateException("Project employee didn't responde");
    }

    @Override
    public List<Employee> getEmployees() {
        throw new IllegalStateException("Project employee didn't responde");
    }
}
