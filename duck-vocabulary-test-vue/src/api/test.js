import request from '../utils/request';

export const testWord = (info) => {
  return request('/test/estimate', 'post', info)
}