<script>
import axios from "axios";

export default {
  name: 'Login',
  data() {
    return {
      input: {
        username: "",
        password: ""
      }
    }
  },
  methods: {
    login() {
      if (this.input.username !== "" && this.input.password !== "") {
        axios.post('http://localhost:8080/login', this.input)
            .then((res) => {
              if (res.status >= 202 && res.status < 300) {
                //...
                console.log(res)
                //this.$router.replace({ name: "secure" });
              }
            })
            .catch((error) => {
                console.error(error)
            });


      } else {
        console.log("A username and password must be present");
      }
    }
  }
}


</script>

<template>
  <div id="login">
    <h1>Login</h1>
    <input type="text" name="username" v-model="input.username" placeholder="Username" />
    <input type="password" name="password" v-model="input.password" placeholder="Password" />
    <button type="button" v-on:click="login()">Login</button>
  </div>
</template>

<style lang="scss">
  h1 {
    font-size: 30px;
  }
  input {
    display: block;
    margin-bottom: 20px;
    height: 30px;
  }
</style>