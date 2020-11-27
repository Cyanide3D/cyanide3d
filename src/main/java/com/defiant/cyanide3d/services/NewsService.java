package com.defiant.cyanide3d.services;

import com.defiant.cyanide3d.dao.NewsDao;
import com.defiant.cyanide3d.models.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    NewsDao newsDao;

    public List<News> index(){
        return newsDao.index();
    }

    public News show(int id){
        return newsDao.show(id);
    }

    public News edit(int id){
        News news = show(id);
        if (news == null) return null;
        return new News(news.getId(),news.getName(),news.getBody().replace("<br>","\n"));
    }

    public void save(News news) {
        newsDao.save(news);
    }

    public void update(int id, News updatedNews) {
        News newsToBeUpdated = show(id);
        if (updatedNews == null) return;
        newsToBeUpdated.setName(updatedNews.getName());
        newsToBeUpdated.setBody(updatedNews.getBody().replace("\n","<br>"));
        newsDao.update(id, newsToBeUpdated);
    }

    public void delete(int id) {
        newsDao.delete(id);
    }
}
