package com.example.LearningJava.controller;

import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("api/bpmn")
public class BpmnController {
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;

    @PostMapping("/deploy")
    public ResponseEntity<?> deploy(@RequestParam String fileName) {

        Deployment deployment = repositoryService
                .createDeployment()
                .name("Manual deploy " + fileName)
                .addClasspathResource("processes/" + fileName)
                .deploy();

        return ResponseEntity.ok(
                Map.of(
                        "deploymentId", deployment.getId(),
                        "file", fileName
                )
        );
    }


    @PostMapping("/start")
    public ResponseEntity<?> startWithVariables(
            @RequestParam String processKey,
            @RequestBody Map<String, Object> variables
    ) {
        ProcessInstance processInstance =
                runtimeService.startProcessInstanceByKey(processKey, variables);

        return ResponseEntity.ok(
                Map.of(
                        "processInstanceId", processInstance.getId(),
                        "processDefinitionId", processInstance.getProcessDefinitionId()
                )
        );
    }
}
