import { defineStore } from 'pinia';

export const useFeedbackStore = defineStore('feedback', () => {
    const name = "";
    const email = "";
    const message = "";

    function addName(name) {
        this.name = name;
    }
    function addEmail(email) {
        this.email = email;
    }
    function addMessage() {
        this.message = message;
    }

    return { name, email, message,addName, addEmail, addMessage }
})
