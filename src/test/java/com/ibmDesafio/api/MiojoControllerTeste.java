package com.ibmDesafio.api;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest
public class MiojoControllerTeste {
    @Autowired
    private MockMvc mockMvc;

    private static final String URL = "/api/v1/preparoMiojo";

    @Test
    public void casoBemSucedido1() throws Exception {

        JSONObject mapToCreate = new JSONObject();
        mapToCreate.put("tempoPreparo", "3");
        mapToCreate.put("ampulheta1", "5");
        mapToCreate.put("ampulheta2", "7");


        this.mockMvc.perform(post(URL).contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new ObjectMapper().writeValueAsString(mapToCreate)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.resultado").value("10"));
    }

    @Test
    public void casoBemSucedido2() throws Exception {

        JSONObject mapToCreate = new JSONObject();
        mapToCreate.put("tempoPreparo", "3");
        mapToCreate.put("ampulheta1", "6");
        mapToCreate.put("ampulheta2", "9");


        this.mockMvc.perform(post(URL).contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new ObjectMapper().writeValueAsString(mapToCreate))).andExpect(status().isOk())
                .andExpect(jsonPath("$.resultado").value("9"));
    }

    @Test
    public void casoBemSucedido3() throws Exception {

        JSONObject mapToCreate = new JSONObject();
        mapToCreate.put("tempoPreparo", "3");
        mapToCreate.put("ampulheta1", "5");
        mapToCreate.put("ampulheta2", "6");


        this.mockMvc.perform(post(URL).contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new ObjectMapper().writeValueAsString(mapToCreate))).andExpect(status().isOk())
                .andExpect(jsonPath("$.resultado").value("15"));
    }

    @Test
    public void casoBemSucedido4() throws Exception {

        JSONObject mapToCreate = new JSONObject();
        mapToCreate.put("tempoPreparo", "14");
        mapToCreate.put("ampulheta1", "15");
        mapToCreate.put("ampulheta2", "22");


        this.mockMvc.perform(post(URL).contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new ObjectMapper().writeValueAsString(mapToCreate))).andExpect(status().isOk())
                .andExpect(jsonPath("$.resultado").value("44"));
    }

    @Test
    public void casoMalSucedido1() throws Exception {

        JSONObject mapToCreate = new JSONObject();
        mapToCreate.put("tempoPreparo", "80");
        mapToCreate.put("ampulheta1", "10");
        mapToCreate.put("ampulheta2", "5");


        this.mockMvc.perform(post(URL).contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new ObjectMapper().writeValueAsString(mapToCreate))).andExpect(status().isBadRequest());
    }

    @Test
    public void casoMalSucedido2() throws Exception {

        JSONObject mapToCreate = new JSONObject();
        mapToCreate.put("tempoPreparo", "80");
        mapToCreate.put("ampulheta1", "");
        mapToCreate.put("ampulheta2", "5");


        this.mockMvc.perform(post(URL).contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new ObjectMapper().writeValueAsString(mapToCreate))).andExpect(status().isBadRequest());
    }

}
