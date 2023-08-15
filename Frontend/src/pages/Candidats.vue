<template>
    
    <div> <div>  
 
    <table class="table table-striped">
                         <thead>
                           <tr>
                             <th scope="col">Id</th>
                             <th scope="col">firstname</th>
                             <th scope="col">lastname</th>
                             <th scope="col">Status</th>
                             <th scope="col">Résultat</th>
                            
                           </tr>
                         </thead>
                         <tbody>
                             <tr v-for="user in candidats" :key="user.id">
                                <th scope="row">{{user.id}}</th>
                             <td>{{user.firstname}}</td>
                             <td>{{user.lastname}}</td>
                             <td>{{user.status}}</td>
                             <td>{{user.resultat}}</td>
                           </tr>
                         </tbody>
                       </table>
                     
                             
                       
                       </div>
   
   
    
 
   
     </div>
 
   </template>
   <script>
 
 
  import { PaperTable } from "@/components";
   
   
   export default {
     
     components: {
       PaperTable,
     },
    
     data() {
         
             return {
               
                 candidats: []
             }
     },
 
         beforeMount(){
     
             this.getCandidats("CANDIDAT")
         },
 
         methods: {
             getCandidats(CANDIDAT="CANDIDAT"){
                 fetch('http://localhost:8084/candidats/CANDIDAT')
                 .then(res => res.json())
                 .then(data => {  
                     this.candidats = data
                     console.log(data)
                 })
             },
     
        }};
       
     
 
   </script>
    