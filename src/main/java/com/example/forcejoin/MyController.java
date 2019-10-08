package com.example.forcejoin;

import com.example.forcejoin.Entity.CustomOutputEntity;
import com.example.forcejoin.Entity.FinalExamEntity;
import com.example.forcejoin.Entity.StudentEntity;
import com.example.forcejoin.Repo.FinalExamRepo;
import com.example.forcejoin.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class MyController {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private FinalExamRepo finalExamRepo;


    @ResponseBody
    @GetMapping("/insert-data")
    public void insertData() {

        StudentEntity studentEntity = new StudentEntity("abc", "xyz", 22);
        StudentEntity studentEntity2 = new StudentEntity("ggg", "ddd", 25);
        StudentEntity studentEntity3 = new StudentEntity("hhhh", "yyy", 12);
        StudentEntity studentEntity4 = new StudentEntity("tttt", "www", 29);

        studentRepo.save(studentEntity);
        studentRepo.save(studentEntity2);
        studentRepo.save(studentEntity3);
        studentRepo.save(studentEntity4);

        FinalExamEntity finalExamEntity = new FinalExamEntity("abc", "xyz", 56);
        FinalExamEntity finalExamEntity2 = new FinalExamEntity("ggg", "ddd", 58);
        FinalExamEntity finalExamEntity3 = new FinalExamEntity("hhhh", "yyy", 66);
        FinalExamEntity finalExamEntity4 = new FinalExamEntity("tttt", "www", 65);
        FinalExamEntity finalExamEntity5 = new FinalExamEntity("tttt", "www", 65);

        finalExamRepo.save(finalExamEntity);
        finalExamRepo.save(finalExamEntity2);
        finalExamRepo.save(finalExamEntity3);
        finalExamRepo.save(finalExamEntity4);
        finalExamRepo.save(finalExamEntity5);
    }


    @ResponseBody
    @GetMapping("/get-data")
    public void getData() {

//        List<StudentEntity> studentEntities = studentRepo.getByJoin();
//
//        for (StudentEntity s : studentEntities) {
//            System.out.println(s.getName() + " " + s.getSurname() + " " + s.getAge());
//        }
    }

    @ResponseBody
    @GetMapping("/get-count")
    public void getCount() {

        System.out.println("count " + studentRepo.getCount().getCount());
    }


    @ResponseBody
    @GetMapping("/get-custom")
    public void getCustom() {

        List<CustomOutputEntity> customOutputEntities = finalExamRepo.getByJoin();

        for (CustomOutputEntity c : customOutputEntities) {
            System.out.println(c.getName() + " " + c.getSurname() + " " + c.getCount());
        }
    }

    @ResponseBody
    @GetMapping("/get-custom-2")
    public void getCustom2() {

        List<Map> objects = finalExamRepo.getByJoin2();

        for (Map m : objects) {

            System.out.println(m.get("0") + " " + m.get("1"));

        }


//        objects.forEach(object -> {
//            System.out.println(object[0] + " " + object[1]);
//        });
    }
}
