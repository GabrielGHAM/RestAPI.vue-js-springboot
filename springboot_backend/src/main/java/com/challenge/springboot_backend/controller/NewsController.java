package com.challenge.springboot_backend.controller;

import com.challenge.springboot_backend.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.challenge.springboot_backend.repository.NewsRepository;


import jakarta.validation.Valid;

import java.util.List;


@RestController
@RequestMapping("/api")
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;
    

    @GetMapping("/news")
    public List<News> getNews() {
        return newsRepository.findAll() ;
    }

    @GetMapping("/news/{id}")
    public ResponseEntity<News> getNewsById(@PathVariable Long id) throws NotFoundException {
        News news = newsRepository.findById(id).orElseThrow(NotFoundException::new);
        return new ResponseEntity<>(news, HttpStatus.OK);
    }
    
    @PostMapping("/news")
    @Valid
    public News addNews(@RequestBody News news) {
        return newsRepository.save(news);
    }

    @PutMapping("/news/{id}")
    public News updateNews(@PathVariable Long id, @RequestBody News news) throws NotFoundException {
        return newsRepository.findById(id)
            .map(existingNews -> {
                existingNews.setTitle(news.getTitle());
                existingNews.setContent(news.getContent());
                existingNews.setAuthor(news.getAuthor());
                existingNews.setDate(news.getDate());
                return newsRepository.save(existingNews);
            })
            .orElseThrow(() -> new NotFoundException());
    }

    @DeleteMapping("/news/{id}")
    public void deleteNews(@PathVariable Long id) {
        newsRepository.deleteById(id);
    }
}
