import {defineStore} from 'pinia';

export const useLogStore = defineStore('log', () => {
    const log = [];
    let lastResult = "";

    function clear() {
        this.log = [];
    }

    function add(equation, result) {
        if (isFinite(result)) {
            this.log.unshift(equation+" = "+result);
            this.lastResult = result;
        }
    }

    function getLastResult() {
        return this.lastResult;
    }

    return {log, clear, add, getLastResult}
})