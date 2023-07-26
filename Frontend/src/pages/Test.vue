<template>              

                        <div>
                          {{ timerCount }}
                            <H4 scope="row">la question d'indice {{questions[this.i].idquest}} est de type {{questions[this.i].type}} est {{questions[this.i].question}}</H4>
                            
                            <p  class="radio-btns">

                                <input type="radio" value="reponse 1" name="radio" id="radio1">
                                 <label for="radio3">... reponse 1</label>
                                 <br/>
                                  <input type="radio" value="reponse 3" name="radio" id="radio2">   
                                 <label for="radio2">... reponse2</label>
                                 <br/>
                                 <input type="radio" value="reponse 3" name="radio" id="radio3">
                                 <label for="radio1">... reponse3</label>
                            </p>
                            <button class="btn btn-primary" @click="changeQuestion">passer sans repondre</button>
                            <button @click="createTask()" class="btn btn-primary pull-right">Submit</button>
                        
          
                        </div>
              
</template>
   <script>
 
 
  import { PaperTable } from "@/components";
  
  import NotificationTemplate from "./Notifications/NotificationTemplate";
   
   export default {
     
     components: {
       PaperTable,
     },
    
     data() {
         
             return {
                 questions: [],
                 users: [],
                 timerCount: 3,
              i:0,
              type: ["",   "danger"],
              notifications: {
        topCenter: false,
      },
                }
     },
 
         beforeMount(){
             this.getQuestions()
             this.getUsers()
            
         },
 
         methods: {
          notifyVue(verticalAlign, horizontalAlign) {
      const color = Math.floor(Math.random() * 1 + 1);
      this.$notify({
        component: NotificationTemplate,
   
        horizontalAlign: horizontalAlign,
        verticalAlign: verticalAlign,
        type: this.type[color],
      });
    },
    
changeQuestion(){
 
if (this.i<2)   
   {
    this.i++;
   console.log (this.i);
   }
   else if (this.i==0){
   console.log (this.i);}

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
           
             deleteUser(id){
                 fetch(`http://localhost:8084/user/${id}`, {
                     method: 'DELETE'
                 })
                 .then(data => {
                     console.log(data)
                     this.getUsers()
                 })
             },
         
        },
        watch: {
        
timerCount: {
    handler(value) {
     
 
        if (value > 0) {
            setTimeout(() => {
                this.timerCount--;
            }, 1000);
        }
        else  
        { if (this.i<2) 
          {this.notifyVue('top', 'center');
          let ij=0; 
           
         
            this.changeQuestion();
          this.timerCount= 3;
          }
        }

    },
    immediate: true // This ensures the watcher is triggered upon creation
}

}};

       
     
 
   </script>
   <style>
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
 