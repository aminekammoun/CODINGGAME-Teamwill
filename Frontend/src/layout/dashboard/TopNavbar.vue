<template>
  <nav class="navbar navbar-expand-lg navbar-light">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">{{ routeName }}</a>
      <button
        class="navbar-toggler navbar-burger"
        type="button"
        @click="toggleSidebar"
        :aria-expanded="$sidebar.showSidebar"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-bar"></span>
        <span class="navbar-toggler-bar"></span>
        <span class="navbar-toggler-bar"></span>
      </button>
     <div class="collapse navbar-collapse">
        <ul class="navbar-nav ml-auto">
         <!-- <li class="nav-item">
            <a href="#" class="nav-link">
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
            <a class="dropdown-item" href="#">Notification 1</a>
            <a class="dropdown-item" href="#">Notification 2</a>
            <a class="dropdown-item" href="#">Notification 3</a>
            <a class="dropdown-item" href="#">Notification 4</a>
            <a class="dropdown-item" href="#">Another notification</a>
          </drop-down>--> 
          <li class="nav-item">
            <b-button @click="logout"> <i class="fa fa-sign-out"></i>
              <p>logout</p></b-button>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</template>
<script>
import axios from 'axios';
import router from "@/router"; // Adjust the path according to your project structure

export default {
  computed: {
    routeName() {
      const { name } = this.$route;
      return this.capitalizeFirstLetter(name);
    },
  },
  data() {
    return {
      activeNotifications: false,
    };
  },
  methods: {
    async logout() {
      try {
        await axios.post('http://localhost:8084/api/v1/auth/logout');
        // You can perform any additional logout-related tasks here,
        // such as clearing local storage, updating UI, etc.
        console.log('Logged out successfully');
        localStorage.clear();
        this.$router.push('/users');
        this.handleOk()



      } catch (error) {
        console.error('Error logging out:', error);
      }
    },
  
    handleOk(){
  

    },
    capitalizeFirstLetter(string) {
      return string.charAt(0).toUpperCase() + string.slice(1);
    },
    toggleNotificationDropDown() {
      this.activeNotifications = !this.activeNotifications;
    },
    closeDropDown() {
      this.activeNotifications = false;
    },
    toggleSidebar() {
      this.$sidebar.displaySidebar(!this.$sidebar.showSidebar);
    },
    hideSidebar() {
      this.$sidebar.displaySidebar(false);
    },
  },
};
</script>
<style></style>
