<template>
  <div class="app-footer">
    <div class="app-footer-sponsor">
      <div style="width: 20px;">贡献者</div>
      <div class="app-footer-sponsor-name" v-for="item in name" :key="item">
        {{item}}
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "AppFooter",
  data() {
    return {
      name: [
        '|   |   |',
        '陈宏儒',
        '戴志海',
        '黄康伦',
        '李志坤',
        '甘洪雨',
        '吴永滔'
      ]
    }
  },
};
</script>

<style lang="less">
.app-footer {
  height: 96px;
  padding: 0 48px;
  width: calc(100% - 200px);
  background-color: #58b;
  display: flex;
  position: absolute;
  bottom: 0;
  left: 100px;
  border-radius: 0 0 8px 8px;
  box-shadow: 6px 6px 6px rgba(55, 88, bb, .1);
  &-sponsor {
    display: flex;
    margin: 0 auto;
    justify-content: space-around;
    font-family:"华文楷体";  /*设置字体*/
		width:336px;    /*设置元素宽度*/
		font-size: 20px;  /*设置文字大小*/
		color:green;  /*设置文字颜色*/
		text-align: center; /*设置文字居中*/
    background:lightblue;
		border:1px solid #CCCCCC;  /*设置元素边框*/
		box-shadow:1px 1px 3px #999999;  /*设置边框阴影*/
    &-name {
      width: 24px;
      height: 100%;
    }
  }
}
</style>
