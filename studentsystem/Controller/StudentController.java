package com.example.studentsystem.Controller;

import com.example.studentsystem.Medol.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController

@RequestMapping("/api/v1/student")
public class StudentController {


    ArrayList<Student> students = new ArrayList<>();


    @PutMapping("/add")
    public String addStudents(@RequestBody Student student) {
        students.add(student);
        return "Student added";
    }

    @GetMapping("/getName/{index}")
    public String getName(@PathVariable int index){
        return  students.get(index).getName();

    }
    @GetMapping("/getAge/{index}")
    public int getAge(@PathVariable int index){
        return students.get(index).getAge();


    }

    @GetMapping("/getCollege/{index}")
    public String getCollege(@PathVariable int index){
        return students.get(index).getDegree();
    }

    @GetMapping("/getStatusStudents/{index}")
    public boolean getStatusStudents(@PathVariable int index) {
        if(students.get(index).getStatus().equals("graduated")){
            return true;
        }


            return false;

    }
    @GetMapping("/get")
    public ArrayList<Student> getStudents() {
        return students;
    }
}

