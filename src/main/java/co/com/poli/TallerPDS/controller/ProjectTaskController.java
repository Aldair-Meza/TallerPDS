package co.com.poli.TallerPDS.controller;

import co.com.poli.TallerPDS.entitys.Backlog;
import co.com.poli.TallerPDS.entitys.ProjectTask;
import co.com.poli.TallerPDS.helper.ResponseBuilder;
import co.com.poli.TallerPDS.model.Response;
import co.com.poli.TallerPDS.service.BackLogService;
import co.com.poli.TallerPDS.service.ProjectTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/projectTask")
@RequiredArgsConstructor
public class ProjectTaskController {

    private final ProjectTaskService service;
    private final ResponseBuilder builder;


    @PostMapping
    public Response create(@Valid @RequestBody ProjectTask projectTask, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(formatMessage(result));
        }
        service.create(projectTask);
        return builder.success(projectTask);

    }

    private  List<Map<String,String>> formatMessage(BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err -> {
                    Map<String,String> error = new HashMap<>();
                    error.put(err.getField(),err.getDefaultMessage());
                    return error;
                }).collect(Collectors.toList());
        return errors;
    }
}
