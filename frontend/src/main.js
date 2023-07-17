import { createApp } from 'vue';
import App from './App.vue';
import { createRouter, createWebHistory } from 'vue-router';

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      name: 'NewsList',
      component: () => import('./components/NewsList.vue'),
    },
    {
      path: '/news/:id',
      name: 'NewsDetail',
      component: () => import('./components/NewsDetails.vue'),
    },
    {
      path: '/add-news',
      name: 'AddNews',
      component: () => import('./components/AddNews.vue'),
    },
    {
      path: '/edit-news/:id',
      name: 'EditNews',
      component: () => import('./components/EditNews.vue'),
    },
  ],
});

createApp(App).use(router).mount('#app');
