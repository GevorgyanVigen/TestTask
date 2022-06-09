package com.test.task.repository;

import com.test.task.model.Quotes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface QuotesRepository extends JpaRepository<Quotes, Integer> {

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "update quotes set quote=?1 where id=?2")
    void updateQuotes(String quotes,  int id);


    @Query(nativeQuery = true, value = "select * from quotes order by quotes.likes desc limit 10")
    List<Quotes> findAllByLikes();
}
