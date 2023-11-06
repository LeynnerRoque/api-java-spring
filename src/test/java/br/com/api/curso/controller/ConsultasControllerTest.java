package br.com.api.curso.controller;

import br.com.api.curso.records.ConsultasRecord;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class ConsultasControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JacksonTester<ConsultasRecord> consultasRecordJacksonTester;

    @Test
    @DisplayName("verificar e-mail errado")
    @WithMockUser
    void agendarCenario1() throws Exception {
      var response =  mockMvc.perform(MockMvcRequestBuilders.post("/consultas"))
                .andReturn().getResponse();

      assertEquals(response.getStatus(), HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("verificar e-mail correto")
    @WithMockUser
    void agendarCenario2() throws Exception {

        var jsonEnvio = consultasRecordJacksonTester.write(new ConsultasRecord(1L,1L, 1L));

        var response =  mockMvc
                .perform(MockMvcRequestBuilders.post(
                        "/consultas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonEnvio.getJson())
                )
                .andReturn().getResponse();

        assertEquals(response.getStatus(), HttpStatus.OK.value());
    }
}