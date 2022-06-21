<template>
  <div class="app-header">
    <div class="app-header-title">英语词汇测试</div>
<!--    <div class="app-header-content">-->
<!--      <div class="app-header-content-child">-->
<!--        初中词汇-->
<!--      </div>-->
<!--      <div class="app-header-content-child">-->
<!--        高中词汇-->
<!--      </div>-->
<!--      <div class="app-header-content-child">-->
<!--        专四词汇-->
<!--      </div>-->
<!--      <div class="app-header-content-child">-->
<!--        专八词汇-->
<!--      </div>-->
<!--    </div>-->
    <div class="app-header-userinfo">
      <img :src="userInfo.avatar">
      <span>
        {{userInfo.nickname ? `${userInfo.nickname}` : '未登陆'}}
      </span>
      <a-popconfirm title="确定退出？" okText="确定" cancelText="取消" @confirm="logout">
        <a-icon slot="icon" type="question-circle-o" style="color: red"  />
        <a href="#" style="color: black;">退出</a>
      </a-popconfirm>
    </div>
  </div>
</template>

<script>
export default {
  name: "AppHeader",
  data() {
    return {
      userInfo: {},
    }
  },
  methods: {
    toggle() {

    },
    logout() {
      sessionStorage.setItem('userInfo', null)
      this.$router.push('/login');
    }
  },
  created() {
    this.userInfo = JSON.parse(sessionStorage.getItem('userInfo')).user || {}
  },

};
</script>

<style lang="less">
.app-header {
  height: 96px;
  padding: 0 48px;
  width: 100%;
  background-color: #58b;
  display: flex;
  border-radius: 8px 8px 0 0 ;
  &-title {
    text-align: center;
    line-height: 100px;
    width: 368px;
    color: #4EE46D;
    font-size: 48px;
  }
  &-content {
    flex: 1;
    display: flex;
    justify-content: space-around;
    align-items: center;
    &-child {
      border-left: 1px solid #4EE46D;
      padding-left: 8px;
      font-size: 30px;
      color: #fefefe;
      text-shadow: 0 0 0.5em #0ae642, 0 0 0.2em #5c5c5c;
      transition: all .3s;
      &:hover {
        font-size: 40px;
      }
    }
  }
  &-userinfo {
    width: 200px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    img {
      width: 30px;
      height: 30px;
      background-color: aqua;
      border-radius: 50%;
    }
    &-logout {
      width: 60px;
      line-height: 20px;
      border-radius: 50%;
      background-color: aquamarine;
      padding-left: 4px;
    }
  }
  .app-header-userinfo {
    margin-left: 600px;
  }
}
</style>
