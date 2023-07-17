import { createRouter, createWebHistory } from 'vue-router';

const routes = [
  {
    path: '/',
    name: 'NewsList',
    component: () => import('@/components/NewsList.vue'),
  },
  {
    path: '/news/:id',
    name: 'NewsDetail',
    component: () => import('@/components/NewsDetails.vue'),
  },
  {
    path: '/add-news',
    name: 'AddNews',
    component: () => import('@/components/AddNews.vue'),
  },
  {
    path: '/edit-news/:id',
    name: 'EditNews',
    component: () => import('@/components/EditNews.vue'),
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
