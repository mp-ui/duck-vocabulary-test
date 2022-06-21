<template>
  <div class="home-page">
    <AppHeader></AppHeader>
    <router-view></router-view>
    <AppFooter></AppFooter>
  </div>
</template>

<script>
export default {
  name: "Home",
  created() {
    if(!JSON.parse(sessionStorage.getItem("userInfo"))) {
      this.$router.replace('/login')
    }
  },
};
</script>

<style lang="less">
.home-page {
  width: 100%;
  height: 100%;
  overflow: hidden;
}
</style>
