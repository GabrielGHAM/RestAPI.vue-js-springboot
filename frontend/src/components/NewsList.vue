<template>
  <div class="news-list">
    <h1>Notícias</h1>
    <ul class="list-group">
      <li v-for="news in newsList" :key="news.id" class="list-group-item">
        <router-link :to="'/news/' + news.id" class="news-link">{{ news.title }}</router-link>
        <p class="news-date">{{ formatDate(news.date) }}</p>
      </li>
    </ul>
    <router-link to="/add-news" class="btn btn-primary">Adicionar Notícia</router-link>
  </div>
</template>

<script>
import NewsService from '../services/NewsService';

export default {
  data() {
    return {
      newsList: [],
    };
  },
  mounted() {
    this.fetchNews();
  },
  methods: {
    fetchNews() {
      NewsService.getNews()
        .then((news) => {
          this.newsList = news;
        })
        .catch((error) => {
          console.error(error);
        });
    },
    formatDate(date) {
      const formattedDate = new Date(date).toLocaleDateString();
      return formattedDate;
    },
  },
};
</script>

<style scoped>
.news-list {
  text-align: center;
}

.news-item {
  margin-bottom: 10px;
}

.news-date {
  color: #888;
}

.add-news-button {
  display: inline-block;
  padding: 10px 20px;
  background-color: #4CAF50;
  color: white;
  text-decoration: none;
  border-radius: 4px;
  margin-top: 20px;
}

.add-news-button:hover {
  background-color: #45a049;
}
</style>
