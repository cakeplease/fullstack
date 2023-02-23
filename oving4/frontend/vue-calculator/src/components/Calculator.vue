<script setup>
  import {useDisplayStore} from "@/stores/display";
  import {useLogStore} from "@/stores/log";
  const displayStore = useDisplayStore();
  const logStore = useLogStore();
  let buttons = ['C','ANS','DEL','+', 1,2,3,'-',4,5,6,'*',7,8,9,'/',' ',0, ".",'='];
  function randomColors() {
    return '#' + Math.floor(Math.random() * 16777215).toString(16);
  }
</script>

<template>
  <div class="calculator-wrapper">
    <input type="text" class="display" readonly :value=displayStore.display>
    <div class="button-wrapper">
      <button v-for="button in buttons" :value=button
       @:mouseover="(event) => {
        event.target.style.backgroundColor = randomColors();
      }"
       @:mouseleave="(event)=> {
        event.target.style.backgroundColor = '#000';
      }"
       @:mousedown="(event)=> {
        event.target.style.fontSize = '20px';
      }"
       @:mouseup="(event)=> {
        event.target.style.fontSize = '20px';
       }"
       @:click="()=> {
         if (button == 'C') {
           displayStore.clear();
         } else if (button == 'DEL') {
           displayStore.remove();
         } else if (button == 'ANS') {
           displayStore.clear();
           displayStore.insert(logStore.getLastResult());
         } else if (button == '=') {
           let equation = displayStore.display;
           displayStore.calculate();

           /*let result = displayStore.display;
           logStore.add(equation, result);*/
         } else {
           displayStore.insert(button);
         }
       }"

      >{{ button }}</button>
    </div>
  </div>

  <div class="log-wrapper">
    <h3>Logg:</h3>
    <div class="log">
      <p v-for="log in logStore.log">{{ log }}</p>
    </div>
  </div>
</template>

<style lang="scss">
h1 {
  font-size: 85px;
  color: #bd50ff;
}
.calculator-wrapper {
  border: 1px solid #000;
  padding: 10px;
  background-color: #000;

  .display {
    width: 100%;
    background-color: #000;
    padding: 15px;
    font-size: 22px;
    text-align: right;
    color: #fff;
  }

  .button-wrapper {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr 1fr;

    button {
      padding: 20px 25px;
      color: #fff;
      font-size: 20px;
      background-color: #000;
      border: 1px solid #fff;

      &:hover {
        cursor: pointer;
      }
    }
  }
}

.log-wrapper {
  width: 100%;
  padding: 0 10px;

  h3 {
    color: #bd50ff;
    font-size: 25px;
    font-weight: bold;
  }
  .log {
    overflow-y: scroll;
    height: 370px;
  }
}

</style>