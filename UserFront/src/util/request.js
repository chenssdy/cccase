import axios from 'axios'
import { ElMessage, ElMessageBox, ElNotification } from 'element-plus'
import { getToken, removeToken } from '@/util/auth'
import { store } from '@/store/store'

axios.defaults.headers['Content-Type'] = 'application/json;charset=utf-8'
// 创建axios实例
const service = axios.create({
  // axios中请求配置有baseURL选项，表示请求URL公共部分
  baseURL: process.env.VUE_APP_BASE_API,
  // 超时
  timeout: 20000
})
// request拦截器
service.interceptors.request.use(config => {
  // 是否需要设置 token
  const isToken = (config.headers || {}).isToken === false
  if (getToken() && !isToken) {
    config.headers['token'] = getToken() // 让每个请求携带自定义token 请根据实际情况自行修改
  }
  // get请求映射params参数
  // if (config.method === 'get' && config.params) {
  //   let url = config.url + '?';
  //   for (const propName of Object.keys(config.params)) {
  //     const value = config.params[propName];
  //     var part = encodeURIComponent(propName) + "=";
  //     if (value !== null && typeof (value) !== "undefined") {
  //       if (typeof value === 'object') {
  //         for (const key of Object.keys(value)) {
  //           if (value[key] !== null && typeof (value[key]) !== 'undefined') {
  //             let params = propName + '[' + key + ']';
  //             let subPart = encodeURIComponent(params) + '=';
  //             url += subPart + encodeURIComponent(value[key]) + '&';
  //           }
  //         }
  //       } else {
  //         url += part + encodeURIComponent(value) + "&";
  //       }
  //     }
  //   }
  //   url = url.slice(0, -1);
  //   config.params = {};
  //   config.url = url;
  // }
  return config
}, error => {
  console.log(error)
  Promise.reject(error)
})

// 响应拦截器
service.interceptors.response.use(res => {
  const code = res.data.code || 2001;

  const msg = res.data.message;
  console.log(res)
  if (ElMessageBox === 5003) {
    ElMessageBox.confirm('执行该操作请先登录~', '提示', {
      confirmButtonText: '重新登录',
      cancelButtonText: '取消',
      type: 'warning'
    }
    ).then(() => {
      removeToken();
      store.user = {};
    }).catch(() => { });

  } else if (code === 5002) {
    ElMessageBox.confirm('拉取用户登录状态失败，请重新登录', '提示', {
      confirmButtonText: '重新登录',
      cancelButtonText: '取消',
      type: 'warning'
    }
    ).then(() => {
      removeToken();
      store.user = {};
    }).catch(() => { });

  } else if (code === 5001) {
    ElMessage({
      showClose: true,
      message: msg,
      type: 'error'
    })
    return Promise.reject(new Error(msg))
  } else if (code === 2002) {
    ElMessage({
      showClose: true,
      message: msg,
      type: 'error'
    })
  } else if (code !== 2001) {
    ElNotification({
      title: "msg",
      message: msg,
      type: 'error',
    })
    return Promise.reject('error')
  } else {
    return res.data
  }
},
  error => {
    console.log('err' + error)
    let { message } = error;
    if (message == "Network Error") {
      message = "后端接口连接异常";
    }
    else if (message.includes("timeout")) {
      message = "系统接口请求超时";
    }
    else if (message.includes("Request failed with status code")) {
      message = "系统接口" + message.substr(message.length - 3) + "异常";
    }
    ElMessage({
      showClose: true,
      message: message,
      type: 'error'
    })
    return Promise.reject(error)
  }
)

export default service
