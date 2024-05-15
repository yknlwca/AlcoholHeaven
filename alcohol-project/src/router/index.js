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
