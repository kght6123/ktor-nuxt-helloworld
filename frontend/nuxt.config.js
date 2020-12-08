export default {
  // Disable server-side rendering (https://go.nuxtjs.dev/ssr-mode)
  ssr: false,

  // Global page headers (https://go.nuxtjs.dev/config-head)
  head: {
    title: 'ktor-nuxt-helloworld-frontend',
    meta: [
      { charset: 'utf-8' },
      { name: 'viewport', content: 'width=device-width, initial-scale=1' },
      { hid: 'description', name: 'description', content: '' },
    ],
    link: [{ rel: 'icon', type: 'image/x-icon', href: '/favicon.ico' }],
  },

  // Global CSS (https://go.nuxtjs.dev/config-css)
  css: [],

  // Plugins to run before rendering page (https://go.nuxtjs.dev/config-plugins)
  plugins: [],

  // Auto import components (https://go.nuxtjs.dev/config-components)
  components: true,

  // Modules for dev and build (recommended) (https://go.nuxtjs.dev/config-modules)
  buildModules: [
    // https://go.nuxtjs.dev/tailwindcss
    '@nuxtjs/tailwindcss',
  ],

  // Modules (https://go.nuxtjs.dev/config-modules)
  modules: [
    // https://go.nuxtjs.dev/axios
    '@nuxtjs/axios',
    // '@nuxtjs/proxy',
  ],

  // Axios module configuration (https://go.nuxtjs.dev/config-axios)
  axios: {
    // proxy: true,
    baseURL: 'http://localhost:8080',
  },
  // proxyの問題点
  // kght6123@air backend % curl -X GET http://localhost:3000/api/
  // HELLO%
  // kght6123@air backend % curl -X GET http://localhost:3000/api/hello/
  // Error occured while trying to proxy to: localhost:3000/api/hello/

  // server: {
  //   port: 3000,
  //   host: '0.0.0.0',
  // },

  // proxy: {
  //   '/api/': 'http://127.0.0.1:8080/',
  //   // '/api/': {
  //   //   // target: 'http://localhost:8080',
  //   //   target: 'http://localhost:8080',
  //   //   secure: false,
  //   //   logLevel: 'debug',
  //   //   changeOrigin: true,
  //   //   pathRewrite: { '^/api': '' },
  //   // },
  // },

  // Build Configuration (https://go.nuxtjs.dev/config-build)
  build: {},
}
