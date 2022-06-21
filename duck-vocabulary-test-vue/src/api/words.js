import request from '../utils/request';

export const getWordsByPage = (data) => {
  return request('/word/getWords', 'post', data)
}