<template>
  <div class="words-page">
    <div class="words-page-top">
      <a-button style="margin-left: 12px" type="primary" v-for="(item, index) in list" :key="index" @click="toggle(index+1)">{{item}}</a-button>
    </div>
    <div class="words-page-bottom">
      <a-table :columns="columns" @change="onChange" :dataSource="dataList" :pagination="pagination"></a-table>
    </div>
  </div>
</template>

<script>
import {getWordsByPage} from '../../api/words';
export default {
  name: 'Words',
  data() {
    const columns = [
      {
        title: 'word',
        dataIndex: 'word',
        key: 'word',
        ellipsis: true,
        width: 200,
      },
      {
        title: 'mean',
        dataIndex: 'mean',
        key: 'mean',
        ellipsis: true,
      },
      
    ]
    return {
      form: {
        number: 10,
        page: 1,
        // 默认初中词汇
        status: 1
      },
      list: ['初中词汇', '高中词汇', '专四词汇', '专八词汇'],
      data: [],
      columns,
      pagination: {
        current: 1,
        pageSize: 10,
        total: 1987,
        showTotal: (total) => `包含内容 ${total} 条`,
        showSizeChanger: true,
      },
    }
  },
  methods: {
    getWords(data) {
      getWordsByPage(data).then(res => {
        if(res.code !== 200) return this.$message.error('获取数据失败!')
        this.data = res.data 
      })
    },
    toggle(index) {
      this.form.status = index
      if(index === 2) this.pagination.total = 1924
      if(index === 3) this.pagination.total = 3491
      if(index === 4) this.pagination.total = 5480
      this.getWords(this.form)
    },
    onChange (changePagination, filters, sorter) {
        const { current, pageSize } = changePagination;
        this.form.number = pageSize
        this.form.page = current
        this.getWords(this.form)
      },
  },
  computed: {
    dataList() {
      const newData = []
      const oldData = this.data
      oldData.forEach(item => {
        newData.push({
          word: item.word,
          mean: item.mean,
          key: item.word,
        })
      })
      return newData
    }
  },
  created() {
    this.getWords(this.form)
  }
}
</script>

<style lang='less'>
.words-page {
  width: 100%;
  height: calc(100vh - 192px);
  &-top {
    margin-top: 24px;
    display: flex;
    justify-content: center;
    align-items: center;
    margin-bottom: 24px;
  }
  &-bottom {
    height: calc(100vh - 248px);
    overflow: auto;
    margin-bottom: 24px;
    .ant-pagination {
      margin-bottom: 100px;
    }
  }
}
</style>