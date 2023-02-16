<template>
  <v-col cols="12" md="3" sm="3">

    <validation-provider v-if="criteria.filterType === 'AMOUNT'"
                         v-slot="{ errors }" name="Value" rules="required|max:255">
      <v-text-field label="Value"
                    type="number"
                    v-model.number="criteria.value"
                    :error-messages="errors"
                    required
      ></v-text-field>
    </validation-provider>

    <validation-provider v-if="criteria.filterType === 'TITLE'"
                         v-slot="{ errors }" name="Value" rules="required|max:255">
      <v-text-field label="Value"
                    v-model="criteria.value"
                    :error-messages="errors"
                    required></v-text-field>
    </validation-provider>

    <DatePicker v-if="criteria.filterType === 'DATE'" :criteria="criteria"></DatePicker>

  </v-col>
</template>

<script>
import DatePick from 'vue-date-pick';
import DatePicker from "@/components/Inputs/DatePicker";
import {extend, setInteractionMode, ValidationProvider} from "vee-validate";
import {max, required} from "vee-validate/dist/rules";

setInteractionMode('eager');

extend('required', {
  ...required,
  message: '{_field_} can not be empty.'
});

extend('max', {
  ...max,
  message: '{_field_} may not be longer than {length} digits.'
});

export default {
  components: {DatePicker, DatePick, ValidationProvider},
  name: "FilterValueInput",
  props: {
    criteria: {filterType: String, condition: String, value: Number | String | Date},
  }
}
</script>

<style scoped>

</style>
