package com.jimmy.tutorialangular;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Angular {

//    @RequestMapping(value = "/angular", method = RequestMethod.GET)
//    @ResponseBody
//    public String angular() {
//        return "test";
//    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/")
    public String index() {
        ObjectMapper mapper = new ObjectMapper();
        TestObject obj = new TestObject();
        obj.setName("James");
        obj.setValue("djfklasjdlkfjsa");
        obj.setUniqueId(34);

        TestObject obj2 = new TestObject();
        obj2.setName("Homer");
        obj2.setValue("Simplson");
        obj2.setUniqueId(365);

        TestObject obj3 = new TestObject();
        obj3.setName("Kevin");
        obj3.setValue("Gaarnett");
        obj3.setUniqueId(3);

        List<TestObject> list = new ArrayList<TestObject>();
        list.add(obj);
        list.add(obj2);
        list.add(obj3);

        try {
            return mapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    class TestObject {
        String name;
        String value;
        int uniqueId;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getUniqueId() {
            return uniqueId;
        }

        public void setUniqueId(int uniqueId) {
            this.uniqueId = uniqueId;
        }
    }
}
