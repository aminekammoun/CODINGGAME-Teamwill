<template>
    <nav class="navbar">
        <div class="logo-container">
      <img src="src\assets\img\teamwilllogo2.png" alt="Logo Teamwill">
    </div>
    <ul class="nav-links">
      <li @click="navigateTo('developer')">CANDIDAT</li>
      <li @click="navigateTo('admin')">ADMIN</li>
      <li class="button-container">
      <button class="sign-in-button" @click="signIn">SE CONNECTER</button></li>
      <li class="button-container">
      <button class="sign-up-button" @click="signUp">S'INSCRIRE</button></li>
    </ul>
  </nav>
    
</template>

<script>
export default {
  methods: {
    navigateTo(route) {
      // Use Vue Router to navigate to the appropriate route
      // For example, you can use this.$router.push('/' + route);
      // Make sure you have set up Vue Router in your main.js file
    },
    signIn() {
        // Implement your sign-in logic here
        // For example, show a modal or navigate to the sign-in page
      },
      signUp() {
        // Implement your sign-up logic here
        // For example, show a modal or navigate to the sign-up page
      },
  },
};
</script>

<style scoped>
.navbar {
  background-color: #242424;
  padding: 10px;
  display: flex;
  align-items: center;
  justify-content: space-between; /* Positions logo and buttons at the ends */
}

.logo-container img {
  max-width: 100px;
  max-height: 100px;
}

.nav-links {
  list-style: none;
  display: flex;
  align-items: center; 
}

.nav-links li {
  margin: 0 10px;
  cursor: pointer;
  font-size: 18px; /* Increase font size */
  color: #fff; /* Change text color */
  position: relative; /* Required for the underline animation */
}

.nav-links li::after {
  content: "";
  position: absolute;
  width: 100%;
  height: 2px;
  bottom: -5px; /* Adjust the underline position */
  left: 0;
  background-color: transparent;
  transform: scaleX(0); /* Initial underline width (hidden) */
  transition: transform 0.3s; /* Add animation to underline on hover */
}

.nav-links li:hover::after {
  transform: scaleX(1); /* Show the underline on hover */
  background-color: #2d7353; /* Underline color on hover */
}

.button-container {
  display: flex;
}

.sign-in-button {
  padding: 10px 20px;
  border: none;
  margin-left: 10px;
  cursor: pointer;
  font-size: 18px; /* Increase font size */
  color: #fff; /* Change text color */
  background-color: #7cdc54; /* Change button background color */
  transition: background-color 0.3s; /* Add transition for smooth color change on hover */
}

.sign-up-button {
  padding: 10px 20px;
  border: none;
  margin-left: 10px;
  cursor: pointer;
  font-size: 18px; /* Increase font size */
  color: #fff; /* Change text color */
  background-color: #4f6740;
  transition: background-color 0.3s; /* Add transition for smooth color change on hover */
}

.sign-in-button:hover {
  background-color: #41b87e;
}

.sign-up-button:hover {
  background-color: #41b87e;
}
</style>