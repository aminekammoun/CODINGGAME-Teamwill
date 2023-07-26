<template>
  <div id="app">
    <button
        type="button"
        class="btn"
        @click="showModal"
      >
        Abrir Modal
      </button>
    <Modal
     v-show="modalVisible"
     @close="closeModal"
     title="Modal Exemple"
     text="Text modal exemple!" 
    />
  </div>
</template>

<script>
import Modal from "../components/Modal.vue";

export default {
  name: "App",
  components: {
    Modal
  },
  data () {
    return {
      data: {},
      modalVisible: false,
    }
  },
  methods: {
    showModal() {
      this.modalVisible = true
    },
    closeModal() {
      this.modalVisible = false
    }
  }
};
</script>

<style>
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
</style>
