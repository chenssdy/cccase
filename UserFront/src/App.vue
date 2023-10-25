<template id="app">
  <router-view></router-view>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style lang="less">

#app{
  background-color: #090909;
}
*{
    margin: 0;
    padding: 0;
    font-family: "zhRegular";
    color: #eeeeee;
  }
/* 在线链接服务仅供平台体验和调试使用，平台不承诺服务的稳定性，企业客户需下载字体包自行发布使用并做好备份。 */
@font-face {
    font-family: "zhRegular";
    font-weight: 400;
    src: url('../public/font/zcool-gdh_Regular.ttf');
    font-display: swap;
}
</style>
