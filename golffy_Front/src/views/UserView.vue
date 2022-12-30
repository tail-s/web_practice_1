<template>
  <div>
    <h2>User</h2>
    <login-form v-if="check"></login-form>
    <user-detail v-else></user-detail>
  </div>
</template>

<script>
import loginForm from "@/components/user/LoginForm.vue";
import userDetail from "@/components/user/UserDetail.vue";

export default {
  name: "UserView",
  data() {
    return {
      check: true,
    };
  },
  components: {
    loginForm,
    userDetail,
  },
  created() {
    if (localStorage.getItem("user_id") != undefined) {
      this.check = false;
    }
  },
};
</script>

<style></style>
