<template>
  <v-row justify="center">
    <v-dialog v-model="dialog"
              persistent
              aria-modal="false"
              max-width="900px">

      <!-- "Open dialog" button -->
      <template v-slot:activator="{ on, attrs }">
        <v-btn color="primary"
               class="my-3"
               dark
               v-bind="attrs"
               v-on="on">
          Add a filter
        </v-btn>
      </template>

      <!-- Dialog -->
      <NewFilterForm @saved="afterSave" @close="close"></NewFilterForm>
    </v-dialog>
  </v-row>
</template>

<script>
import NewFilterForm from "@/components/FormViews/NewFilterForm";

export default {
  name: "NewFilterDialog",
  components: {NewFilterForm},
  data() {
    return {
      dialog: false
    }
  },
  methods: {
    close() {
      this.dialog = false;
    },

    afterSave() {
      this.$parent.refreshTable();
      this.close();
    },
  }
}
</script>

<style scoped>

</style>
