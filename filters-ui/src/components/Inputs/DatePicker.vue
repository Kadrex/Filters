<template>
  <v-menu
      ref="menu"
      v-model="menu"
      :close-on-content-click="false"
      :return-value.sync="criteria.value"
      transition="scale-transition"
      offset-y
      min-width="auto">
    <template v-slot:activator="{ on, attrs }">
      <validation-provider v-slot="{ errors }" name="Value" rules="required">
        <v-text-field
            v-model="criteria.value"
            label="Value"
            readonly
            :error-messages="errors"
            v-bind="attrs"
            v-on="on"
        ></v-text-field>
      </validation-provider>
    </template>
    <v-date-picker
        v-model="criteria.value"
        no-title
        scrollable>
      <v-spacer></v-spacer>
      <v-btn
          text
          color="primary"
          @click="menu = false">
        Cancel
      </v-btn>
      <v-btn
          text
          color="primary"
          @click="$refs.menu.save(criteria.value)">
        OK
      </v-btn>
    </v-date-picker>
  </v-menu>
</template>

<script>
// https://vuetifyjs.com/en/components/date-pickers/#dialog-and-menu

import {extend, setInteractionMode, ValidationProvider} from "vee-validate";
import {required} from "vee-validate/dist/rules";

setInteractionMode('eager');

extend('required', {
  ...required,
  message: '{_field_} can not be empty.'
});

export default {
  name: "DatePicker",
  components: { ValidationProvider },
  data() {
    return {
      menu: false,
      modal: false,
      menu2: false
    }
  },
  props: {
    criteria: {filterType: String, condition: String, value: Number | String | Date},
  }
}
</script>

<style scoped>

</style>
