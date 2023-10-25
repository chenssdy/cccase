import request from "../util/request"

// 登录方法
export function getPartition() {
    return request({
      url: 'api/partition/get',
      method: 'get',
      headers: {
        isToken: false
      },
    });
}


export function getCaseAcc(caseId){
  return request({
    url: `api/case/getCaseAccById/${caseId}`,
    method: 'get',
    headers: {
      isToken: false
    },
  });
}