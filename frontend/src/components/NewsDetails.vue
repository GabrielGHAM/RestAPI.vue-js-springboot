<template>
  <div class="news-details">
    <h1>{{ news.title }}</h1>
    <p>{{ news.content }}</p>
    <p>Autor: {{ news.author }}</p>
    <p>Data de Publicação: {{ news.date }}</p>
    <div class="button-group">
      <button @click="editNews">Editar</button>
      <button @click="deleteNews">Deletar</button>
    </div>
    <router-link to="/" class="back-button">Voltar</router-link>
  </div>
</template>

<script>
import NewsService from '../services/NewsService';

export default {
  data() {
    return {
      news: {},
    };
  },
  mounted() {
    this.fetchNews();
  },
  methods: {
    fetchNews() {
      const newsId = this.$route.params.id;
      NewsService.getNewsById(newsId)
        .then((news) => {
          this.news = news;
        })
        .catch((error) => {
          console.error(error);
        });
    },
    editNews() {
      this.$router.push('/edit-news/' + this.news.id);
    },
    deleteNews() {
      NewsService.deleteNews(this.news.id)
        .then(() => {
          // Redirecionar para a lista de notícias após a exclusão
          this.$router.push('/');
        })
        .catch((error) => {
          console.error(error);
        });
    },
  },
};
</script>

<style scoped>
.news-details {
  text-align: center;
}

.button-group {
  margin-top: 20px;
}

.back-button {
  display: inline-block;
  padding: 10px 20px;
  background-color: #f44336;
  color: white;
  text-decoration: none;
  border-radius: 4px;
  margin-top: 20px;
}

.back-button:hover {
  background-color: #d32f2f;
}
</style>
