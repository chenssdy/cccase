<template>
  <div id="my-main" class="dark">
    <div class="flex f-column page">
      <MyHeader></MyHeader>
      <OpenCaseRecord></OpenCaseRecord>
      <div class="flex f-stretch main">
        <transition name="fade">
          <router-view>
          </router-view>
        </transition>
      </div>
    </div>
  </div>
</template>
  
<script>
import OpenCaseRecord from '../components/OpenCaseRecord.vue'
import MyHeader from '../components/MyHeader.vue'
export default {
  name: 'MyMain',
  data() {
    return {

    }
  },
  components: {
    MyHeader,
    OpenCaseRecord
  }
}
</script>
  
<style lang="less">
#my-main {
  min-height: 100vh;
  height: 100%;
}


.fade-enter-active,
.fade-leave-active {
  transition: opacity .5s;
}

.po {
  position: absolute;
}

.fade-enter,
.fade-leave-to

/* .fade-leave-active below version 2.1.8 */
  {
  opacity: 0;
}

#my-main {
  width: 100%;

  .page {
  }

  .flex {
    display: flex;
  }

  .f-column {
    flex-direction: column;
  }

  .f-stretch {
    align-items: stretch;
  }

  .main {
    display: flex;
    flex-direction: column;
    position: relative;
    height: 100%;
  }
}
</style>