<template>
    <div id="ruolette">
        <div class="center">
            <div class="name">
                {{ store.case.name }}
            </div>

            <div class="ruolette-body">
                <div class="left">
                    <img src="../../public/icon/frame-roulette.svg" alt="">
                </div>

                <div class="body">
                    <div class="img-body" :class="{ 'hide': openIn }">
                        <img :src="store.case.coverUrl" alt="" class="img-body-cover">
                        <img :src="store.case.backgroundUrl" alt="">
                    </div>

                    <div class="open-case-ing" :class="{ 'hide': !openIn }">
                        <div class="ruolette-ing" :class="{ 'open-case-run': runing }">
                            <div class="ruolette-ing-item" v-for="(openItem, index) in openAccs" :key="index"
                                :class="accQuality[openItem.quality]">
                                <img :src="openItem.imgUrl" alt="" class="ruolette-ing-item-img">
                                <div class="ruolette-ing-item-name">{{ openItem.name }}</div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="right">
                    <img src="../../public/icon/frame-roulette.svg" alt="">
                </div>
            </div>

            <div class="buttom">
                <div class="center-buttom" @click="openCase()">
                    <img src="../../public/icon/gold.svg" alt="">
                    <span>{{ store.case.price }}</span>
                </div>
            </div>


            <div class="case-acc-list">
                <div class="case-title">
                    盲盒中的物品
                </div>

                <div class="case-acc-list-box">
                    <div v-for="item in accs" :key="item.id" class="item" :class="caseAccListItem[item.quality]">
                        <div class="img-box">
                            <img :src="item.imgUrl" alt="">
                        </div>
                        <div class="acc-name">
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
                </div>
            </div>
        </div>

        <div class="user-open-out-acc"
            :class="{ 'show-model': showModel }, userOpenCaseQuality[openAcc.accessories.quality]">
            <div class="user-open-out-acc-wear">
                {{ openAcc.accessories.wearStr }}
            </div>
            <div class="user-open-out-acc-img">
                <img :src="openAcc.accessories.imgUrl" alt="">
            </div>
            <div class="user-open-out-acc-name">
                {{ openAcc.accessories.name }}
            </div>
            <div class="user-open-out-acc-option">
                <div class="user-open-out-acc-continue" @click="continueOpenCase()">
                    继续
                </div>
                <div class="user-open-out-acc-exchange" @click="exchange()">
                    <img src="../../public/icon/gold.svg" alt="">
                    <span>{{ openAcc.accessories.price }}</span>
                </div>
            </div>
        </div>

        <div class="model" :class="{ 'show-model': showModel }">

        </div>
    </div>
</template>
    
<script setup>
import { ref, reactive } from 'vue'
import { store } from '@/store/store'
import { getCaseAcc } from '../api/home'
import { userOpenCase, exchangeAcc } from '../api/user'

const accQuality = [',', 'ruolette-ing-item-1', 'ruolette-ing-item-2', 'ruolette-ing-item-3', 'ruolette-ing-item-4', 'ruolette-ing-item-5']

const userOpenCaseQuality = ref([',', 'user-open-case-1', 'user-open-case-2', 'user-open-case-3', 'user-open-case-4', 'user-open-case-5'])

const caseAccListItem = ref([',','item-1','item-2','item-3','item-4','item-5'])

let accs = ref([])

let openIn = ref(false)

let runing = ref(false);

getCaseAcc(store.case.id).then(res => {
    accs.value = res.data.map(e => {
        let index = e.name.indexOf('|');

        e.fname = e.name.slice(0, index);
        e.lname = e.name.slice(index + 1);

        return e;
    })
});


let openAccs = ref([]);

let openAcc = ref({
    accessories: {
        id: 1,
        name: 'AK-47 | 野荷',
        wearStr: '略有磨损',
        imgUrl: 'http://localhost:8082/img/2.png',
        price: 88.8
    }
});

function exchange() {
    exchangeAcc(openAcc.value.backpackId).then(res => {
        store.user = reactive(res.data)
        continueOpenCase()
        console.log(res)
    });
}

function openCase() {

    userOpenCase(store.case.id).then(res => {
        generateAccs();

        openAcc.value = res.data;

        openAccs.value[50] = res.data.accessories;

        console.log(openAcc.value)
        console.log(openAccs.value)

        runAni();
    });
}

function runAni() {
    openIn.value = true;
    runing.value = true;

    setTimeout((e) => {
        showAcc();

        openIn.value = false;
        runing.value = false;
    }, 15000);
}

let showModel = ref(false)

function showAcc() {
    showModel.value = true;
}

function continueOpenCase() {
    showModel.value = false;
}

function generateAccs() {
    for (let i = 0; i < 100; i++) {

        let random = Math.floor(Math.random() * accs.value.length);

        openAccs.value.push(accs.value[random]);
    }
}

</script>
  

<style scoped lang="less">
@keyframes runing {
    0% {
        left: 0;
    }

    98% {
        left: calc(-144px * 48);
    }

    100% {
        left: calc(-144px * 48);
    }
}

