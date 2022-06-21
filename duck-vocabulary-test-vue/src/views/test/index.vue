<template>
  <div class="test-page">
<transition name="modal-fade">
  <div class="test-page" v-show="isSelect">
    <div class="test-page-title">{{number}}、{{res.word}}</div>
    <div class="test-page-content">
      <div class="test-page-content-item" v-for="(item, index) in currentList" :key="index" @click="select(index+1)">{{item}}</div>
    </div>
    <div class="test-page-no" @click="select(0)">不认识</div>
  </div>
</transition>
    <transition name="left">
    <img v-if="xiaoliuya" src="../../assets/image/1.gif" />
    </transition>
    <transition name="right">
    <img v-if="xiaoliuya" src="../../assets/image/1.gif" />
    </transition>
  </div>
</template>

<script>
import {testWord} from '../../api/test';
export default {
  name: 'Test',
  data() {
    return {
      info: {},
      answerNum: 0,
      number: 0,
      currentList: [],
      res: {},
      continuityError: 0,
      totalError: 0,
      isSelect: true,
      xiaoliuya: false
    }
  },
  methods: {
    select(index) {
      let answerIndex;

      answerIndex = this.currentList.findIndex(item => {
        return item === this.res.answer
      })
      if(index === answerIndex+1) {
        this.xiaoliuya = true
      }else {
        this.xiaoliuya = false
      }
      // if(index !== answerIndex) {
      //   this.continuityError++
      //   this.totalError++
      // }else {
      //   this.continuityError = 0
      // }
      setTimeout(() => {
        this.xiaoliuya = false
      }, 1000)
      this.answerNum++
      this.info.num++
      this.info.score = this.res.score
      this.info.wrong = this.totalError
      this.info.ctnwrong = this.continuityError
      this.info.option = index
      this.info.answer = answerIndex + 1
      this.isSelect = false
      setTimeout(() => {
        testWord(this.info).then(res => {
          console.log(res.data)
          console.log(this.info)
          if(res.code === 200) {
            if(this.answerNum === 21) {
              this.answerNum = 0
              this.isSelect = false
              this.res = {}
              this.continuityError = 0
              this.totalError = 0
              this.info = {}
              this.number = 0
              this.currentList = []
              this.$message.success({
                content: `您的词汇量大约为 ${res.data.score}!`,
                duration: 8,
              })
            }else {
              this.totalError = res.data.wrong
              this.continuityError = res.data.ctnwrong
              this.res = res.data
              this.number++
              this.isSelect = true
              const oldData = this.res
              const newData = [oldData.option1, oldData.option2, oldData.option3, oldData.answer]
              this.currentList = newData.sort(function() {
                return Math.random() - 0.5
              })
            }
          }
        })
      }, 600)
    }
  },
  created() {
    const userInfo = JSON.parse(sessionStorage.getItem('userInfo'))
    let user;
    if(userInfo) user = userInfo.user
    this.info = {
      id: user.uid,
      num: 0,
    }
    testWord(this.info).then(res => {
      if(res.code === 200) {
        this.res = res.data
        this.answerNum++
        const oldData = this.res
        this.number++
        const newData = [oldData.option1, oldData.option2, oldData.option3, oldData.answer]
        this.currentList = newData.sort(() => {
          return Math.random() - 0.5
        })
      }
    })
  }
}
</script>

<style lang="less">
.test-page {
  height: calc(100% - 192px);
  width: 100%;
  &-title {
    font-size: 48px;
    display: flex;
    justify-content: center;
    align-items: center;
    margin: 36px 0;
  }
  &-content {
    display: flex;
    justify-content: space-around;
    align-items: center;
    flex-wrap: wrap;
    &-item {
      flex: 1 1 40%;
      display: flex;
      justify-content: center;
      line-height: 48px;
      border-radius: 3em;
      border: #607EF4 1px solid;
      margin-top: 30px;
      margin-left: 30px;
      margin-right: 30px;
      padding-left: 20px;
      padding-right: 20px;
      &:hover {
        background-color: #7CC8FB;
      }
    }
  }
  &-no {
    display: flex;
    justify-content: center;
    align-items: center;
    line-height: 48px;
    border-radius: 3em;
    border: #607EF4 1px solid ;
    margin-top: 30px;
    margin-left: 200px;
    margin-right: 200px;

    &:hover {
      background-color: #7CC8FB;
    }
  }
  img {
    position: absolute;
    bottom: 150px;
    width: 100px;
    height: 100px;
    left: 800px;
  }
  img:first-of-type {
    transform: rotateY(180deg);
    position: absolute;
    bottom: 150px;
    left: 700px;
  }
  .left-enter-active, .left-leave-active{
    transition: all 0.5s ease;
    transform: translateX(0);
  }
  .left-enter, .left-leave-active {
    opacity: 0;
    transform: translateX(-1500%) !important;
  }
  .right-enter-active, .right-leave-active{
    transition: all 0.5s ease;
    transform: translateX(0);
  }
  .right-enter, .right-leave-active {
    opacity: 0;
    transform: translateX(1500%);
  }
}

.modal-fade-enter-active, .modal-fade-leave-active{
    transition: all 0.5s ease;
    transform: translateX(0);
}
.modal-fade-enter, .modal-fade-leave-active {
    opacity: 0;
    transform: translateX(150%);
}
</style>
