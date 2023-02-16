<template>
  <v-simple-table dense>
    <template v-slot:top>
      <div class="table-title">
        Criteria
      </div>
      <v-divider class=" mx-auto mb-3"></v-divider>
    </template>
    <template v-slot:default>
      <thead>
      <tr>
        <th>Type</th>
        <th>Condition</th>
        <th>Value</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="criteria in criteriaList">
        <td>{{stringRepresentation[criteria.filterType]}}</td>
        <td>{{stringRepresentation[criteria.condition]}}</td>
        <td>{{criteria.value}}</td>
      </tr>
      </tbody>
    </template>
  </v-simple-table>
</template>

<script>
import {stringRepresentation} from "@/types/FiltersConditions";

export default {
  name: "FiltersCriteriaTable",
  data() {
    return {
      stringRepresentation: stringRepresentation
    }
  },
  props: {
    criteriaList: {filterName: String, criteria: Array}
  }
}
</script>
<style scoped>

.table-title {
  padding-left: 16px;
  font-weight: 500;
  padding-top: 10px;
  padding-bottom: 10px;
  text-align: center;
}

td {
  min-width: 100px;
}

.v-divider {
  width: 90%;
  border-color: black;
}

</style>
