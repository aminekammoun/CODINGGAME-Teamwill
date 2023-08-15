<template>              

    <div class="app">
       
     <p>Hello when you are ready you can begin the test just press the button "begin the test" you have to know that when you begin the test you can't go back 
        and e...  </p>
        <b-button @click=updateUser style="  position: absolute;
  right: 50%;">Begin the Test</b-button>
    
     <br/>
    </div>

</template>
<script>
import { mapGetters } from 'vuex';
import axios from 'axios';
export default {
  computed: {
    ...mapGetters(['getUserEmail']), 
    userEmail() {
      return this.getUserEmail; // Access the user's email from the store
    },
  
  },
  data:{
    return(){
      userData: null 
    }
  },
  beforeMount() {
    this.getUserByEmail();
  },
  methods: {
    redirectToTest() {
      
      this.$router.push('/test');
    

    },
    getUserByEmail() {
      const email = 'amineSSDDDS.kammoun@gmail.com';
      const url = `http://localhost:8084/email/${email}`;

      axios
        .get(url)
        .then(response => {
          this.userData = response.data; 
          console.log('User data by email:', response.data);
          // Handle received user data
        })
        .catch(error => {
          console.error('Error fetching user data:', error);
          // Handle error or feedback here
        });
    },
   
    updateUser() {

      const url = 'http://localhost:8084/user/amineSSDDDS.kammoun@gmail.com';

      // Replace this with the updated user data
      
//if (this.userData.status==false){
      axios
        .put(url)
        .then(response => {
         console.log("aaaaaaaaaaaaaaaaaaa")
         this.redirectToTest()
          // Handle success or feedback here
        })
         
        .catch(error => {
          console.error('Error updating user data:', error);
          // Handle error or feedback here
        });//}else{
          console.log("aaaaaaa")
   //  }
    },

  },
};
 


</script>
<style>
 
</style>
