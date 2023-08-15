<template>
  <div class="wrapper">
    <side-bar>
      <template slot="links">
        <sidebar-link to="/users" name="Users details" icon="ti-id-badge" />
        <sidebar-link to="/stats" name="User Profile" icon="ti-user" />
      <!--  <sidebar-link
          to="/table-list"
          name="Table List"
          icon="ti-view-list-alt"
        />
     
        <sidebar-link to="/typography" name="Typography" icon="ti-text" />
    
        <sidebar-link to="/notifications" name="Notifications" icon="ti-bell" />-->
         <sidebar-link to="/icons" name="Icons" icon="ti-pencil-alt2" />
        <sidebar-link to="/candidats" name="Candidatures" icon="ti-user" />
        <sidebar-link to="/begin" name="Begin the test" icon="ti-receipt" />
      </template>
      <mobile-menu>
       <!--   <li class="nav-item">
          <a class="nav-link">
            <i class="ti-panel"></i>
            <p>Stats</p>
          </a>
        </li>
        <drop-down
          class="nav-item"
          title="5 Notifications"
          title-classes="nav-link"
          icon="ti-bell"
        >
          <a class="dropdown-item">Notification 1</a>
          <a class="dropdown-item">Notification 2</a>
          <a class="dropdown-item">Notification 3</a>
          <a class="dropdown-item">Notification 4</a>
          <a class="dropdown-item">Another notification</a>
        </drop-down> -->
        <li class="nav-item">
         <b-button @click="logout()"> <i class="fa fa-sign-out"></i>
              <p>logout</p></b-button>
           
          </li>
        <li class="divider"></li>
      </mobile-menu>
    </side-bar>
    <div class="main-panel">
      <top-navbar></top-navbar>

      <dashboard-content @click.native="toggleSidebar"> </dashboard-content>

      <content-footer></content-footer>
    </div>
  </div>
</template>
<style lang="scss"></style>
<script>
import TopNavbar from "./TopNavbar.vue";
import ContentFooter from "./ContentFooter.vue";
import DashboardContent from "./Content.vue";
import MobileMenu from "./MobileMenu";
import axios from 'axios';
import router from "@/router"; // Adjust the path according to your project structure

export default {
  components: {
    TopNavbar,
    ContentFooter,
    DashboardContent,
    MobileMenu,
  },
  methods: {
    async logout() {
      try {
        await axios.post('http://localhost:8084/api/v1/auth/logout');
        // You can perform any additional logout-related tasks here,
        // such as clearing local storage, updating UI, etc.
        console.log('Logged out successfully');
        localStorage.clear();
         this.handleOk()

      } catch (error) {
        console.error('Error logging out:', error);
      }
    },
 
    handleOk(){
      this.$router.push('/users');

    },
  
     
   
 
    toggleSidebar() {
      if (this.$sidebar.showSidebar) {
        this.$sidebar.displaySidebar(false);
      }
    },
  },
};
</script>
