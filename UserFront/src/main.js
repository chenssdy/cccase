import { createApp } from 'vue'
import App from './App.vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import Cookie from 'js-cookie'
import router from '@/router/router'
import 'element-plus/theme-chalk/dark/css-vars.css'

const app = createApp(App);
// app.use(store);
app.use(Cookie);
app.use(ElementPlus);
app.use(router);
app.mount('#app');
