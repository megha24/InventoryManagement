package com.megs.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.megs.models.Item;
import com.megs.services.IItemService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml"})
public class ItemControllerTest {
    @Autowired
    WebApplicationContext wac;
    @Mock
    IItemService itemService;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        MockitoAnnotations.initMocks(this);


    }

    @Test
    public void testShouldRetrieveItems() {
        try {
            ResultActions resultActions = this.mockMvc.perform(get("/items"));
            boolean containsName = resultActions.andReturn().getResponse().getContentAsString().contains("\"name\":\"Item3\"");
            boolean containsId = resultActions.andReturn().getResponse().getContentAsString().contains("\"id\":1");
            assertTrue(containsName);
            assertTrue(containsId);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

   @Test
    public void testShouldSaveItemAndReturnTrue() throws Exception {
       Item item = new Item("Item2", "quality1", new BigDecimal(555.34));
       ObjectMapper objectMapper = new ObjectMapper();
       String s = objectMapper.writeValueAsString(item);
       this.mockMvc.perform(post("/items").contentType(MediaType.APPLICATION_JSON).content(s)).andExpect(status().isOk()).andReturn();
   }


}
