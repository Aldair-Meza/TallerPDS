package co.com.poli.TallerPDS.controller;

import co.com.poli.TallerPDS.entitys.Project;
import co.com.poli.TallerPDS.helper.ResponseBuilder;
import co.com.poli.TallerPDS.model.Response;
import co.com.poli.TallerPDS.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService service;
    private final ResponseBuilder builder;

    @PostMapping
    public Response create(@RequestBody @Valid Project project, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(formatMessage(result));
        }
        service.create(project);
        return builder.success(project);

    }

    private List<Map<String,String>> formatMessage(BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err -> {
                    Map<String,String> error = new HashMap<>();
                    error.put(err.getField(),err.getDefaultMessage());
                    return error;
                }).collect(Collectors.toList());
        return errors;
    }
}
