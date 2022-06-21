import request from '../utils/request';

export const login = (loginForm) => {
  return request('/user/login', 'post', loginForm)
}

export const register = (registerForm) => {
  return request('/user/register', 'post', registerForm)
}

export const getCode = (email) => {
  return request('/user/getCode', 'get', {email})
}