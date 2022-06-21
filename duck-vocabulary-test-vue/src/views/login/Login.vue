<template>
  <div class="login-page">
    <div class="login-page-title">
      {{ isLogin ? "英语词汇测试登陆" : "英语词汇测试注册" }}
    </div>
    <div class="login-page-form">
      <div>
        <a-form-model
          v-if="isLogin"
          :model="loginForm"
          @submit.native.prevent
          ref="loginFormRef"
          :rules="loginFormRules"
        >
          <a-form-model-item prop="email">
            <a-input v-model="loginForm.email" placeholder="Email" allowClear>
              <a-icon
                slot="prefix"
                type="mail"
                style="color: rgba(0, 0, 0, 0.25)"
              />
            </a-input>
          </a-form-model-item>
          <a-form-model-item prop="password">
            <a-input v-model="loginForm.password" placeholder="Password" type="password" allowClear>
              <a-icon
                slot="prefix"
                type="lock"
                style="color: rgba(0, 0, 0, 0.25)"
              />
            </a-input>
          </a-form-model-item>
          <a-form-model-item>
            <a-button
              type="primary"
              html-type="submit"
              :disabled="loginForm.email === '' || loginForm.password === ''"
              style="margin-left: 196px"
              @click="login"
            >
              登陆
            </a-button>
            <a-button
              style="margin-left: 12px"
              type="primary"
              @click="isLogin = false"
              >注册</a-button
            >
          </a-form-model-item>
        </a-form-model>
      </div>
      <div v-if="!isLogin">
        <a-button type="dashed" icon="left" shape="circle" size="small" @click="toggleLogin"></a-button>
        <a-form-model
          :model="registerForm"
          @submit="register"
          @submit.native.prevent
          ref="registerFormRef"
          style="margin-top: 6px"
          :rules="registerFormRules"
        >
          <a-form-model-item prop="email">
            <a-input v-model="registerForm.email" placeholder="Email">
              <a-icon
                slot="prefix"
                type="mail"
                style="color: rgba(0, 0, 0, 0.25)"
              />
            </a-input>
          </a-form-model-item>
          <a-form-model-item prop="password">
            <a-input v-model="registerForm.password" placeholder="Password" type="password">
              <a-icon
                slot="prefix"
                type="lock"
                style="color: rgba(0, 0, 0, 0.25)"
              />
            </a-input>
          </a-form-model-item>
          <a-form-model-item prop="nickName">
            <a-input v-model="registerForm.nickName" placeholder="NickName">
              <a-icon
                slot="prefix"
                type="user"
                style="color: rgba(0, 0, 0, 0.25)"
              />
            </a-input>
          </a-form-model-item>
          <a-form-model-item prop="gender">
            <a-select
              v-model="registerForm.gender"
              placeholder="pleace select gender"
            >
              <a-select-option key="1" :value="1">男</a-select-option>
              <a-select-option key="2" :value="2">女</a-select-option>
            </a-select>
          </a-form-model-item>
          <a-form-model-item prop="code">
            <a-input
              v-model="registerForm.code"
              placeholder="Code"
              style="width: 112px"
            >
              <a-icon
                slot="prefix"
                type="code"
                style="color: rgba(0, 0, 0, 0.25)"
              />
            </a-input>
            <a-button type="primary" style="margin: 0 12px" @click="getCode">获取验证码</a-button
            >
          </a-form-model-item>
          <a-form-model-item>
            <a-button
              type="primary"
              html-type="submit"
              :disabled="
                registerForm.email === '' ||
                registerForm.password === '' ||
                registerForm.nickName === '' ||
                registerForm.gender === '' ||
                registerForm.code === ''
              "
              style="margin-left: 196px"
            >
              注册
            </a-button>
            <a-button
              type="primary"
              @click="resetForm('registerFormRef')"
              style="margin-left: 12px"
            >
              重置
            </a-button>
          </a-form-model-item>
        </a-form-model>
      </div>
    </div>
  </div>
</template>

<script>
import {getCode, register, login} from '../../api/login';
export default {
  name: "Login",
  data() {
    const email = [
      {
        pattern: /^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/,
        message: '邮箱格式不正确',
        trigger: 'blur',
      },
      {
        max: 50,
        message: '邮箱不得超过50字符',
        trigger: 'change'
      },
      {
        required: true,
        message: '请输入邮箱',
        trigger: 'blur',
      }
    ]
    const password = [
      {
        min: 6,
        max: 18,
        message: '密码在6-18位之间',
        trigger: 'blur'
      },
      {
        required: true,
        message: '请输入密码',
        trigger: 'blur',
      }
    ]
    const nickName = [
      {
        min: 1,
        max: 12,
        message: '用户名在1-12个字符',
        trigger: 'blur',
      },
      {
        required: true,
        message: '请输入用户名',
        trigger: 'blur',
      }
    ]
    const gender = [
      {
        required: true,
        message: '请选择性别',
        trigger: 'blur',
      }
    ]
    const code = [
      {
        required: true,
        message: '请输入验证码',
        trigger: 'blur',
      },
      {
        min: 4,
        max: 4,
        message: '请输入4位有效验证码',
        trigger: 'blur',
      }
    ]
    const loginFormRules = {
      email,
      password,
    }
    const registerFormRules = {
      email,
      password,
      gender,
      code,
      nickName,
    }
    return {
      loginForm: {
        email: "",
        password: "",
      },
      isLogin: true,
      registerForm: {
        email: "",
        password: "",
        nickName: "",
        gender: "",
        code: "",
      },
      loginFormRules,
      registerFormRules
    };
  },
  methods: {
    // 登陆
    login() {
      this.$refs.loginFormRef.validate(valid => {
        if(!valid) {
          return this.$message.error('验证未通过')
        }
          login(this.loginForm).then(res => {
            if(res.code !== 200) {
              return this.$message.error('登陆失败，请稍后尝试')
            }
            const redirect = this.$route.params
            sessionStorage.setItem('userInfo', JSON.stringify(res.data));
            this.$message.success('登陆成功')
            setTimeout(() => {
              this.$router.push('/')
            }, 500)
          }, err => {
            this.$message.error(err)
          })
      })
    },
    // 重置表单
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    // 注册
    register() {
      this.$refs.registerFormRef.validate(valid => {
        if(!valid) {
          return this.$message.error('Please complete the complete form!')
        }
        register(this.registerForm).then(res => {
          if(res.code !== 200) {
            return this.$message.error('注册失败！')
          }
          sessionStorage.setItem('userInfo', JSON.stringify(res.data))
          this.resetForm('registerFormRef')
          this.isLogin = !this.isLogin;
        }, err => {
          this.$message.error(err)
        })
      })
    },
    // 切换登录
    toggleLogin() {
      this.isLogin = true;
      this.$refs.registerFormRef.resetFields();
    },
    // 获取验证码
    getCode() {
      if(!this.registerForm.email) {
        return this.$message.error('Please fill in your email address first!')
      }
      this.$message.success('Please check your email!')
      getCode(this.registerForm.email)
    }
  },
};
</script>

<style lang="less">
.login-page {
  background-color: #FFF8DD;
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
  padding-top: 76px;
  &-title {
    text-align: center;
    line-height: 100px;
    width: 400px;
    color: #5588bb;
    font-size: 48px;
  }
  &-form {
    width: 400px;
    border-radius: 8px;
    border: 1px solid #ccc;
    padding: 24px;
    box-shadow: 0 0 5px 3px rgba(0, 0, 0, 0.1);
  }
}
</style>
