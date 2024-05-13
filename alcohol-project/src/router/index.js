import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import AlcoholView from '@/views/AlcoholView.vue'
import FoodView from '@/views/FoodView.vue'
import FriendView from '@/views/FriendView.vue'
import NoticeView from '@/views/NoticeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/alcohol',
      name: 'alcohol',
      component: AlcoholView,
    },
    {
      path: '/food',
      name: 'food',
      component: FoodView,
    },
    {
      path: '/friend',
      name: 'friend',
      component: FriendView,
    },
    {
      path: '/notice',
      name: 'notice',
      component: NoticeView,
    },
  ]
})

export default router
