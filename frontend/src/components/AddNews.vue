<template>
  <div class="add-news">
    <h1>Adicionar Notícia</h1>
    <form @submit.prevent="addNews" class="news-form">
      <div class="form-group">
        <label for="title">Título:</label>
        <input type="text" id="title" v-model="newNews.title" required />
        <p v-if="errors.title" class="error-message">{{ errors.title }}</p>
      </div>
      <div class="form-group">
        <label for="content">Conteúdo:</label>
        <textarea id="content" v-model="newNews.content" required></textarea>
        <p v-if="errors.content" class="error-message">{{ errors.content }}</p>
      </div>
      <div class="form-group">
        <label for="author">Autor:</label>
        <input type="text" id="author" v-model="newNews.author" required />
        <p v-if="errors.author" class="error-message">{{ errors.author }}</p>
      </div>
      <div class="form-group">
        <label for="date">Data de Publicação:</label>
        <input type="date" id="date" v-model="newNews.date" required />
        <p v-if="errors.date" class="error-message">{{ errors.date }}</p>
      </div>
      <div class="button-group">
        <button type="submit">Adicionar</button>
        <router-link to="/" class="back-button">Voltar</router-link>
      </div>
    </form>
  </div>
</template>

<script>
import NewsService from '../services/NewsService';

export default {
  data() {
    return {
      newNews: {
        title: '',
        content: '',
        author: '',
        date: '',
      },
      errors: {},
    };
  },
  methods: {
    addNews() {
      this.errors = {};

      if (!this.validateForm()) {
        return;
      }

      NewsService.createNews(this.newNews)
        .then(() => {
          this.$router.push('/');
        })
        .catch((error) => {
          console.error(error);
        });
    },
    validateForm() {
      let isValid = true;

      if (this.newNews.title.length < 5) {
        this.errors.title = 'O título deve ter pelo menos 5 caracteres.';
        isValid = false;
      }

      // Outras validações...

      return isValid;
    },
  },
};
</script>

<style scoped>
.add-news {
  text-align: center;
}

.news-form {
  max-width: 500px;
  margin: 0 auto;
}

.form-group {
  margin-bottom: 20px;
}

.error-message {
  color: red;
  margin-top: 5px;
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
