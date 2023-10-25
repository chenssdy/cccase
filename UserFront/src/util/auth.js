import Cookies from 'js-cookie'

const TokenKey = 'Admin-Token'

export function getToken() {
  return Cookies.get(TokenKey)
}

export function setToken(token) {
  return Cookies.set(TokenKey, token)
}

export function removeToken() {
  window.history.pushState({}, '', '/#/login');
  window.location.reload();
  return Cookies.remove(TokenKey)
}