#ruolette {
    background-color: #060218;
    color: #eee;



    .user-open-out-acc {
        display: none;
        text-align: center;


        .user-open-out-acc-option {
            display: flex;
            justify-content: center;

            .user-open-out-acc-continue {
                width: 128px;
                height: 36px;
                border-radius: 36px;
                opacity: 1;

                background: rgba(57, 95, 250, 0.3);
                margin-right: 64px;
                text-align: center;
                line-height: 36px;
                font-size: 18px;
                cursor: pointer;
            }

            .user-open-out-acc-exchange {
                cursor: pointer;
                width: 128px;
                height: 36px;
                border-radius: 36px;
                opacity: 1;

                background: rgba(170, 170, 170, 0.3);
                font-size: 18px;

                display: flex;
                justify-content: center;
                align-items: center;

                img {
                    width: 18px;
                    height: 18px;
                    margin-right: 2px;
                }

                span {
                    height: 18px;
                }
            }
        }

        .user-open-out-acc-name {
            font-size: 28px;
            margin-top: 12px;
            margin-bottom: 32px;
        }

        .user-open-out-acc-wear {
            font-size: 24px;
            margin-top: 24px;
            margin-bottom: 24px;
        }

        .user-open-out-acc-img {
            img {
                width: 310px;
                height: 194px;
            }
        }

        position: fixed;
        left: calc(50% - 303px);
        top: calc(50% - 225px);
        width: 606px;
        height: 450px;
        border-radius: 9px;
        opacity: 1;

        background: linear-gradient(180deg, rgba(101, 67, 255, 0.80) 0%, rgba(64, 14, 190, 0.20) 100%);

        box-sizing: border-box;
        border-width: 10px 0px 0px 0px;
        border-style: solid;
        border-color: #4966F9;
        z-index: 1000;
    }

    .show-model {
        display: block !important;
    }

    .model {
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100vh;
        background-color: rgba(0, 0, 0, 0.8);
        z-index: 999;
        display: none;
    }

    .open-case-run {
        animation: runing 15s .5s;
    }

    .center {
        width: 80%;
        margin: 0 auto;
        text-align: center;

        .case-acc-list {
            text-align: start;
            font-size: 18px;

            .case-acc-list-box {
                display: flex;
                margin-top: 24px;
                flex-flow: wrap;

                .item::before {
                    content: "";
                    position: absolute;
                    left: 0;
                    top: 0;
                    z-index: 2;
                    width: 1px;
                    height: 100%;
                }

                .item-1 {
                    background: linear-gradient(77.06deg,rgba(86,126,171,.2) .78%,rgba(32,34,43,0) 48.5%);
                }
                .item-1::before{
                    background: linear-gradient(180deg, transparent, #818181 50%, transparent);
                }

                .item-2 {
                    background: linear-gradient(77.06deg, rgba(56, 76, 172, .2) .78%, rgba(32, 34, 43, 0) 48.5%);
                }
                .item-2::before{
                    background: linear-gradient(180deg, transparent, #384cac 50%, transparent);
                }

                .item-3 {
                    background: linear-gradient(77.06deg,rgba(93,55,170,.2) .78%,rgba(32,34,43,0) 48.5%);
                }
                .item-3::before{
                    background: linear-gradient(180deg,transparent,#5d37aa 50%,transparent);
                }

                .item-4 {
                    background: linear-gradient(77.06deg,rgba(211,44,230,.2) .78%,rgba(32,34,43,0) 48.5%);
                }
                .item-4::before{
                    background: linear-gradient(180deg,transparent,#d32ce6 50%,transparent);
                }

                .item-5 {
                    background: linear-gradient(77.06deg, rgba(235, 75, 75, .2) .78%, rgba(32, 34, 43, 0) 48.5%);
                }
                .item-5::before{
                    background: linear-gradient(180deg, transparent, #eb4b4b 50%, transparent);

                }

                .item {
                    border: 1px solid #19162C;
                    border-radius: 3px;
                    margin-right: 8px;
                    position: relative;
                    width: 180px;
                    height: 92px;

                    font-size: 14px;
                    border-left: 1px solid #20222c;
                    margin-bottom: 12px;

                    .img-box {
                        width: 180px;
                        height: 92px;
                        display: flex;
                        align-items: center;

                        img {
                            width: 88px;
                            height: 56px;
                            margin: 0 auto;
                        }

                    }

                    .acc-name {
                        position: absolute;
                        bottom: 2px;
                        left: 6px;
                        // font-size: 12px;
                    }

                    .wear {
                        position: absolute;
                        right: 6px;
                        bottom: 2px;
                        opacity: 0.8;
                    }
                }
            }

            .case-title {
                line-height: 32px;
                border-bottom: 1px solid #201D40;
            }

            margin-bottom: 128px;
        }

        .buttom {
            display: flex;
            align-items: center;
            justify-content: center;

            .center-buttom {
                cursor: pointer;
                width: 188px !important;
                height: 40px;
                background-color: #290952;
                border-radius: 48px;
                display: flex;
                justify-content: center;
                align-items: center;
                margin-bottom: 48px;

                img {
                    width: 24px;
                    height: 24px;
                }

                span {
                    line-height: 32px;
                }
            }
        }

        .ruolette-body {
            display: flex;
            margin-bottom: 64px;



            .left {
                height: 212px;
                width: 138px;
                margin-left: 128px;
            }

            .right {
                margin-right: 128px;
                transform: rotateZ(180deg);
            }

            .left,
            .right {
                img {
                    height: 212px;
                    width: 138px;
                }
            }

            .body::before {
                content: "";
                position: absolute;
                top: -20px;
                width: 94px;
                height: 48px;
                background-image: url('../../public/icon/pointer.svg');
            }

            .body::after {
                content: "";
                position: absolute;
                bottom: -20px;
                width: 94px;
                height: 48px;
                background-image: url('../../public/icon/pointer.svg');
                transform: rotateZ(180deg);
            }

            .body {
                position: relative;
                display: flex;
                align-items: center;
                flex: 1 1 auto;
                justify-content: center;
                border-top: 1px solid #16142B;
                border-bottom: 1px solid #16142B;

                .open-case-ing {
                    height: 80px;
                    width: calc(144px * 5);
                    overflow: hidden;

                    .ruolette-ing {
                        width: 100%;
                        white-space: nowrap;
                        position: relative;

                        .ruolette-ing-item-5 {
                            background: linear-gradient(180deg, rgba(0, 0, 0, 0.00) 0%, rgba(255, 67, 67, 0.30) 100%);
                            border-color: #C24A4A;
                        }

                        .ruolette-ing-item-4 {
                            background: linear-gradient(180deg, rgba(0, 0, 0, 0.00) 0%, rgba(212, 2, 118, 0.30) 100%);
                            border-color: #C24AA6;
                        }

                        .ruolette-ing-item-3 {
                            background: linear-gradient(180deg, rgba(0, 0, 0, 0.00) 0%, rgba(192, 67, 255, 0.30) 100%);
                            border-color: #824AC2;
                        }

                        .ruolette-ing-item-2 {
                            background: linear-gradient(180deg, rgba(0, 0, 0, 0.00) 0%, rgba(101, 67, 255, 0.30) 100%);
                            border-color: #4A4CC2;
                        }

                        .ruolette-ing-item-1 {
                            background: linear-gradient(180deg, rgba(0, 0, 0, 0.00) 0%, rgba(231, 231, 231, 0.30) 100%);
                            border-color: #818181;
                        }

                        .ruolette-ing-item {
                            display: inline-block;
                            width: 144px;
                            height: 80px;

                            box-sizing: border-box;
                            border-width: 0px 0px 2px 0px;
                            border-style: solid;

                            .ruolette-ing-item-img {
                                height: 60px;
                                width: 96px;

                            }

                            .ruolette-ing-item-name {
                                font-size: 14px;
                            }
                        }
                    }
                }

                .hide {
                    display: none;
                }

                .img-body {
                    position: relative;
                    width: 206px;
                    height: 150px;

                    .img-body-cover {
                        z-index: 2;
                    }

                    img {
                        position: absolute;
                        top: 0;
                        left: 0;
                        height: 150px;
                        width: 100%;
                    }
                }
            }
        }

        .name {
            margin-top: 64px;
            margin-bottom: 24px;
            font-size: 24px;
        }
    }

    .user-open-case-1 {
        background: linear-gradient(180deg, rgba(129, 129, 129, 0.80) 0%, rgba(42, 26, 59, 0.20) 100%);
        box-sizing: border-box;
        border-width: 10px 0px 0px 0px;
        border-style: solid;
        border-color: #818181;
    }

    .user-open-case-2 {
        background: linear-gradient(180deg, rgba(101, 67, 255, 0.80) 0%, rgba(64, 14, 190, 0.20) 100%);
        box-sizing: border-box;
        border-width: 10px 0px 0px 0px;
        border-style: solid;
        border-color: #4966F9;
    }

    .user-open-case-3 {
        background: linear-gradient(180deg, rgba(130, 74, 194, 0.80) 0%, rgba(50, 31, 71, 0.20) 100%);
        box-sizing: border-box;
        border-width: 10px 0px 0px 0px;
        border-style: solid;
        border-color: #824AC2;
    }

    .user-open-case-4 {
        background: linear-gradient(180deg, rgba(194, 74, 166, 0.80) 0%, rgba(73, 31, 63, 0.20) 100%);
        box-sizing: border-box;
        border-width: 10px 0px 0px 0px;
        border-style: solid;
        border-color: #C24AA6;
    }

    .user-open-case-5 {
        background: linear-gradient(180deg, rgba(194, 74, 74, 0.80) 0%, rgba(70, 39, 39, 0.20) 100%);
        box-sizing: border-box;
        border-width: 10px 0px 0px 0px;
        border-style: solid;
        border-color: #C24A4A;
    }
}</style>
    