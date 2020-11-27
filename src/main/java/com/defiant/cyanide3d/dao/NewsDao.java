package com.defiant.cyanide3d.dao;

import com.defiant.cyanide3d.models.News;

import java.util.List;

public interface NewsDao {
    List<News> index();
    News show(int id);
    void save(News news);
    void update(int id, News updatedNews);
    void delete(int id);
}
