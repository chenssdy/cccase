import request from "../util/request"

// 登录方法
export function login() {
    return request({
        url: 'api/login',
        method: 'post',
        data: {
            "account": "111111",
            "password": "1"
        },
        headers: {
            isToken: false
        },
    });
}

export function userOpenCase(caseId) {
    return request({
        url: `api/openCase/openCase/${caseId}`,
        method: 'post',
        headers: {
            isToken: true
        },
    });
}

export function exchangeAcc(accId){
    return request({
        url: `api/user/accExchangeBalance/${accId}`,
        method: 'post',
        headers: {
            isToken: true
        },
    });
}

export function getUser(){
    return request({
        url: `api/user/get`,
        method: 'get',
        headers: {
            isToken: true
        },
    });
}
