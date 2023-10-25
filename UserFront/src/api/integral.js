import request from "../util/request"

export function getIEAccessories() {
    return request({
      url: 'api/integralExchange/get',
      method: 'get',
      headers: {
        isToken: true
      },
    });
}

export function exchange(ieId) {
  return request({
    url: `api/integralExchange/exchange/${ieId}`,
    method: 'post',
    headers: {
      isToken: true
    },
  });
}
