import request from '../utils/request';

export const getRank = () => {
  return request('/rankingList/getRankingList', 'get')
}