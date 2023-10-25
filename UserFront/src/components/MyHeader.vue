<template>
    <div id="myHeader" class="">
        <div class="header-center">
            <div class="logo-box">
                <img src="../../public/image/logo.svg" alt="">
            </div>

            <div class="header-menu">
                <div class="menu-item" @click="changeRouter('home')">
    
                    <img src="../../public/icon/home.svg" alt="">
                    <span>首页</span>
                </div>
                <div class="menu-item" @click="changeRouter('exchange')">
                    <img src="../../public/icon/integral.svg" alt="">
                    <span>积分商城</span>
                </div>
                <div class="menu-item" @click="changeRouter('roll')">
                    <img src="../../public/icon/rollroom.svg" alt="">
                    <span>Roll房</span>
                </div>
            </div>

            <div class="user-info">
                <div class="header-img">
                    <img src="../../public/image/17.jpg" alt="">
                </div>
                <div class="user-name">
                    <div style="line-height: 24px;">{{ store.user.name }}</div>
                    <div style="font-size: 12px; color: blue;">个人中心</div>
                </div>

                <div class="user-gold">
                    <img src="../../public/icon/gold.svg" alt="">
                    <span style="color: #FFC402;">{{ store.user.balance }}</span>
                </div>
            </div>
        </div>
    </div>
</template>
  
<script setup>
import { store } from '@/store/store'
import router from '@/router/router'


const changeRouter = (path) => {
    router.push(path);
}

</script>

  
  <!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="less">
#myHeader {
    z-index: 100;
    position: fixed;
    font-family: "zhRegular";
    font-size: 18px;
    line-height: 18px;
    left: 50%;
    top: 0;
    transform: translateX(-50%);
    max-width: 1920px;
    width: 100%;
    color: #EEEEEE;
    background-color: #181A21;

    .header-center {
        width: 80%;
        margin: 0 auto;
        height: 64px;

        display: flex;
        align-items: center;

        .logo-box {
            img {
                width: 128px;
            }
        }

        .header-menu {
            display: flex;
            align-items: center;
            justify-content: center;
            flex: 1 1 auto;

            .menu-item {
                margin-left: 64px;
                cursor: pointer;

                img {
                    width: 18px;
                    margin-right: 2px;
                }
            }
        }


        .user-info {
            display: flex;
            align-items: center;

            .header-img {
                img {
                    height: 48px;
                    border-radius: 50%;
                }
            }

            .user-name {
                font-size: 14px;
                font-weight: 100;
                margin-left: 12px;
            }

        }

        .user-gold {
            display: flex;
            align-items: center;
            margin-left: 128px;

            img {
                margin-right: 4px;
                height: 24px;
            }
        }
    }
}</style>
  