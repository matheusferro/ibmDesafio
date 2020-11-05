package com.ibmDesafio.api;

import com.ibmDesafio.model.MiojoTempoModel;
import com.ibmDesafio.service.CalculaTempoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("api/v1/preparoMiojo")
public class MiojoController {

    @PostMapping
    public ResponseEntity<?> miojo(@Valid @RequestBody MiojoTempoModel tempo){
        Map<String, Object> response = new HashMap<>();
        CalculaTempoService service = new CalculaTempoService();
        response.put("tempoMinimo", service.calculaTempo(tempo));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
