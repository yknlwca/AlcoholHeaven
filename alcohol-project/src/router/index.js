import { createRouter, createWebHistory } from 'vue-router'

import HomeView from '../views/HomeView.vue'
import AlcoholView from '@/views/AlcoholView.vue'
import FoodView from '@/views/FoodView.vue'
import FriendView from '@/views/FriendView.vue'
import NoticeView from '@/views/NoticeView.vue'
import AlcoholList from '@/components/alcohol/AlcoholList.vue'

import FriendList from '@/components/friend/FriendList.vue'
import FriendDetail from '@/components/friend/FriendDetail.vue'
import FriendCreate from '@/components/friend/FriendCreate.vue'

import FoodList from '@/components/food/FoodList.vue';
import FoodDetail from '@/components/food/FoodDetail.vue';
import FoodCreate from '@/components/food/FoodCreate.vue';

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
      children: [
        {
          path: ':name',
          name: 'alcohol-list',
          component: AlcoholList,
        }
      ]
    },
    {
      path: '/food',
      name: 'food',
      component: FoodView,
      children: [
        {
          path: '',
          name: 'foodList',
          component: FoodList
        },
        {
          path: 'create',
          name: 'foodCreate',
          component: FoodCreate
        },
        {
          path: ':id',
          name: 'foodDetail',
          component: FoodDetail
        },
      ]
    },
    {
      path: '/friend',
      name: 'friend',
      component: FriendView,
      children: [
        {
          path: '',
          name: 'friendList',
          component: FriendList
        },
        {
          path: 'create',
          name: 'friendCreate',
          component: FriendCreate
        },
        {
          path: ':id',
          name: 'friendDetail',
          component: FriendDetail
        }
      ]
    },
    {
      path: '/notice',
      name: 'notice',
      component: NoticeView,
    },
  ]
})

export default router
