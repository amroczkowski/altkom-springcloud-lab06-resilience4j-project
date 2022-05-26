package pl.altkom.springcloud.lab06.resilience4j.projectservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.altkom.springcloud.lab06.resilience4j.projectservice.controller.model.CreateProjectRequest;
import pl.altkom.springcloud.lab06.resilience4j.projectservice.controller.model.Project;
import pl.altkom.springcloud.lab06.resilience4j.projectservice.controller.model.UpdateProjectRequest;
import pl.altkom.springcloud.lab06.resilience4j.projectservice.service.ProjectService;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/project")
@RestController
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public List<Project> getProjects() {
        log.info("Get all projects");
        return projectService.getProjects();
    }

    @GetMapping("/{id}")
    public Project getProject(@PathVariable("id") final Long projectId) {
        log.info("Get project {}", projectId);
        return projectService.getProject(projectId);
    }

    @PostMapping
    public Project createProject(@Valid @RequestBody final CreateProjectRequest request) {
        return projectService.createProject(request);
    }

    @PutMapping("/{id}")
    public Project updateProject(@PathVariable("id") final Long projectId, @Valid @RequestBody final UpdateProjectRequest request) {
        return projectService.updateProject(projectId, request);
    }
}
