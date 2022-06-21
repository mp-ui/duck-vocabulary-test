import Vue from 'vue'
import Antd from 'ant-design-vue'

const {
  Button,
  Layout,
  FormModel,
  Form,
  Input,
  Icon,
  Select,
  message,
  Popconfirm,
  Table
} = Antd
Vue.prototype.$message = message
Vue.use(Button)
Vue.use(Layout)
Vue.use(FormModel)
Vue.use(Form)
Vue.use(Input)
Vue.use(Icon)
Vue.use(Select)
// Vue.use(message)
Vue.use(Popconfirm)
Vue.use(Table)
