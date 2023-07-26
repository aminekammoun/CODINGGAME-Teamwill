<template>
    <transition name="modal-fade">
      <div class="modal-container">
        <div class="modal">
          <header class="modal-header">
          <slot name="header">
            <h3>Add user</h3>
          </slot>
        </header>
        <section class="modal-body">
        <div>
             
               
             
            <form @submit.prevent="addUser()">
              <!--name-->
              <div class="row">
                <div class="col-md-12 form-group mb-3">
                  <label for="name" class="form-label">First name</label>
                  <input id="name"  type="text" name="firstname" class="form-control" placeholder="Firstame" required v-model="user.firstname">
                </div>
              </div>
               <!--surname-->
              <div class="row">
                  <div class="col-md-12 form-group mb-3">
                    <label for="surname" class="form-label">Lastname</label>
                    <input id="surname" type="text"  name="lastname" class="form-control" placeholder="Lastname" required v-model="user.lastname" >
                  </div>
                </div>
              
              <!--Email-->
              <div class="row">
                  <div class="col-md-12 form-group mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input id="email" type="email"  name="email" class="form-control" placeholder="Email" required v-model="user.email" >
                  </div>
                </div>

              <!--Phone Number-->
              <div class="row">
                  <div class="col-md-12 form-group mb-3">
                    <label for="password" class="form-label">password</label>
                    <input id="password" type="password"  name="password" class="form-control" placeholder="password" required v-model="user.password" >
                  </div>
                </div>

          
              
                 
    
              <!--Role-->
              <label for="gender" class="form-label">Role</label>
              <div class="form-check">
                <input class="form-check-input"   type="radio" name="role" id="admin" value="ADMIN" v-model="user.role">
                <label class="form-check-label" for="admin">admin</label>
              </div>
              <div class="form-check">
                <input class="form-check-input" type="radio"   name="role" id="Candidat" value="CANDIDAT" v-model="user.role">
                <label class="form-check-label" for="Candidat">Candidat</label>
              </div>
           
              
              <div class="row">
                <div class="col-md-12 form-group">
                  <input class="btn btn-primary w-100" type="submit" @click="reloadPage" value="Submit">
                </div>
              </div>
              <button
            type="button"
            class="btn btn-primary w-100"
            @click="close"
          >
            Close
          </button>
              <div>
                
              </div>
                
              
                
              
            </form>
        </div>
        </section>
       
       
        </div>
      </div>
    </transition>
  </template>
  
  <script>

 

       
      
  export default {
    data() {
          return {
            user : {
                  firstname: '',
                  lastname:'',
                  email: '',
                  role: '',
                  password:''
              }
          }
      },
    props: {
      title: {
        type: String,
        default: ''
      },
      text: {
        type: String,
        default: ''
      }
    },
    methods: {
        reloadPage() {
          window.location.reload();
        },
        addUser(){
              fetch('http://localhost:8084/api/v1/auth/register', {
                  method: 'POST',
                  headers: {
                      'Content-Type': 'application/json'
                  },
                  body: JSON.stringify(this.user)
              })
              .then(data => {
                  console.log(data)
                  this.$router.push("/users");
             
         
              })
           

          },
      close() {
        this.$emit('close');
      }
    }
  }
  </script>
  
  <style scoped>
  
    .modal-container {
      position: fixed;
      top: 0;
      bottom: 0;
      left: 0;
      right: 0;
      background-color: rgba(0, 0, 0, 0.3);
      display: flex;
      justify-content: center;
      align-items: center;
    }
    .modal {
    background: #FFFFFF;
    top:auto;
      left:auto;
    overflow-x: auto;
    display: flex;
    flex-direction: column;
    width: 400px;
    border-radius: 3px;
  }

    .modal {
      background: #FFFFFF;
      top:auto;
      left:auto;
      height: min-content;
      width: min-content ;
      overflow-x: auto;
      display: flex;
      flex-direction: column;
      width:450px;
      border-radius: 3px;
    }
  
    .modal-header,
    .modal-footer {
      padding: 15px;
      display: flex;
    }
  
    .modal-header {
      color: grey;
      justify-content: space-between;
    }
  
    .modal-footer {
      justify-content: flex-end;
    }
  
    .modal-body {
      color: grey;
      position: relative;
      padding: 20px 10px;
      margin-left: 6px;
    }
    .btn-close {
      color: #4DB6AC;
      background: #E0F2F1;
      padding: 5px 20px;
      border-radius: 3px;
    }
    .btn-close:hover {
      background-color: #4DB6AC;
      color: white;
    }
  
    .modal-fade-enter,
    .modal-fade-leave-active {
      opacity: 0;
    }
  
    .modal-fade-enter-active,
    .modal-fade-leave-active {
      transition: opacity .10s ease
    }
  </style>