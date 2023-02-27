import { defineStore } from 'pinia';
import axios from "axios";

export const useDisplayStore = defineStore('display', () => {
    const display = "";
    const errorMsg = "Ugyldig uttrykk";
    let answerState = false;

    function remove() {
        this.display = this.display.slice(0, -1);
    }
    function insert(text) {

        //check if last action was "answer"
        if (answerState) {
            this.display = "";
            answerState = false;
        }

        //check for error msg in the display
        if (this.display === errorMsg) {
            this.display = text;
        }

        //check for multiple commas in a row
        if (text === ".") {
            if (this.display.charAt(this.display.length-1) !== ".") {
                this.display += text;
            }
        } else {
            this.display += text;
        }

    }
    function clear() {
        this.display = "";
    }
    function calculate() {
        axios.get('http://localhost:8080/?calculate='+this.display)
            .then((res) => {
                if (res.status >= 200 && res.status < 300) {
                    this.display = res.data;
                    answerState = true;
                }
            })
            .catch((error) => {
                if (error.response.status === 400) {
                    this.display = errorMsg;
                    answerState = true;
                } else {
                    console.error(error)
                }
            });

    }

    return { display, remove, insert, clear, calculate }
})
