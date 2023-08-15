<template>
  <article>
    <div class="container" :class="{ 'sign-up-active': signUp }">
      <div class="overlay-container">
        <div class="overlay">
          <div class="overlay-left">
            <h2>Welcome!</h2>
            <p>Please login with your personel info</p>
            <button class="invert" id="signIn" @click="signUp = !signUp">
              Sign In
            </button>
          </div>
          <div class="overlay-right">
            <h2>Hello Friend!</h2>
            <p>Please enter your personel details</p>
            <button class="invert" @click="signUp = !signUp">
              Sign Up
            </button>
          </div>
        </div>
      </div>
      <form class="sign-up" action="#">

      </form>
      <form class="sign-in" @submit.prevent="submit" action="#">
        <h2>Sign In</h2>
        <div>Use your account</div>
        <input v-model="data.email" type="email" placeholder="Email" />
        <input v-model="data.password" type="password" placeholder="Password" />
        <a href="#">Forget your password?</a>
        <button   type="submit">Sign In</button>
      </form>
    </div>
  </article>
</template>
 
<script>
import { reactive } from 'vue';
import axios from "axios";
import router from "@/router"; // Adjust the path according to your project structure
import { mapActions } from 'vuex';

export default {

  
  name: "Login",
  

  methods:{getUserByEmail(eeee) {
      const email = eeee;
      console.log( eeee)
      const url = `http://localhost:8084/email/${email}`;

      axios
        .get(url)
        .then(response => {
          this.donnee = response.data; 
          console.log('User data by email:', response.data);
          // Handle received user data
        })
        .catch(error => {
          console.error('Error fetching user data:', error);
          // Handle error or feedback here
        });
    }},

  data() {
     
    const data = reactive({
      email: '',
      password: '',
   token:'',
   id:'',
  role: '',
         
 
    });
   
    const { setUser } = mapActions(['setUser']); 
    const submit = async () => {
      try {
        const response = await axios.post('http://localhost:8084/api/v1/auth/authenticate', data, { withCredentials: true });
        axios.defaults.headers.common['Authorization'] = `Bearer ${response.data.token}`;
        // Save the user data in the store using the setUser action
       console.log(`Bearer ${response.data.token}`)
        router.app.isAuthenticated = true;
        router.push("/users");
        this.$store.dispatch('setUser', user); // Dispatch setUser action

     //  console.log(`Bearer ${response.data.token}`);
     this.getUserByEmail(`${response.data.email}`);
       data.token=`${response.data.token}`
        
        setUser(response.data.user);
        
      } catch (error) {
        // Handle errors if necessary
      }
    };

 
    return {
     donnee:null,
      data,
     
      submit,
      signUp: true
    };
  }
}

</script>

 
 
 
   

<style lang="scss" scoped>
article {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  min-height: 100vh;
}

.container {
  position: relative;
  width: 768px;
  height: 480px;
  border-radius: 10px;
  overflow: hidden;
  box-shadow: 0 15px 30px rgba(0, 0, 0, .2),
    0 10px 10px rgba(0, 0, 0, .2);
  background: linear-gradient(to bottom, #efefef, #ccc);

  .overlay-container {
    position: absolute;
    top: 0;
    left: 50%;
    width: 50%;
    height: 100%;
    overflow: hidden;
    transition: transform .5s ease-in-out;
    z-index: 100;
  }

  .overlay {
    position: relative;
    left: -100%;
    height: 100%;
    width: 200%;
    background: linear-gradient(to bottom right, #7FD625, #009345);
    color: #fff;
    transform: translateX(0);
    transition: transform .5s ease-in-out;

  }

  @mixin overlays($property) {
    position: absolute;
    top: 0;
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
    padding: 140px 80px;
    width: calc(50%);
    height: calc(100%);
    text-align: center;
    transform: translateX($property);
    transition: transform .5s ease-in-out;

  }

  .overlay-left {
    @include overlays(-40%);
  }

  .overlay-right {
    @include overlays(0);
    right: 0;
  }
}

h2 {
  margin: 0;
}

p {
  margin: 20px 0 30xp;
}

a {
  color: #222;
  text-decoration: none;
  margin: 15px 0;
  font-size: 1rem;
}

button {
  border-radius: 20px;
  border: 1px solid #009345;
  background-color: #009345;
  color: #fff;
  font-size: 1rem;
  font-weight: bold;
  padding: 10px 40px;
  margin-top: 5px;
  letter-spacing: 1px;
  text-transform: uppercase;
  transition: transform .1s ease-in;

  &:active {
    transform: scale(.9);
  }

  &:focus {
    outline: none;
  }
}

button.invert {
  background-color: transparent;
  border-color: #fff;
}

form {
  position: absolute;
  top: 0;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  padding: 140px 90px;
  width: calc(50%);
  height: calc(100%);
  text-align: center;
  background: linear-gradient(to bottom, #efefef, #ccc);
  transition: all .5s ease-in-out;

  div {
    font-size: 1rem;
  }

  input {
    background-color: #eee;
    border: none;
    padding: 8px 15px;
    margin: 6px 0;
    width: calc(100%);
    border-radius: 15px;
    border-bottom: 1px solid #ddd;
    box-shadow: inset 0 1px 2px rgba(0, 0, 0, .4),
      0 -1px 1px #fff,
      0 1px 0 #fff;
    overflow: hidden;

    &:focus {
      outline: none;
      background-color: #fff;
    }
  }
}

.sign-in {
  left: 0;
  z-index: 2;
}

.sign-up {
  left: 0;
  z-index: 1;
  opacity: 0;
}

.sign-up-active {
  .sign-in {
    transform: translateX(100%);
  }

  .sign-up {
    transform: translateX(100%);
    opacity: 1;
    z-index: 5;
    animation: show .5s;
  }

  .overlay-container {
    transform: translateX(-100%);
  }

  .overlay {
    transform: translateX(50%);
  }

  .overlay-left {
    transform: translateX(0);
  }

  .overlay-right {
    transform: translateX(20%);
  }
}

@keyframes show {
  0% {
    opacity: 0;
    z-index: 1;
  }

  49% {
    opacity: 0;
    z-index: 1;
  }

  50% {
    opacity: 1;
    z-index: 1;
  }
}</style>














