import Vue from 'vue';
import App from './App.vue';
import store from './store/index';
import vuetify from './plugins/vuetify';
import '@babel/polyfill';
import '@fortawesome/fontawesome-free/css/all.css';
import axios from 'axios';
import VueAxios from 'vue-axios';

Vue.use(VueAxios, axios)
Vue.config.productionTip = false

new Vue({
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
