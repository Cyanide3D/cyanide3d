package com.defiant.cyanide3d.repositories;

import com.defiant.cyanide3d.models.News;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface NewsRepository extends CrudRepository<News, Integer> {
    @Modifying(clearAutomatically = true)
    @Query("UPDATE News n SET n.name = :name, n.body = :body WHERE n.id = :id")
    void updateNewsById(@Param("id") int id, @Param("name") String name, @Param("body") String body);
}
