const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave: false,

  devServer: {
    proxy: {
        '/api': {
            target: 'http://localhost:8082', // 对应自己的接口
            changeOrigin: true,
            ws: true,
            pathRewrite: {
                '^/api': '',
            },
        },
    },
},
})
