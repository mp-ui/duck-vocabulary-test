// 扩展vue原有的功能：全局组件、自定义指令等
// import XtxSkeleton from './xtx-skeleton.vue'
// import XtxCarousel from './xtx-carousel.vue';
// import XtxMore from './xtx-more.vue'
// import XtxBread from './xtx-bread.vue'
// import XtxBreadItem from './xtx-bread-item.vue';

// 使用require得context方法，第一个参数是目录名称，第二个参数是否找子目录，第三个是文件的后缀，用正则
const importFn = require.context('./', false, /\.vue$/)
// 加载失败后的默认图片
export default {
    install(Vue) {
        // 在app实例上进行扩展，app提供component、directive，不提供原型
        //如果要挂载原型就要app.config.globalProperties，这个替换了prototype
        // app.component(XtxSkeleton.name, XtxSkeleton)
        // app.component(XtxCarousel.name, XtxCarousel)
        // app.component(XtxMore.name, XtxMore)
        // app.component(XtxBread.name, XtxBread)
        // app.component(XtxBreadItem.name, XtxBreadItem)

        //根据keys批量操作
        importFn.keys().forEach(path => {
            // default导出的就是export default的情况，
            // importFn会根据路径去找到文件，然后通过default找到export default上的东西然后进行注册
            const component = importFn(path).default
            // 注册逐渐
            Vue.component(component.name, component)
        })

        // 懒加载指令
        // difineDirective(app)
        // 注册消息提示方法
        // app.config.globalProperties.$message = Message
    }
}
//定义指令
// const difineDirective = (app) => {
//     //定义图片懒加载指令
//     // 把图片地址存储起来，先存储图片地址，但是不能在src下，当图片进入可视区，将图片的地址设置给元素即可
//     app.directive('lazyload', {
//         // vue3.0的指令拥有的钩子函数和组件一样，DOM是否创建好，可以用mounted钩子
//         mounted(el, binding) { //el是使用了该指令的DOM，binding就是指令传递过来的值
//             //创建一个观察对象，来观察使用当前指令的元素是否进入可视区
//             const observe = new IntersectionObserver(([{isIntersecting}]) => {
//                 // isIntersecting就进入可视区
//                 if(isIntersecting) {
//                     // 进入可视区后立刻停止观察
//                     observe.unobserve(el)
//                     // 若图片加载失败
//                     el.onerror = () => {
//                         el.src = defaultImg
//                     }
//                     // 把指令的值设置给el的src属性
//                     el.src = binding.value
//                 }
//             },
//             {
//                 threshold: 0
//             })
//             // 开启观察图片是否进入可视区
//             observe.observe(el)
//         },
//     })
// }