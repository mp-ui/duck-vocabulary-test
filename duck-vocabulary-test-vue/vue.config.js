const path = require('path')
module.exports = {
  lintOnSave: false,
  devServer: {
    port: 3001,
    open: true,
    proxy: {
      "/": {
        // target: 'http://120.24.80.48:8090/',
        target: 'http://localhost:8090/',
        changeOrigin: true,
        ws: true,
        secure: false,
        pathRewrite: {
          '^/': '/',        //重写,
        }
      },
    }
  },
  pluginOptions: {
    'style-resources-loader': {
      preProcessor: 'less',
      // 哪些文件自动导入，使用绝对路径
      patterns: [
        path.join(__dirname, './src/assets/styles/mixins.less'),
        path.join(__dirname, './src/assets/styles/variables.less')
      ]
    }
  },
}
