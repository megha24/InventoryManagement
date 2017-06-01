package com.megs.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.megs.models.Supplier;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml"})
public class SupplierControllerTest {
    @Autowired
    WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShouldSaveSupplierAndReturnTrue() throws Exception {
        Supplier supplier = new Supplier("s3",null,"l1");
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(supplier);
        this.mockMvc.perform(post("/suppliers").contentType(MediaType.APPLICATION_JSON).content(s)).andExpect(status().isOk()).andReturn();
    }

}
