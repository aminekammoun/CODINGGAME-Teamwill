<template>
    <div class="quote-container">
      <div class="quote-text">
        <p>"{{ quote }}"</p>
      </div>
      <div class="quote-author">
        <p>- {{ author }}</p>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    props: {
      quote: {
        type: String,
        required: true,
      },
      author: {
        type: String,
        required: true,
      },
    },
  };
  </script>
  
  <style>
  .quote-container {
    text-align: center;
    margin: 20px 0;
  }
  
  .quote-text {
    font-size: 24px;
    font-style: italic;
    color: #41b87e;
  }
  
  .quote-author {
    margin-top: 10px;
    font-size: 18px;
    color:#4b4a49 ;
  }
  

  </style>
  