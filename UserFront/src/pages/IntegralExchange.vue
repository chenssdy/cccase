<template>
    <div id="integral-exchange">
        <div class="center">
            <div class="ie-header">
                <div class="user-integral">
                    <img src="../../public/icon/user-integral.svg" alt="">
                    <span>{{ store.user.integral }}</span>
                </div>

                <div class="list-sort">
                    <span>价格</span>
                    <img src="../../public/icon/sort.svg" alt="">
                </div>
                <div style="flex: 1 1 auto;">

                </div>
                <div class="search-input">
                    <input type="text">

                    <div class="search">
                        搜索
                    </div>
                </div>
            </div>

            <div class="list-box">
                <div class="list-item" v-for="item in iEAccessories" :key="item.id">
                    <div class="acc-item acc-item-5">
                        <img :src="item.accessoriesVo.imgUrl" alt="" class="acc-item-img">
                        <div class="acc-item-name">{{ item.accessoriesVo.name }}</div>
                    </div>

                    <div class="exchange" @click="userExchange(item)">
                        <img src="../../public/icon/user-integral.svg" alt="">
                        <span>{{ item.integral }}</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
    
<script setup>
import { store } from '@/store/store'
import { ref } from 'vue'
import { getIEAccessories, exchange } from '../api/integral'
import { getUser } from '../api/user'
import { ElMessage, ElMessageBox } from 'element-plus'


const accQuality = [',', 'acc-item-1', 'acc-item-2', 'acc-item-3', 'acc-item-4', 'acc-item-5']

let iEAccessories = ref([])

getIEAccessories().then(res => {
    iEAccessories.value = res.data;
})

let userExchange = (item) => {

    ElMessageBox.confirm(
        '你确定要兑换该饰品吗?',
        '兑换饰品',
        {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            center: true,
        }
    )
    .then(() => {

        exchange(item.id).then(res => {
            ElMessage({
                type: 'success',
                message: '兑换成功',
            })

            getUser().then(res => {
                store.user = res.data;
            });
        })
    })
    .catch(() => {

    })


};

</script>
  

<style scoped lang="less">
#integral-exchange {
    background-color: #090909;

    .center {
        width: 80%;
        margin: 0 auto;

        .list-box {
            background-color: #0E1018;
            display: flex;
            flex-flow: wrap;
            padding: 32px 32px;

            .list-item {
                margin-right: 20px;

                .exchange {
                    width: 164px;
                    height: 24px;
                    background: #282B35;
                    display: flex;
                    justify-content: center;
                    align-items: center;
                    cursor: pointer;

                    span {
                        margin-left: 4px;
                    }

                }

                .acc-item-5 {
                    background: linear-gradient(180deg, rgba(0, 0, 0, 0.00) 0%, rgba(255, 67, 67, 0.30) 100%);
                    border-color: #C24A4A;
                }

                .acc-item-4 {
                    background: linear-gradient(180deg, rgba(0, 0, 0, 0.00) 0%, rgba(212, 2, 118, 0.30) 100%);
                    border-color: #C24AA6;
                }

                .acc-item-3 {
                    background: linear-gradient(180deg, rgba(0, 0, 0, 0.00) 0%, rgba(192, 67, 255, 0.30) 100%);
                    border-color: #824AC2;
                }

                .acc-item-2 {
                    background: linear-gradient(180deg, rgba(0, 0, 0, 0.00) 0%, rgba(101, 67, 255, 0.30) 100%);
                    border-color: #4A4CC2;
                }

                .acc-item-1 {
                    background: linear-gradient(180deg, rgba(0, 0, 0, 0.00) 0%, rgba(231, 231, 231, 0.30) 100%);
                    border-color: #818181;
                }

                .acc-item {
                    width: 164px;
                    height: 114px;

                    box-sizing: border-box;
                    border-width: 0px 0px 2px 0px;
                    border-style: solid;

                    display: flex;
                    flex-direction: column;
                    align-items: center;

                    .acc-item-img {
                        height: 76px;
                        width: 116px;
                        margin-top: 12px;
                    }

                    .acc-item-name {
                        font-size: 14px;
                    }
                }


            }


        }

        .ie-header {
            height: 48px;
            background-color: #0E1018;
            margin: 48px 0;

            display: flex;
            align-items: center;

            .search-input {
                display: flex;
                margin-right: 128px;

                input {
                    outline: none;
                    border: none;
                    background-color: #1B1B1B;
                    padding-left: 12px;
                    height: 20px;
                    border-radius: 4px;
                }

                .search {
                    width: 36px;
                    height: 20px;
                    border-radius: 4px;
                    box-sizing: border-box;
                    border: 1px solid #2B98FF;
                    font-size: 14px;
                    text-align: center;
                    line-height: 20px;
                    margin-left: 12px;
                }
            }

            .list-sort {
                font-size: 18px;
                width: 72px;
                height: 24px;
                background-color: #252434;

                border-radius: 24px;
                display: flex;
                align-items: center;
                position: relative;
                margin-left: 64px;

                span {
                    font-size: 16px;
                    margin-left: 10px;
                }

                img {
                    width: 16px;
                    position: absolute;
                    height: 16px;
                    right: 10px;
                }
            }

            .user-integral {
                font-size: 18px;
                margin-left: 24px;
                height: 18px;
                display: flex;
                align-items: center;

                span {
                    color: #FFBB00;
                    margin-left: 6px;
                    line-height: 16px;

                }

                img {
                    width: 18px;
                    height: 18px;
                }
            }

        }
    }
}
</style>
    