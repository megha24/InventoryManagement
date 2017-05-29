package com.megs.controllers;

import com.megs.models.Item;
import com.megs.services.IItemService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

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
    public void test_should_return_true() {
        ArrayList<Item> items = new ArrayList<Item>();
        Item item = new Item("item1", "quality1", new BigDecimal(23.56));
        items.add(item);
        when(itemService.GetItems()).thenReturn(items);
        try {
            ResultActions resultActions = this.mockMvc.perform(get("/items"));
//            resultActions.andExpect(jsonPath("$[0].id", is(1)));
            boolean containsName = resultActions.andReturn().getResponse().getContentAsString().contains("\"name\":\"Item3\"");
            boolean containsId = resultActions.andReturn().getResponse().getContentAsString().contains("\"id\":1");
            assertTrue(containsName);
            assertTrue(containsId);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }


}
