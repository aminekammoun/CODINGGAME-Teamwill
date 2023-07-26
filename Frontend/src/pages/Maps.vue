
<template>
  <section class="bar-container">
    <div class="bar-item">
      <input
        type="text"
        v-model="search"
        placeholder="Find Customers"
        class="search-bar"
      />
    </div>
   
  </section>

</template>

<script>
export default {
  name: "DisplayUserData",
  components: {},
  data() {
    return {
      userData: [],
      search: "",
    };
  },
  /* 
    Fetch data from API and save it in userData
  */
  mounted() {
    fetch('http://localhost:8084/users')
          .then((res) => res.json())
      .then((data) => (this.userData = data));
    console.log(this.userData);
  },
  /*
    filter through userData, if the data input into the searchbar
    matches the data in userData, the results will be returned
  */
  computed: {
    filterUserData: function () {
      return this.userData.filter((user) => {
        return user.firstname.toLowerCase().match(this.searchtoLowerCase());
      });
    },
  },
};
</script>

<style scoped>
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
  position: static;
  width: 100%;
  margin: 0 auto;
  border-radius: 8px;
  justify-content: space-between;
  align-items: flex-start;
  text-align: center;
}
.bar-item {
  width: 100%;
  position: static;
  align-self: stretch;
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
</style>