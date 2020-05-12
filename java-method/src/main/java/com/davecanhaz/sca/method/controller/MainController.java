package com.davecanhaz.sca.method.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonParser;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    // CVE-2018-11307
    // CVE-2018-7489
    // https://medium.com/@cowtowncoder/on-jackson-cves-dont-panic-here-is-what-you-need-to-know-54cd0d6e8062
    // https://github.com/rcseacord/JavaSCR/blob/master/JavaSCR/src/main/java/jackson/TemplatesUtil.java
    // https://github.com/mbechler/marshalsec
    // file:///C:/Users/dave/Downloads/Jackson_Deserialization.pdf
    // https://owasp.org/www-pdf-archive/Marshaller_Deserialization_Attacks.pdf.pdf
    // https://github.com/no-sec-marko/java-web-vulnerabilities

    // CVE-2016-1000027

    // CVE-2020-5398

    @RequestMapping(path = "/")
    private ModelAndView index(final HttpServletRequest request, final HttpServletResponse response, @RequestParam(required = false) final String inJson) {
        System.out.println("Hello");

        final Map<String, String> model = new HashMap<>();
        model.put("hello", "world");
        

        return new ModelAndView("hi", model);

    }


    @RequestMapping(path = "/convert")
    @ResponseBody
    private String convert(final HttpServletRequest request, HttpServletResponse response, @RequestParam(required = false) final String inJson) {
        
        // Sample Request: curl -sS "localhost:8080/convert" --data-urlencode "inJson={\"name\":\"Steve\",\"age\":28,\"phone\":{\"@class\":\"com.davecanhaz.sca.method.types.DomesticNumber\",\"areaCode\":555,\"local\":1234567}}"

        try {

            // inJson = "{ \"name\" : \"Bob\", \"age\" : 28, \"phone\" : { \"areaCode\" : 555, \"local\" : 1234567 } }";

            // ObjectMapper mapper = new ObjectMapper();
            // Person person = mapper.readValue(inJson, Person.class);  
            System.out.println(inJson);
            Object person = unmarshal(inJson);

            System.out.println(person);
            return "Success! - " + person.toString();
        } catch(final Exception ex) {
            ex.printStackTrace();
            response.setStatus( HttpServletResponse.SC_BAD_REQUEST);
            return "Failure!";
        }

    }

    private Object unmarshal(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

        return mapper.readValue(json, Object.class);
    }
}