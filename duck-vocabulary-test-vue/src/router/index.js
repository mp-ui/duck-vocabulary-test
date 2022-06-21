import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    component: () => import('../views/home/Home.vue'),
    redirect: '/sub-home',
    children: [
      {
        path: '/sub-home',
        component: () => import('../views/home/SubHome.vue'),
        name: 'SubHome',
        children: [
          {
            path: '/sub-home/rank',
            component: () => import('../views/rank/index.vue'),
          },
          {
            path: '/sub-home/test',
            component: () => import('../views/test/index.vue')
          },
          {
            path: '/sub-home/words',
            component: () => import('../views/words/index.vue')
          }
        ],
      }
    ]
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('../views/login/Login.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
