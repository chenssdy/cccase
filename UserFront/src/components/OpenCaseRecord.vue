<template>
  <div class="open_case_record">
    <TransitionGroup name="fade" tag="ul" class="container">
      <div :key="item.id" v-for="item in items" class="item" >
        <div class="img-box">
          <img :src="item.img" alt="">
        </div>
        <div class="name">
          <div>
            {{ item.fname }}
          </div>

          <div>
            {{ item.lname }}
          </div>
        </div>

        <div class="wear">
          {{ item.wearStr }}
        </div>

      </div>
    </TransitionGroup>

  </div>
</template>
  
<script setup>
import { ref } from "vue";

const caseAccListItem = ref([',','item-1','item-2','item-3','item-4','item-5'])

let item = {
  id: 1,
  name: 'AK-47 | 野荷',
  wearStr: '略有磨损',
  img: '/image/image.png',
  fname: '',
  lname: ''
}

let index = item.name.indexOf('|');

item.fname = item.name.slice(0, index);
item.lname = item.name.slice(index + 1);


let testList = [item]

let items = ref(testList);


let i = item.id;

setInterval(()=> {

  if(items.value.length > 15){
    items.value.pop();
  }

  let aa = {...item};
  i = i + 1;

  aa.id = i;

  items.value.unshift(aa);
}, 1000)

</script>

  
  <!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="less">
.open_case_record{
  margin-top: 64px;

}

.item {
  position: relative;
  width: 180px;
  height: 68px;
  background: linear-gradient(77.06deg, rgba(235, 75, 75, .2) .78%, rgba(32, 34, 43, 0) 48.5%);

  font-size: 14px;
  border-left: 1px solid #20222c;
  .img-box {
    width: 180px;
    height: 68px;
    display: flex;
    align-items: center;
    img {
      width: 80px;
      height: 50px;
      margin: 0 auto;
    }

  }

  .name {
    position: absolute;
    bottom: 2px;
    left: 6px;
  }

  .wear {
    position: absolute;
    right: 6px;
    bottom: 2px;
    opacity: 0.8;
  }
}

.item::before {
  background: linear-gradient(180deg, transparent, #eb4b4b 50%, transparent);
  content: "";
  position: absolute;
  left: 0;
  top: 0;
  z-index: 2;
  width: 1px;
  height: 100%;
}

.container {
  width: 100%;
  height: 68px;
  position: relative;
  padding: 0;
  white-space: nowrap;
  /* 防止文本换行 */
  /* 添加边框样式（可选） */
  overflow: hidden;
  background-color: #181a21;
  display: flex;
}



/* 1. 声明过渡效果 */
.fade-move,
.fade-enter-active,
.fade-leave-active {
  transition: all 0.5s cubic-bezier(0.55, 0, 0.1, 1);
}

/* 2. 声明进入和离开的状态 */
.fade-enter-from,
.fade-leave-to {
  opacity: 0;
  transform: scaleY(0.01) translate(30px, 0);
}

/* 3. 确保离开的项目被移除出了布局流
      以便正确地计算移动时的动画效果。 */
.fade-leave-active {
  position: absolute;
}
</style>
  