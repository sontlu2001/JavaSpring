package com.example.LearningJava.controller;

import com.example.LearningJava.dto.request.product.DecisionRequest;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("api/bpmn")
public class BpmnController {
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

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

    @PostMapping("/holiday-requests/{taskId}/decision")
    public void decide(@PathVariable String taskId,
                       @RequestBody DecisionRequest req) {

        taskService.complete(
                taskId,
                Map.of("approved", req.getDecision())
        );
    }

    @GetMapping("/processes")
    public List<Map<String, Object>> listProcesses() {
        return repositoryService
                .createProcessDefinitionQuery()
                .latestVersion()
                .list()
                .stream()
                .map(pd -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("id", pd.getId());
                    map.put("key", pd.getKey());
                    map.put("name", pd.getName());
                    map.put("version", pd.getVersion());
                    return map;
                })
                .toList();
    }
}
