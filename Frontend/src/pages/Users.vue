<template>

   <div>   
     <div>     
      <div class="col-12"></div>
   <div id="app">
    <section class="bar-container">
    <div class="bar-item">
      <input
        type="text"
        v-model="search"
        placeholder="Find user"
        class="search-bar"
      />
    </div>
  </section>
<br/>
 

  
  <table class="table table-striped">
                        <thead>
                          <tr>
                            <th scope="col">Id</th>
                            <th scope="col">firstname</th>
                            <th scope="col">lastname</th>
                            <th scope="col">email</th>
                            <th scope="col">Role</th>
                           <th scope="col"><button
        type="button"
        class="btn btn-primary pull-right"
        @click="showModal"
      >
     Add user
      </button></th>
                          </tr>
                        </thead>
                        <tbody>
                            <tr v-for="user in filterUserData" :key="user.id">
                            <th scope="row">{{user.id}}</th>
                            <td>{{user.firstname}}</td>
                            <td>{{user.lastname}}</td>
                            <td>{{user.email}}</td>
                            <td>{{user.role}}</td>
                            
                            <td>
                              
                              <button  class="btn btn-primary pull-right" @click="deleteUser(user.id)" >Delete</button>
                            </td>
                          </tr>
                        </tbody>
                        </table>
                        </div>
                        <div class="container my-5">
    
                        </div>
                     
  
       </div>
       <div>
        <Modal
     v-show="modalVisible"
     @close="closeModal"
     title="Modal Exemple"
     text="Text modal exemple!" 
     refresh 
    />
    
  </div>
  </div>  
                   
  
  
 
   

  </template>
  <script>
    
 

 import { PaperTable } from "@/components";
 import { ref } from 'vue';
 import { reactive } from 'vue';
 

import Modal from "../components/Modal.vue"

 
 



  export default {
    name: "DisplayUserData",
    name: "App",
    components: {
      PaperTable,
      Modal

    },

    mounted() {
    fetch('http://localhost:8084/users')
          .then((res) => res.json())
      .then((data) => (this.userData = data));
    console.log(this.userData);
  },
  computed: {
    filterUserData: function () {
      return this.userData.filter((user) => {
        return ((user.lastname.toLowerCase().match(this.search.toLowerCase()))||(user.firstname.toLowerCase().match(this.search.toLowerCase()))||(user.email.toLowerCase().match(this.search.toLowerCase()))||(user.role.toLowerCase().match(this.search.toLowerCase())));
      });
    },
  },
    data() {
        
            return {
                questions: [],
                users: [],
                modalVisible: false,
                data: {},
                userData: [],
                search: "",
            }
    },
    

   
        beforeMount(){
            this.getQuestions()
            this.getUsers()
        },

        methods: {
          showModal() {
      this.modalVisible = true
    },
    closeModal() {
      this.modalVisible = false
    },
            getUsers(){
                fetch('http://localhost:8084/users')
                .then(res => res.json())
                .then(data => {  
                    this.users = data
                    console.log(data)
                })
            },
            getQuestions(){
                fetch('http://localhost:8084/questions')
                .then(res => res.json())
                .then(data => {
                    this.questions = data
                    console.log(data)
                })
            },
            deleteQuestion(id){
                fetch(`http://localhost:8084/question/${id}`, {
                    method: 'DELETE'
                })
                .then(data => {
                    console.log(data)
                    this.getQuestions()
                })
            },
            deleteUser(id){
                fetch(`http://localhost:8084/user/${id}`, {
                    method: 'DELETE'
                })
                .then(data => {
                    console.log(data)
                    this.getUsers()
                })
            },
        
       }};
      
    

  </script>
  <style>
  
.flex-container {
  display: flex;
  width: 100%;
  flex-flow: row wrap;
  margin: 0 auto;
  justify-content: space-evenly;
  align-items: flex-start;
}
.flex-item {
  width: 363px;
  height: 725px;
  margin: 0px 43.5px 43.5px 25px;
  background-color: white;
  position: static;
  border-radius: 8px;
  line-height: 36px;
}
.paragraph-weight {
  font-weight: 600;
  margin-left: 50px;
}
.bar-container {
  display: flex;
 
 
  margin: 0 auto;
  border-radius: 8px;
  justify-content: space-between;
  align-items: flex-start;
  text-align: center;
}
.bar-item {
   
  
  position: right;
  align-self: stretch;
  
  background-color: cadetblue;

}
p img {
  margin-right: 12px;
}
span {
  display: inline-block;
}
input {
  border: 0;
  border-radius: 8px;
  width: 546px;
  height: 50px;
  font-weight: 550;
  color: black;
}
button {
  background-color: #FFFFFF;
  padding: 10px 30px 10px 30px;
  border: 0;
  border-radius: 8px;
}
::placeholder {
  color: black;
}
@media only screen and (max-width: 568px) {
  .flex-container {
    flex-direction: column;
    flex-grow: 1;
    justify-content: space-between;
  }
  .flex-item {
    width: 344px;
    height: 368px;
    margin: 0px 43.5px 43.5px 25px;
    font-size: 13px;
    font-weight: 400;
    line-height: 32px;
  }
  .bar-container {
    align-items: flex-end;
    flex-flow: wrap;
    width: 100%;
  }
  .bar-item {
    width: 100%;
    margin-top: 16px;
  }
  .profile-img {
    position: absolute;
    width: 116px;
    height: 112px;
    border-radius: 8px;
    justify-self: center;
    float: right;
  }
  .paragraph-weight {
    margin-left: 8px;
  }
  img {
    position: absolute;
  }
  input {
    width: 100%;
  }
}
  #app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

.btn {
    background-color: white;
    color: #004D40;
    padding: 5px 20px;
    border-radius: 3px;
  }
  .btn:hover {
    background-color: #00897B;
    color: white;
  }
  div#app {
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  .search-wrapper {
    position: relative;
    label {
      position: absolute;
      font-size: 12px;
      color: rgba(0,0,0,.50);
      top: 8px;
      left: 12px;
      z-index: -1;
      transition: .15s all ease-in-out;
    }
    input {
      padding: 4px 12px;
      color: rgba(0,0,0,.70);
      border: 1px solid rgba(0,0,0,.12);
      transition: .15s all ease-in-out;
      background: white;
      &:focus {
        outline: none;
        transform: scale(1.05);
        & + label  {
          font-size: 10px;
          transform: translateY(-24px) translateX(-12px);
        }
      }
      &::-webkit-input-placeholder {
          font-size: 12px;
          color: rgba(0,0,0,.50);
          font-weight: 100;
      }
    }
  }

  .wrapper {
    display: flex;
    max-width: 444px;
    flex-wrap: wrap;
    padding-top: 12px;
  }

  .card {
    box-shadow: rgba(0, 0, 0, 0.117647) 0px 1px 6px, rgba(0, 0, 0, 0.117647) 0px 1px 4px;
    max-width: 124px;
    margin: 12px;
    transition: .15s all ease-in-out;
    &:hover {
      transform: scale(1.1);
    }
    a {
      text-decoration: none;
      padding: 12px;
      color: #03A9F4;
      font-size: 24px;
      display: flex;
      flex-direction: column;
      align-items: center;
      img {
        height: 100px;
      }
      small {
        font-size: 10px;
        padding: 4px;
      }
    }
  }



  .hotpink {
    background: hotpink;
  }

  .green {
    background: green;
  }

  .box {
    width: 100px;
    height: 100px;
    border: 1px solid rgba(0,0,0,.12);
  }}
</style>
