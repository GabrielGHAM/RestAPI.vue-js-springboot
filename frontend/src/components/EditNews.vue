<template>
  <div class="edit-news">
    <h1>Editar Notícia</h1>
    <form @submit.prevent="updateNews" class="news-form">
      <div class="form-group">
        <label for="title">Título:</label>
        <input type="text" id="title" v-model="editedNews.title" required />
        <p v-if="errors.title" class="error-message">{{ errors.title }}</p>
      </div>
      <div class="form-group">
        <label for="content">Conteúdo:</label>
        <textarea id="content" v-model="editedNews.content" required></textarea>
        <p v-if="errors.content" class="error-message">{{ errors.content }}</p>
      </div>
      <div class="form-group">
        <label for="author">Autor:</label>
        <input type="text" id="author" v-model="editedNews.author" required />
        <p v-if="errors.author" class="error-message">{{ errors.author }}</p>
      </div>
      <div class="form-group">
        <label for="date">Data de Publicação:</label>
        <input type="date" id="date" v-model="editedNews.date" required />
        <p v-if="errors.date" class="error-message">{{ errors.date }}</p>
      </div>
      <div class="button-group">
        <button type="submit">Salvar</button>
      </div>
    </form>
  </div>
</template>

<script>
import NewsService from '../services/NewsService';

export default {
  data() {
    return {
      editedNews: {
        title: '',
        content: '',
        author: '',
        date: '',
      },
      errors: {},
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
          this.editedNews = news;
        })
        .catch((error) => {
          console.error(error);
        });
    },
    updateNews() {
      this.errors = {};

      if (!this.validateForm()) {
        return;
      }

      NewsService.updateNews(this.editedNews)
        .then(() => {
          this.$router.push('/news/' + this.editedNews.id);
        })
        .catch((error) => {
          console.error(error);
        });
    },
    validateForm() {
      let isValid = true;

      if (this.editedNews.title.length < 5) {
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
.edit-news {
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

.button-group {
  margin-top: 20px;
}
</style>
