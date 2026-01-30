package com.example.LearningJava.controller;

import org.flowable.engine.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/flowable")
public class FlowableProcessController {
    private final RepositoryService repositoryService;

    public FlowableProcessController(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    @GetMapping("/xml-files")
    public List<Map<String, Object>> listDeployedXmlFiles() {

        return repositoryService.createDeploymentQuery()
                .list()
                .stream()
                .flatMap(deployment ->
                        repositoryService.getDeploymentResourceNames(deployment.getId())
                                .stream()
                                .filter(name ->
                                        name.endsWith(".xml") || name.endsWith(".bpmn20.xml"))
                                .map(name -> {
                                    Map<String, Object> fileInfo = new HashMap<>();
                                    fileInfo.put("deploymentId", deployment.getId());
                                    fileInfo.put("fileName", deployment.getName());
                                    return fileInfo;
                                })).toList();
    }
}
