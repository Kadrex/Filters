<template>
  <div class="py-10 d-flex justify-center mx-auto page-container">
    <div>
      <!-- Modal/Non-modal mode switch -->
      <div class="d-flex justify-center">
        <v-switch v-model="modal" :label="mode">
        </v-switch>
      </div>
      <NewFilterDialog v-if="modal"></NewFilterDialog>
      <NewFilterNonModal v-else></NewFilterNonModal>
      <FiltersTable :loading="loading" :filters="filters"></FiltersTable>
    </div>
  </div>
</template>

<script>
import NewFilterDialog from "@/components/FormViews/NewFilterDialog";
import FiltersTable from "@/components/Tables/FiltersTable";
import NewFilterNonModal from "@/components/FormViews/NewFilterNonModal";

export default {
  name: "FiltersHomepage",
  components: {NewFilterNonModal, FiltersTable, NewFilterDialog},
  mounted() {
    this.getFilters();
  },
  data() {
    return {
      dialog: false,
      loading: true,
      modal: true,
      filters: []
    }
  },
  methods: {
    getFilters() {
      this.$store
          .dispatch("filters/fetchAll")
          .then(response => {
            this.filters = response.data;
            this.loading = false;
          })
          .catch(error => {
            console.log(error);
          })
    },
    refreshTable() {
      this.filters = [];
      this.loading = true;
      this.getFilters();
    }
  },
  computed: {
    mode() {
      return this.modal ? "Modal" : "Non-modal";
    }
  }
}
</script>

<style scoped lang="scss">

.page-container {
  background-color: #f9f9f9;
  height: 100%
}

@media (max-width: 950px) {
  .page-container {
    width: 100%;
  }
}

</style>
