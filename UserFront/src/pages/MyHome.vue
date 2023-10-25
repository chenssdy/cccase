<template>
    <div id="my-home">
        <div class="partition-list" v-for="item in list" :key="item.id">
            <div class="item">
                <div class="partition-name">
                    <span>
                        {{ item.name }}
                    </span>
                </div>

                <div class="case-list">
                    <div class="case" v-for="caseItem in item.cases" :key="caseItem.id" 
                        @mouseenter="caseItem.hover = true"
                        @mouseleave="caseItem.hover = false"
                        @click="onCase(caseItem)">

                        <div class="img-box">
                            <div class="cover-img" :class="{ 'animated' : caseItem.hover }">
                                <img :src="caseItem.coverUrl" alt="">
                            </div>
                            <div class="back-img">
                                <img :src="caseItem.backgroundUrl" alt="">
                            </div>
                        </div>

                        <div class="case-name">
                            {{ caseItem.name }}
                        </div>

                        <div class="case-price">
                            <img src="../../public/icon/gold.svg" alt="">
                            {{ caseItem.price }}
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</template>
    
<script setup>
import { ref, reactive } from 'vue'
import { getPartition } from '../api/home'
import { login } from '../api/user'
import router from '@/router/router'
import { store } from '@/store/store'
import {setToken } from '../util/auth'

let _list = null;

let list = ref([]);

getPartition().then(e => {

    _list = e.data;

    console.log(_list)

    list.value = _list;

    console.log(list)
})

function onCase(_case){
    router.push('/ruolette')
    store.case = reactive(_case);
}

login().then(res => {
    store.user = reactive(res.data);

    setToken(store.user.token);
});

</script>
  

<style scoped lang="less">
@keyframes _animated {
    0% {
        transform: translate(0, 0);
    }

    50% {
        transform: translate(0px, -15px);
    }


    100% {
        transform: translate(0px, 0px);
    }
}

#my-home {
    height: 100%;
    width: 100%;
    background-color: #090909;

    .partition-list {
        width: 80%;
        margin: 0 auto;

        .item {
            margin-top: 128px;

            .case-list {
                display: flex;
                flex-flow: wrap;
                justify-content: space-between;
                margin-top: 32px;

                .case {
                    width: 250px;
                    position: relative;
                    // height: 182px;
                    margin: 0 24px;
                    margin-bottom: 24px;
                    cursor: pointer;

                    .img-box {
                        position: relative;
                        height: 182px;
                        width: 250px;

                        .back-img {
                            position: absolute;
                            width: 100%;
                            height: 100%;

                            img {
                                width: 250px;
                                height: 182px;
                            }

                        }

                        .animated {
                            animation: _animated 3s infinite;
                        }

                        .cover-img {
                            position: absolute;
                            z-index: 2;
                            width: 100%;
                            height: 100%;

                            img {
                                width: 250px;
                                height: 182px;
                            }
                        }
                    }

                    .case-name {
                        text-align: center;
                        margin-top: 12px;
                        font-size: 16px;
                    }

                    .case-price {
                        font-size: 24px;
                        margin-top: 12px;
                        display: flex;
                        align-items: center;
                        justify-content: center;
                        color: #FFC402 !important;

                        img {
                            width: 24px;
                            height: 24px;
                            margin-right: 6px;
                        }
                    }
                }
            }

            .partition-name {
                span {
                    color: #FFC402 !important;
                    font-size: 32px;
                    position: relative;

                }

                span::before {
                    content: "";
                    width: 80%;
                    height: 1px;
                    position: absolute;
                    bottom: -20%;
                    left: 10%;
                    border-bottom: 1px solid #937341;
                }

                text-align: center;
            }
        }
    }
}
</style>
    