package com.example.studentservice.controller;

import com.example.studentservice.models.Student;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class StudentServiceController {

    private static List<Student> studentList = new ArrayList<>(Arrays.asList(
            new Student("uzile", 2022),
            new Student("JB", 2022),
            new Student("Criste", 2023),
            new Student("Dan", 2000)
    ));

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public List<Student> getStudentList() {
        return studentList;
    }
    @RequestMapping(value = "/students/{index}", method = RequestMethod.GET)
    public Student lookupStudentByIndex(@PathVariable int index) {
        return studentList.get(index);
    }
    @RequestMapping(value = "/student/{name}", method = RequestMethod.GET)
    public Student lookupStudentByName(@PathVariable String name) {
//        for(int i = 0; i < studentList.size(); i++) {
//            if(studentList.get(i).getName().equals(name)) {
//                return studentList.get(i);
//            }
//        }
        return studentList.stream().filter( student -> student.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
        //return new Student("Student not found", 0);
        //return null;
    }

}
