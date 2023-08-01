<template>
  <main>
      <div>
      <div class="my-5">
          <div class="mx-auto w-25 " style="max-width:100%;">
            <h2 class="text-center mb-3">Add user</h2>
            <form @submit.prevent="addUser">
              <!--name-->
              <div class="row">
                <div class="col-md-12 form-group mb-3">
                  <label for="name" class="form-label">First name</label>
                  <input id="name"  type="text" name="firstname" class="form-control" placeholder="Name" required v-model="user.firstname">
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
                    <input id="email" type="email"  name="email" class="form-control" placeholder="email" required v-model="user.email" >
                  </div>
                </div>

              <!--Phone Number-->
              <div class="row">
                  <div class="col-md-12 form-group mb-3">
                    <label for="password" class="form-label">password</label>
                    <input id="password" type="text"  name="password" class="form-control" placeholder="password" required v-model="user.password" >
                  </div>
                </div>

          
              
                 
    
              <!--Role-->
              <label for="Role" class="form-label">Role</label>
              <div class="form-check">
                <input class="form-check-input"   type="radio" name="role" id="admin" value="admin" v-model="user.role">
                <label class="form-check-label" for="admin">admin</label>
              </div>
              <div class="form-check">
                <br/><input class="form-check-input" type="radio"   name="role" id="Candidat" value="Candidat" v-model="user.role">
                <label class="form-check-label" for="Candidat">Candidat</label>
              </div>
           
             
              
             
              <div class="row">
                <div class="col-md-12 form-group">
                  <input class="btn btn-primary w-100" type="submit" value="Submit">
                </div>
              </div>
    
              <div>
                
              </div>
            </form>
      
          </div>
        </div>
      </div>
  </main>
</template>


<script>


  export default {
      name: 'AddUser',
    

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

      methods: {
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
                  this.$router.push("/");
              })

          }
      },
          
  }


</script>
<style></style>