import { createRouter, createWebHistory } from 'vue-router';
import MyMain from '../pages/main.vue'
import MyHome from '../pages/MyHome.vue'
import Ruolette from '../pages/Ruolette.vue'
import IntegralExchange from '../pages/IntegralExchange.vue'
import Roll from '../pages/Roll.vue'

const routes = [
    {
        path: '/',
        component: MyMain,
        name: '/',
        children: [
            { path: '/home', component: MyHome, name: 'myhome' },
            { path: '/ruolette', component: Ruolette, name: 'ruolette' },
            { path: '/exchange', component: IntegralExchange, name: 'exchange' },
            { path: '/roll', component: Roll, name: 'roll' },
        ]
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})

export default router;