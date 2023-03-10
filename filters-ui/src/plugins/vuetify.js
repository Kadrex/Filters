import Vue from 'vue';
import Vuetify from 'vuetify/lib';

Vue.use(Vuetify);

export default new Vuetify({
  theme: {
      options: {
        customProperties: true,
      },
    themes: {
      light: {
        primary: '#195BDD',
        secondary: '#eeeeee',
      },
    },
  },
  icons: {
    iconfont: 'fa',
  },
});
