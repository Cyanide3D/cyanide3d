package com.defiant.cyanide3d.dao;

import com.defiant.cyanide3d.models.News;
import com.defiant.cyanide3d.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class NewsDaoImpl implements NewsDao{

    @Autowired
    NewsRepository newsRepository;


    public List<News> index(){
        List<News> result = new ArrayList<>();
        newsRepository.findAll().forEach(result::add);
        return result;
    }

    public News show(int id){
        return newsRepository.findById(id).orElse(null);
    }

    public void save(News news) {
        newsRepository.save(news);
    }

    @Transactional
    public void update(int id, News updatedNews) {
        newsRepository.updateNewsById(id, updatedNews.getName(), updatedNews.getBody(), updatedNews.getDescription(), updatedNews.getDate());
    }

    public void delete(int id) {
        newsRepository.deleteById(id);
    }
}