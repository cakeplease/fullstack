import { defineStore } from 'pinia';

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

        let result = eval(this.display).toString();

        if (isFinite(result)) {
            this.display = eval(this.display).toString();
        } else {
            this.display = errorMsg;
        }
        answerState = true;

    }

    return { display, remove, insert, clear, calculate }
})
