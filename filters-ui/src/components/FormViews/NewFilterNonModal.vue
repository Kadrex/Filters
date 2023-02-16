<template>
  <div class="d-flex justify-center">
    <v-btn v-if="!showFilterForm"
           color="primary"
           @click="showFilterForm = true"
           dark>
      Add a filter
    </v-btn>

    <div v-if="showFilterForm" class="mx-xl-15 mx-lg-10 mx-md-7 mx-sm-0" style="max-width: 770px">
      <NewFilterForm @saved="afterSave" @close="showFilterForm = false"></NewFilterForm>
    </div>
  </div>
</template>

<script>
import NewFilterForm from "@/components/FormViews/NewFilterForm";
export default {
  name: "NewFilterNonModal",
  components: {NewFilterForm},
  data() {
    return {
      showFilterForm: false
    }
  },
  methods: {
    afterSave() {
      this.showFilterForm = false;
      this.$parent.refreshTable();
    }
  }
}
</script>

<style scoped>

</style>
