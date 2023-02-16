<template>
  <v-col cols="12" md="3" sm="3">
    <v-select :items="filterConditionsByType[criteria.filterType]"
              label="Condition"
              v-model="criteria.condition"
              required></v-select>
  </v-col>
</template>

<script>
import {filterConditionsByType, stringRepresentation} from "@/types/FiltersConditions";

export default {
  name: "FilterConditionInput",
  beforeMount() {
    for (let type in filterConditionsByType) {
      const conditions = filterConditionsByType[type];
      this.filterConditionsByType[type] = [];
      conditions.forEach(c => {
        this.filterConditionsByType[type].push({
          value: c,
          text: stringRepresentation[c]
        });
      });
    }
  },
  data() {
    return {
      filterConditionsByType: {},
    }
  },
  props: {
    criteria: {filterType: String, condition: String, value: Number | String | Date}
  }
}
</script>

<style scoped>

</style>
