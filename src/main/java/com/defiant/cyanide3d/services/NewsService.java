package com.defiant.cyanide3d.services;

import com.defiant.cyanide3d.dao.NewsDao;
import com.defiant.cyanide3d.models.News;
import com.defiant.cyanide3d.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
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
        return new News(news.getId(),news.getName(),news.getBody().replace("<br>","\n"),news.getDescription(), news.getDate(),news.getAuthor());
    }

    public void save(News news, String author) {
        newsDao.save(new News(news.getId(), news.getName(), news.getBody(), news.getDescription(), new SimpleDateFormat("dd:MM:yyyy").format(new Date()),author));
    }

    public void update(int id, News updatedNews) {
        News newsToBeUpdated = show(id);
        if (updatedNews == null) return;
        newsToBeUpdated.setName(updatedNews.getName());
        newsToBeUpdated.setBody(updatedNews.getBody().replace("\n","<br>"));
        newsToBeUpdated.setDescription(updatedNews.getDescription());
        newsDao.update(id, newsToBeUpdated);
    }

    public void delete(int id) {
        newsDao.delete(id);
    }
}
