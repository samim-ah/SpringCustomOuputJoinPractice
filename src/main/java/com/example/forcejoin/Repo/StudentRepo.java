package com.example.forcejoin.Repo;

import com.example.forcejoin.Entity.CountFinalExam;
import com.example.forcejoin.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity, Integer> {

//    @Query("")
//    List<StudentEntity> getByJoin();

    @Query("select new com.example.forcejoin.Entity.CountFinalExam(count(s.name)) from StudentEntity as s")
    CountFinalExam getCount();

}
