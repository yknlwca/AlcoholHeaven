import { createRouter, createWebHistory } from 'vue-router'

import HomeView from '../views/HomeView.vue'
import AlcoholView from '@/views/AlcoholView.vue'
import FoodView from '@/views/FoodView.vue'
import FriendView from '@/views/FriendView.vue'
import NoticeView from '@/views/NoticeView.vue'
import Register from '@/views/Register.vue';
import AlcoholList from '@/components/alcohol/AlcoholList.vue'

import FriendList from '@/components/friend/FriendList.vue'
import FriendDetail from '@/components/friend/FriendDetail.vue'
import FriendCreate from '@/components/friend/FriendCreate.vue'

import FoodList from '@/components/food/FoodList.vue';
import FoodDetail from '@/components/food/FoodDetail.vue';
import FoodCreate from '@/components/food/FoodCreate.vue';
import AlcoholDetail from '@/components/alcohol/AlcoholDetail.vue'

import noticeList from '@/components/notice/NoticeList.vue'
import noticeDetail from '@/components/notice/NoticeDetail.vue'
import noticeCreate from '@/components/notice/NoticeCreate.vue'
import FoodUpdate from '@/components/food/FoodUpdate.vue'
import FriendUpdate from '@/components/friend/FriendUpdate.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/register',
      name: 'register',
      component: Register
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
        },
      ]
    },
    {
      path: '/alcohol/:name/:id',
      name: 'alcohol-detail',
      component: AlcoholDetail
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
        {
          path: 'update/:id',
          name: 'foodUpdate',
          component: FoodUpdate
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
        },
        {
          path: 'update/:id',
          name: 'friendUpdate',
          component: FriendUpdate
        }
      ]
    },
    {
      path: '/notice',
      name: 'notice',
      component: NoticeView,
      children: [
        {
          path: '',
          name: 'noticeList',
          component: noticeList
        },
        {
          path: 'create',
          name: 'noticeCreate',
          component: noticeCreate
        },
        {
          path: ':id',
          name: 'noticeDetail',
          component: noticeDetail
        }
      ]
    },
  ]
})



router.beforeEach((to, from, next) => {
  if (to.matched.some(record => record.meta.requiresAuth)) {
    const signIn = sessionStorage.getItem('signIn') === 'true';
    if (!signIn) {
      next({ name: 'Home' });
    } else {
      next();
    }
  } else {
    next();
  }
});



export default router
