package com.challenge.springboot_backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;





@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Notícias")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título é obrigatório")
    @Column(columnDefinition = "CLOB")
    @Size(max = Integer.MAX_VALUE, message = "O título deve ter no máximo 255 caracteres")
    private String title;

    @NotBlank(message = "O conteúdo é obrigatório")
    @Column(columnDefinition = "CLOB")
    @Size(max = Integer.MAX_VALUE, message = "O conteúdo deve ter no máximo 2.147.483.647 caracteres")
    private String content;

    @NotBlank(message = "O autor é obrigatório")
    @Column(columnDefinition = "CLOB")
    @Size(max = Integer.MAX_VALUE, message = "O autor deve ter no máximo 255 caracteres")
    private String author;

    @NotBlank(message = "A data é obrigatória")
    @Column(columnDefinition = "CLOB")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "A data deve estar no formato yyyy-MM-dd")
    private String date;

    // Construtores, getters e setters

    public News() {
    }

    public News(String title, String content, String author, String date) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
