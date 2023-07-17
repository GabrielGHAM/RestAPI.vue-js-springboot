package com.challenge.springboot_backend.repository;
import com.challenge.springboot_backend.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository  extends JpaRepository<News, Long>{
    
}
