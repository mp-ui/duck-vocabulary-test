import axios from 'axios';
import router from '@/router/index';
const baseURL = '/';
const instance = axios.create({
  // 根路径
  baseURL,
  // 超过5秒就请求失败
  timeout: 5000,
  widthCredentials: true,
  // headers: {
  //   'Content-Type': 'application/json',
  // }
})

instance.interceptors.request.use(config => {
  //导出存储在user中的用户信息
  const userInfo = JSON.parse(sessionStorage.getItem('userInfo')) || {}
  //判断本地是否有token，如果有token就带上
  if(userInfo.token) {
    config.headers.authorization = `${userInfo.token}`
  }
  return config
},err => {
  return Promise.reject(err)
})

instance.interceptors.response.use(res => res.data, err => { //如果返回数据，则直接返回数据，否则返回错误信息
  //401状态码
  if(err.response && err.status == '401') {
      //登陆无效后，token就没有效了，剩下的东西也没有必要留着
      sessionStorage.setItem('userInfo', null);
      // 然后跳转到登陆的页面，因为信息已经没有用了，需要重新登陆，并且需要通过携带参数到登陆的路由，登陆成功后直接跳转到回跳的地址
      // 组件里头 `/user? a=10`，使用route.path只能获取到/user，所以需要使用route.fullPath能得到/user?a=10   
      // 在js模块中可以通过router.currentRoute.value.fullPath就是当前的路由地址，需要通过.value是因为这是vue3里面，获取基本数据类型的数据是需要通过.value的形式获取的
      const fullPath = encodeURIComponent(router.currentRoute.fullPath) //这里因为有?特殊字符，所以需要转码 
      // encodeURIComponent 用于转换为url字符
      router.push(`/login?redirecUrl=${fullPath}`)
  }
})
export default (url, method, submitDate) => {
  return instance({
      url,
      method,
      // params参数?a=10&b=20
      // []里面可以写js表达式，里面的值就是key，如果是get请求的时候用params参数，其他的就是data
      [method.toLowerCase() === 'get' ? `params` : 'data']: submitDate
      // [dataMethod]: submitDate
  })
}