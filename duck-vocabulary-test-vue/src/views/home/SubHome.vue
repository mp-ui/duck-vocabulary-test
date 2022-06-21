<template>
  <div class="sub-home-page">
    <div class="sub-home-page-panel">
      <div class="sub-home-page-panel-item" ref="child1" @click="toggle(1)">测试</div>
      <div class="sub-home-page-panel-item" ref="child2" @click="toggle(2)">排行榜</div>
      <div class="sub-home-page-panel-item" ref="child3" @click="toggle(3)">单词查看</div>
    </div>
    <div class="sub-home-page-content">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
export default {
  name: 'sub-home',
  methods: {
    toggle(flag) {
      this.$refs.child1.style.backgroundColor = ''
      this.$refs.child2.style.backgroundColor = ''
      this.$refs.child3.style.backgroundColor = ''
      this.$refs[`child${flag}`].style.backgroundColor = '#2AA5F8'
      if(flag === 1 && this.$router.currentRoute.fullPath !== '/sub-home/test') {
        return this.$router.push('/sub-home/test')
      }else if(flag === 2 && this.$router.currentRoute.fullPath !== '/sub-home/rank') {
        return this.$router.push('/sub-home/rank')
      }else if(flag === 3 && this.$router.currentRoute.fullPath !== '/sub-home/words') {
        return this.$router.push('/sub-home/words')
      }
    }
  }
}
</script>

<style lang='less'>
.sub-home-page {
  display: flex;
  background-color: #58b;
  border-radius: 1px;
  border: 1px #55DDDD solid;
  height: calc(100vh - 192px);
  &-panel {
    width: 196px;
    border-right: 1px solid #020;

    &-item {
      width: 100%;
      line-height: 48px;
      font-size: 30px;
      transition: all .2s;
      padding-left: 24px;
      &:hover {
        padding-left: 48px;
        background-color: #E98EC4;
      }
    }
  }
  &-content {
    flex: 1;
    height: calc(100vh - 192px);
    background-color: #FFF8DD;

  }
  .sub-home-page-panel-item {
    margin-top: 20px;
  }
}
</style>
