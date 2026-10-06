package com.example.MyFirstTestAppSpringBoot.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class HelloController {

    private ArrayList<String> list;
    private HashMap<Integer, String> map;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam("s") String s) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(s);
        return "Добавлено в ArrayList: " + s;
    }

    @GetMapping("/show-array")
    public String showArrayList() {
        if (list == null || list.isEmpty()) {
            return "ArrayList пуст";
        }
        return list.toString();
    }

    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam("s") String s) {
        if (map == null) {
            map = new HashMap<>();
        }
        int key = map.size();
        map.put(key, s);
        return "Добавлено в HashMap: " + key + " = " + s;
    }

    @GetMapping("/show-map")
    public String showHashMap() {
        if (map == null || map.isEmpty()) {
            return "HashMap пуст";
        }
        return map.toString();
    }

    @GetMapping("/show-all-lenght")
    public String showAllLenght() {
        int listSize = (list == null) ? 0 : list.size();
        int mapSize = (map == null) ? 0 : map.size();
        return "Элементов в ArrayList: " + listSize + ", в HashMap: " + mapSize;
    }
}
