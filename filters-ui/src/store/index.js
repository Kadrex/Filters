import Vue from 'vue'
import Vuex from 'vuex'
import filters from "./modules/Filters";


Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    filters
  },
  state: {},
  mutations: {},
  actions: {}
})
