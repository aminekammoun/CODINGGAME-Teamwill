/*!

 =========================================================
 * Vue Paper Dashboard - v1.0.1
 =========================================================

 * Product Page: http://www.creative-tim.com/product/paper-dashboard
 * Copyright 2023 Creative Tim (http://www.creative-tim.com)
 * Licensed under MIT (https://github.com/creativetimofficial/paper-dashboard/blob/master/LICENSE.md)

 =========================================================

 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

 */
import Vue from "vue";
import App from "./App";
import router from "./router/index";
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'
import PaperDashboard from "./plugins/paperDashboard";
import "vue-notifyjs/themes/default.css";
// Import Bootstrap and BootstrapVue CSS files (order is important)
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import store from './store';
// Make BootstrapVue available throughout your project
Vue.use(BootstrapVue)
Vue.use(PaperDashboard);

/* eslint-disable no-new */
new Vue({
  router,
  store, 
  render: (h) => h(App),
}).$mount("#app");
