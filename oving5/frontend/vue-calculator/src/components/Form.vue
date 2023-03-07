<script>
import {useFeedbackStore} from "@/stores/form";
import axios from 'axios';
import {mapWritableState} from "pinia";
export default {
  computed: {
    ...mapWritableState(useFeedbackStore, ['name', 'email', 'message']),
  },
  data: ()=> {
    return {
      response: "",
    }
  },
  methods:{
    submitForm(){
      axios.post('http://localhost:3000/form', {
            name: this.name,
            email: this.email,
            message: this.message
          })
          .then((res) => {
            //console.log(res);
            if (res.status >= 200 && res.status < 300) {
              this.response = "Takk for din tilbakemelding";
            }
          })
          .catch((error) => {
            //console.error(error);
            this.response = "Noe gikk galt";
          });
    }
  }
}
</script>
<template>
  <h1>Form!</h1>
  <form @submit.prevent="submitForm">
    <p>Navn: </p>
    <input type="text" v-model="name" placeholder="Name" class="name" required/>

    <p>E-postadresse:</p>
    <input type="email" v-model="email" placeholder="E-postadresse" class="email" required/>
    <p>Melding:</p>
    <textarea v-model="message" class="message" required></textarea>
    <button type="submit">Send</button>
  </form>

  <p id="response">{{this.response}}</p>

</template>