package pl.altkom.springcloud.lab06.resilience4j.projectservice.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public Project getProject(@PathVariable("id") final Long projectId,
                              @RequestParam("sleep") final boolean sleep) {
        log.info("Get project {}", projectId);
        return projectService.getProject(projectId, sleep);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Project createProject(@Valid @RequestBody final CreateProjectRequest request) {
        return projectService.createProject(request);
    }

    @PutMapping("/{id}")
    public Project updateProject(@PathVariable("id") final Long projectId, @Valid @RequestBody final UpdateProjectRequest request) {
        return projectService.updateProject(projectId, request);
    }
}
