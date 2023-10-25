// store.js
import { reactive } from 'vue'

export const store = reactive({
  user: {
    name: '',
    balance: 0
  },
  caseId: 0,
  case: {},
  getUserName(){
    if(this.user.name === '') return '未登录';

    return user.name;
  },
  getUserBalance(){
    if(this.user.name === '') return '0';

    return user.balance;
  }
})