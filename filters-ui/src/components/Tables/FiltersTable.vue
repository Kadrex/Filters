<template>
  <div class="ma-auto table-container mt-6 mx-xl-15 mx-lg-10 mx-md-7 mx-sm-0">
    <v-data-table id="filters-table"
                  :headers="headers"
                  :items="filters"
                  :loading="loading"
                  :loading-text="'Loading... Please wait.'"
                  show-expand
                  :single-expand="true"
                  :expanded.sync="expanded">
      <template v-slot:expanded-item="{ headers, item }">
        <td :colspan="headers.length" class="py-5 criteria-table">
          <FiltersCriteriaTable :criteria-list="item.criteria"></FiltersCriteriaTable>
        </td>
      </template>
    </v-data-table>
  </div>
</template>

<script>
import FiltersCriteriaTable from "@/components/Tables/FiltersCriteriaTable";
export default {
  name: "FiltersTable",
  components: {FiltersCriteriaTable},
  props: {
    loading: Boolean,
    filters: Array
  },
  data() {
    return {
      headers: [
        {
          text: 'Filter name',
          value: 'filterName'
        },
        {
          text: 'Criteria count',
          value: 'criteria.length'
        },
        {
          text: 'Selection',
          value: 'selection'
        },
        {
          text: '', value: 'data-table-expand'
        }
      ],
      expanded: []
    }
  },
}
</script>

<style scoped lang="scss">

.table-container {
  max-width: 1000px;
}

::v-deep #filters-table {
  .v-data-table__expanded {
    background-color: #eeeeee !important;
  }

  tr {
    line-break: anywhere;

    td {
      max-width: 500px;
    }
  }
}

.criteria-table {
  background-color: #eeeeee;
}
</style>
