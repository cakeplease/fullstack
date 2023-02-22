import { createRouter, createWebHistory } from 'vue-router';
import Calculator from "@/components/Calculator.vue";
import Form from "@/components/Form.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: Calculator
    },
    /*{
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../components/Calculator.vue')
    },*/
    {
      path: '/form',
      name: 'form',
      component: Form
    }
  ]
})

export default router
