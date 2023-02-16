<template>
  <v-col cols="12" md="3" sm="3">
    <validation-provider v-slot="{ errors }" name="Select" rules="required">
      <v-select
          :items="filterTypes"
          :error-messages="errors"
          label="Type"
          v-model="criteria.filterType"
          @change="inputChanged"
          required
      ></v-select>
    </validation-provider>
  </v-col>
</template>

<script>
import {filterConditionsByType, filterTypes, stringRepresentation} from "@/types/FiltersConditions";
import {extend, setInteractionMode, ValidationProvider} from "vee-validate";
import {required} from "vee-validate/dist/rules";

setInteractionMode('eager');
extend('required', {
  ...required,
  message: '{_field_} can not be empty.'
});

export default {
  name: "FilterTypeInput",
  components: {ValidationProvider},
  mounted() {
    filterTypes.forEach(ft => {
      this.filterTypes.push({
        value: ft,
        text: stringRepresentation[ft]
      });
    });
  },
  data() {
    return {
      filterTypes: [],
    }
  },
  props: {
    criteria: {filterType: String, condition: String, value: Number | String | Date}
  },
  methods: {
    inputChanged() {
      this.criteria.condition = filterConditionsByType[this.criteria.filterType][0];
      this.criteria.value = undefined;
    }
  }
}
</script>

<style scoped>

</style>
