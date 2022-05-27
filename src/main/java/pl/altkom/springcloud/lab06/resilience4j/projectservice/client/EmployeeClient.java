package pl.altkom.springcloud.lab06.resilience4j.projectservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.github.resilience4j.retry.annotation.Retry;
import pl.altkom.springcloud.lab06.resilience4j.projectservice.client.model.Employee;
import pl.altkom.springcloud.lab06.resilience4j.projectservice.controller.model.Project;

@FeignClient(value = "EMPLOYEE-SERVICE", fallback = EmployeeClientFallback.class)
public interface EmployeeClient {

//    @Retry(name = "EmployeeClientgetProjectEmployeesLong")
    @GetMapping("/employee/project/{projectId}")
    List<Employee> getProjectEmployees(@PathVariable("projectId") final Long projectId);

    @GetMapping("/employee")
    List<Employee> getEmployees();
}
