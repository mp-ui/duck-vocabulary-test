<template>
  <div class="rank-page">
    <a-table :columns="columns" :dataSource="data" bordered :pagination="pagination">
      <img class="rank-page-img" :src="record.avatar" slot="avatar" slot-scope="text, record">
    </a-table>
  </div>
</template>

<script>
import {getRank} from '../../api/rank';
export default {
  name: 'Rank',
  data() {
    const columns = [
      {
        title: '名次',
        dataIndex: 'rank',
        key: 'rank',
        ellipsis: true,
        width: 100
      },
      {
        title: '头像',
        dataIndex: 'avatar',
        key: 'avatar',
        ellipsis: true,
        scopedSlots: { customRender: 'avatar' },
        width: 70,
      },
      {
        title: '名字',
        dataIndex: 'nickName',
        key: 'nickName',
        ellipsis: true,
      },
      {
        title: '做对题数',
        dataIndex: 'rightCount',
        key: 'rightCount',
        ellipsis: true,
      },
      {
        title: '分数',
        dataIndex: 'score',
        key: 'score',
        ellipsis: true,
      },
    ]
    return {
      rankList: [],
      columns,
      list: [],
      pagination: {
        current: 1,
        pageSize: 10,
        total: 0,
        showTotal: (total) => `包含内容 ${total} 条`,
        showSizeChanger: true,
      },
    }
  },
  methods: {
    getRankList() {
      getRank().then(res => {
        if(res.code !== 200) return this.$message.error('排行版数据获取失败')
        this.list = res.data
        this.pagination.total = this.list.length
      }) 
    }
  },
  computed: {
    data() {
      let newData = []
      const list = this.list.sort((a, b) => {
        console.log(a, b)
        return b.score - a.score
      })
      let i = 1
      list.forEach(item => {
        newData.push({
          ...item,
          key: item.nickName,
          rank: i++
        })
      })
      return newData
    }
  },
  created() {
    this.getRankList()
  }
}
</script>

<style lang="less">
.rank-page {
  &-img {
    width: 30px;
    height: 30px;
    background-size: cover;
    border-radius: 50%;
  }
}
</style>