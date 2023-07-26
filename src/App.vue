<template>
  <div>
  <Navbar/></div>
  <div>
    <Quote :quote=quoteText :author= quoteAuthor />
  </div>
<Background/>
</template>

<script>
import Background from './components/Background.vue';
import Navbar from './components/Navbar.vue';
import Quote from './components/Quote.vue';


export default {
  name: 'App',
  components: {
    Navbar, Quote,Background
},
data() {
    return {
      quoteText: "Become a better programmer",
      quoteAuthor: "Improve your skills now !",
    };
  },
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
