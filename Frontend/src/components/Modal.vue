<template>
    

    <b-modal v-model="modalShow">
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
              <label for="role" class="form-label">Role</label>
              <div class="form-check">
                <input    type="radio" name="role" style="height:35px; width:35px; vertical-align: middle;" id="admin" value="ADMIN" v-model="user.role">
                <label  for="admin" style="margin-left: 5px;">admin</label>
              </div>
              <div class="form-check">
                <input  type="radio"  style="height:35px; width:35px; vertical-align: middle;" name="role" id="Candidat" value="CANDIDAT" v-model="user.role">
                <label  for="Candidat" style="margin-left: 5px;">Candidat</label>
              </div>
           
             <br/>  
             
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
           
     </b-modal>

       
      
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
        onClickOutside (event, el) {
    this.closeModal();
  },
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