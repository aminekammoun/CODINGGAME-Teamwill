<template>
   <div class="custom-modal">
    <div class="modal-content">
      
    <h4> {{ timerCount }} </h4>
    <h2>{{ questions[numquest].type }}</h2><h2>{{ questions[numquest].idquest }}</h2>
    <h4 scope="row">question {{ questions[numquest].idquest }}: {{ questions[numquest].question }}</h4>
    <form @submit.prevent="submitFormw">
      <p class="radio-btns">
      <div v-for="(option, index) in options" :key="index" style="margin-top: 15px">
        <input type="radio" :value="option" name="radio" v-model="selectedOption" :id="'radio' + (index)"
          style="height: 35px; width: 35px; vertical-align: middle; margin-left: 25px;">
        <label :for="'radio' + (index )" style="margin-left: 25px;">{{ option }}</label>
      </div>
      </p>
    
      
     
           <b-button @click="changeQuestion" style="margin-right:150px ;"  >skip</b-button>
          
  <b-button @click="submitForm" variant="primary" style="margin-left:5px ;"   :disabled="!selectedOption"   class="custom-submit-button" >Submit</b-button>
 
    </form>
    <p>Selected option: {{ selectedOption }}</p>

  </div></div> 
</template>
<script>


import { PaperTable } from "@/components";
import axios from 'axios';
import NotificationTemplate from "./Notifications/NotificationTemplate";

export default {

  components: {
    PaperTable,
  },

  data() {
    return {
      questions: [],
      numquest: 0,
      selectedOption: '',
      options: [],
      timerCount: 10,
      boxTwo: '',
      
      score: 0,
      type: ["", "danger"],
      notifications: {
        topCenter: false,
      },
    };
  },

  
  beforeMount() {
    this.getQuestions()
 

  },

  methods: {
    showMsgBoxTwo() {
      this.boxTwo = ''
      this.$bvModal.msgBoxOk('Data was submitted successfully', {
        title: 'Confirmation',
        size: 'sm',
        buttonSize: 'sm',
        okVariant: 'success',
        headerClass: 'p-2 border-bottom-0',
        footerClass: 'p-2 border-top-0',
        centered: true,
      
        
      })
        .then(value => {
          this.boxTwo = value
          this.handleOk()
        })
        .catch(err => {
          // An error occurred
        })
    },
    handleOk(){
      this.$router.push('/stats');

    },
    updateUserscore() {

const url = 'http://localhost:8084/score/aminezzzkammoun@gmail.com';

 
const updatedUserData = {
    
    resultat: this.score ,  
  };
 
  axios
    .put(url, updatedUserData)  
    .then(response => {
      console.log('User data updated successfully:', response.data);
    })
    .catch(error => {
      console.error('Error updating user data:', error);
     });
    },
    changeReponse(aaa) {
      this.options[0] = aaa.reponse.reponse1;
      this.options[1] = aaa.reponse.reponse2;
      this.options[2] = aaa.reponse.reponse3;
    },
    submitForm() {
      console.log('Selected option:', this.selectedOption);
      if (this.numquest < this.questions.length - 1) {
        if (this.selectedOption === this.questions[this.numquest].reponse.reponsecorrecte) {
        this.score++;
        console.log(this.score, "bbbbbbbbbbbbbbbbb");
       
      }
        this.numquest++;
        this.changeReponse(this.questions[this.numquest]);
        this.timerCount = 10;
        this.selectedOption = ''; // Reset selectedOption
      } else {
        console.log('End of questions');
        this.updateUserscore()
        this.showMsgBoxTwo()
         
        
      }
    },
    redirectToScorepage() {
      
      this.$router.push('/stats');
    

    },
    notifyVue(verticalAlign, horizontalAlign) {
      const color = Math.floor(Math.random() * 1 + 1);
      this.$notify({
        component: NotificationTemplate,
   
        horizontalAlign: horizontalAlign,
        verticalAlign: verticalAlign,
        type: this.type[color],
      });
    },
    changeQuestion() {
    
     if (this.numquest < this.questions.length  ) {
        this.numquest++;
        this.selectedOption = '';
        console.log(this.numquest);
        this.changeReponse(this.questions[this.numquest])

      }
    
      else 
      {
        this.showMsgBoxTwo()

      }

    },
    getQuestions() {
      fetch('http://localhost:8084/questions')
        .then(res => res.json())
        .then(data => {
          this.questions = data
          this.changeReponse(this.questions[0])

          console.log(data)

        })


    },},
  watch: {

    timerCount: {
      handler(value) {
        if(value == 0 && this.numquest == this.questions.length -1   ){
            this.showMsgBoxTwo()
          }
        if (value > -1) {
          setTimeout(() => {
            this.timerCount--;
          }, 1000);
        }      
        else if (this.numquest < this.questions.length) {
       
            this.notifyVue('top', 'center');
            this.changeQuestion();
            this.timerCount = 5;
          }
     
        
     
      },
      immediate: true // This ensures the watcher is triggered upon creation
    }

  }
};




</script>
<style scoped>
.custom-submit-button:disabled {
  background-color: gray; /* Change the background color */
  color: white; /* Change the text color */
}
.custom-modal {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: rgb(56, 99, 84);
}

.modal-content {
  background-color: rgba(220, 246, 215, 0.975);
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.2);
  padding: 20px;
  max-width: 500px;
  width: 90%;
  display: flex;
  flex-direction: column; /* Stack content vertically */
  justify-content: center; /* Center content vertically */
  align-items: center; /* Center content horizontally */
}
</style>