package com.example.forcejoin.Repo;

import com.example.forcejoin.Entity.CustomOutputEntity;
import com.example.forcejoin.Entity.FinalExamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface FinalExamRepo extends JpaRepository<FinalExamEntity, Integer> {

    @Query("select new com.example.forcejoin.Entity.CustomOutputEntity(f.candidateName,f.candidatesurname, count(f.slno)) from FinalExamEntity f group by f.candidateName,f.candidatesurname")
    List<CustomOutputEntity> getByJoin();


    @Query("select new map(f.candidatesurname, count(f.slno)) from FinalExamEntity as f group by f.candidatesurname")
    List<Map> getByJoin2();

    @Query("select new map(f.candidatesurname, count(f.slno)) from FinalExamEntity as f group by f.candidatesurname")
    List<?> getByJoin3();

}
