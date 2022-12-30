<template>
  <div>
    <write-form type="create" />
  </div>
</template>

<script>
import WriteForm from "@/components/board/include/WriteForm.vue";

export default {
  name: "BoardCreate",
  components: {
    WriteForm,
  },
};
</script>
